package cn.smart.mapper;

import cn.smart.entity.UploadDeviceTmp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：upload_device_tmp
 * @since 2017-05-31 14:34:35
 */
public interface UploadDeviceTmpMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-31 14:34:35
	 */
	@Delete("delete from upload_device_tmp where udt_id = #{udtId}")
	int deleteByPrimaryKey(Integer udtId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-31 14:34:35
	 */
	@Insert("insert into upload_device_tmp(device_mac,stu_name,grade ,clas) values (#{deviceMac},#{stuName},#{grade},#{clas})")
	int insert(UploadDeviceTmp record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-31 14:34:35
	 */
	int insertSelective(UploadDeviceTmp record);

	/**
	 * 按主键查询
	 * @since 2017-05-31 14:34:35
	 */
	UploadDeviceTmp selectByPrimaryKey(Integer udtId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-31 14:34:35
	 */
	int updateByPrimaryKeySelective(UploadDeviceTmp record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-31 14:34:35
	 */
	int updateByPrimaryKey(UploadDeviceTmp record);

	@Select("select udt_id, device_mac,stu_name from upload_device_tmp where grade = #{grade} and clas = #{clas}")
	@Results({
			@Result(property = "stuName",column = "stu_name"),
			@Result(property = "deviceMac",column = "device_mac"),
			@Result(property = "udtId",column = "udt_id"),
			@Result(property = "grade",column = "grade"),
			@Result(property = "clas",column = "clas")
	})
	List<UploadDeviceTmp> getDevice(@Param("grade") String grade,@Param("clas") String clas);
}