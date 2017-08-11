package cn.interheart.hr.service;

import cn.interheart.hr.ServiceException;
import cn.interheart.hr.entity.HrData;
import cn.interheart.hr.entity.Student;
import cn.interheart.hr.entity.UploadDeviceTmp;
import cn.interheart.hr.hr.web.DeviceDto;
import cn.interheart.hr.hr.web.HrDataDto;
import cn.interheart.hr.mapper.HrDataMapper;
import cn.interheart.hr.mapper.StudentMapper;
import cn.interheart.hr.mapper.UploadDeviceTmpMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 业务实现层 - 表：hr_data
 * @since 2017-05-31 14:34:20
 */
@Service("hrDataService")
public class HrDataService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(HrDataService.class);
	@Resource
	private HrDataMapper hrDataMapper;

	@Resource
    private StudentMapper studentMapper;
	@Resource
	private UploadDeviceTmpMapper uploadDeviceTmpMapper;
	public void insert(HrData entity) throws ServiceException {
		try {
			hrDataMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(HrData entity) throws ServiceException {
		try {
			hrDataMapper.deleteByPrimaryKey(entity.getHdId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Long> ids) throws ServiceException {
		try {
			for (Long id : ids) {
				hrDataMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public HrData findByPrimaryKey(Long hdId) throws ServiceException {
		try {
			return hrDataMapper.selectByPrimaryKey(hdId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	private Pattern pattern = Pattern.compile("^\\d+年\\d+班$");
	String[] getGradeClass(String s){
	    String[] gradeClass = new String[]{"",""};
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()){
            int gradeIndex =   s.indexOf("年");
            String grade = s.substring(0,gradeIndex);
            String clas = s.substring(gradeIndex + 1 , s.indexOf("班"));
            gradeClass[0] = grade;
            gradeClass[1] = clas;
        }
        return gradeClass;
    }

	/**
	 * 上传学生设备信息
	 * @param originalFilename
	 * @param inputStream 文件流
	 */
	public void uploadDevice(String originalFilename, InputStream inputStream) {
		try {
		    String gradeClassStr = originalFilename.substring(0, originalFilename.lastIndexOf("."));
		    String[] gradeClass = getGradeClass(gradeClassStr);
			List<DeviceDto> list = HrDataCSVUtil.uploadDevice(inputStream);
			List<UploadDeviceTmp> devices = uploadDeviceTmpMapper.getDevice(gradeClass[0],gradeClass[1]);
			if (devices.size() != 0){
				for (UploadDeviceTmp device : devices) {
					uploadDeviceTmpMapper.deleteByPrimaryKey(device.getUdtId());
				}
			}
			list.forEach(deviceDto -> {
				UploadDeviceTmp tmp = new UploadDeviceTmp();
				tmp.setDeviceMac(deviceDto.getDeviceMac());
				tmp.setStuName(deviceDto.getStuName());
				tmp.setGrade(gradeClass[0]);
				tmp.setClas(gradeClass[1]);
                Student student = new Student();
                student.setName(deviceDto.getStuName());
                student.setGrade(gradeClass[0]);
                student.setClas(gradeClass[1]);
                student.setAge(((byte) deviceDto.getAge()));
                studentMapper.insert(student);
				uploadDeviceTmpMapper.insert(tmp);
			});
		} catch (Exception e) {
			logger.error("上传学生设备信息",e);
		}
	}

	/**
	 * 上传学生心率信息
	 * @param fileName 文件名
	 * @param inputStream 心率文件
	 */
	public void uploadData(String fileName, InputStream inputStream) {
		try {
			fileName = fileName.substring(0,fileName.lastIndexOf("."));
			String[] gradeClassDate = fileName.split("_");
			String date = gradeClassDate[1];
			Date uploadDate =  DateUtils.parseDate(date,"yyyyMMddhhmm");
			List<HrDataDto> list = HrDataCSVUtil.uploadData(inputStream);
			Map m = list.stream().collect(Collectors.toMap(HrDataDto::getStuName,HrDataDto::getHr,(existingValue, newValue) -> existingValue));
			logger.error(m.toString());
            String[] gradeClass = getGradeClass(gradeClassDate[0]);
			List<UploadDeviceTmp> devices = uploadDeviceTmpMapper.getDevice(gradeClass[0], gradeClass[1]);
			if (devices == null || devices.size() == 0){
				throw new ServiceException("先上传设备");
			}
			Map<String,String> map = devices.stream().collect(Collectors.toMap(UploadDeviceTmp::getStuName,UploadDeviceTmp::getDeviceMac,(existingValue, newValue) -> existingValue));
			logger.error(map.toString());
			List<HrData> datas = new ArrayList<>();
			list.forEach(hrDataDto -> {
				HrData hrData = new HrData();
				hrData.setHr(hrDataDto.getHr());
				hrData.setStuName(hrDataDto.getStuName());
				logger.error("长度：" + hrDataDto.getStuName().length());
				hrData.setDeviceMac(map.get(hrDataDto.getStuName()));
				logger.error("mac : "+ map.get(hrDataDto.getStuName()));
				hrData.setUploadTime(uploadDate);
				logger.error(hrData.toString());
				datas.add(hrData);
				if (datas.size() % 100 == 0) {
					hrDataMapper.insertBatch(datas);
					datas.clear();
				}
			});
			if (datas.size() > 0){
				hrDataMapper.insertBatch(datas);
				datas.clear();
			}
		} catch (Exception e) {
			logger.error("上传学生心率信息",e);
		}
	}
}