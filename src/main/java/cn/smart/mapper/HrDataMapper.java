package cn.smart.mapper;

import cn.smart.entity.HrData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：hr_data
 * @since 2017-05-31 14:34:20
 */
public interface HrDataMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-31 14:34:20
	 */
	int deleteByPrimaryKey(Long hdId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-31 14:34:20
	 */
	@Insert("insert into hr_data(stu_name,hr,upload_time,device_mac) values (#{stuName},#{hr},#{uploadTime},#{deviceMac})")
	int insert(HrData record);


	@Insert("<script>insert into hr_data(stu_name,hr,upload_time,device_mac) values" +
			"<foreach collection = \"records\" item = \"record\" separator = \",\">"+
			" (#{record.stuName},#{record.hr},#{record.uploadTime},#{record.deviceMac})"+
			"</foreach></script>"	)
	void insertBatch(@Param("records") List<HrData> records);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-31 14:34:20
	 */
	int insertSelective(HrData record);

	/**
	 * 按主键查询
	 * @since 2017-05-31 14:34:20
	 */
	HrData selectByPrimaryKey(Long hdId);

}