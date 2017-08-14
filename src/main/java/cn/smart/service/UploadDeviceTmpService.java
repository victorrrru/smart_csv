package cn.smart.service;

import cn.smart.ServiceException;
import cn.smart.entity.UploadDeviceTmp;
import cn.smart.mapper.UploadDeviceTmpMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：upload_device_tmp
 * @since 2017-05-31 14:34:35
 */
@Service("uploadDeviceTmpService")
public class UploadDeviceTmpService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private UploadDeviceTmpMapper uploadDeviceTmpMapper;

	public void insert(UploadDeviceTmp entity) throws ServiceException {
		try {
			uploadDeviceTmpMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(UploadDeviceTmp entity) throws ServiceException {
		try {
			uploadDeviceTmpMapper.deleteByPrimaryKey(entity.getUdtId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				uploadDeviceTmpMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(UploadDeviceTmp entity) throws ServiceException {
		try {
			uploadDeviceTmpMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(UploadDeviceTmp entity) throws ServiceException {
		try {
			uploadDeviceTmpMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public UploadDeviceTmp findByPrimaryKey(Integer udtId) throws ServiceException {
		try {
			return uploadDeviceTmpMapper.selectByPrimaryKey(udtId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}