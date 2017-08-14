package cn.smart.mapper;

import cn.smart.entity.Student;
import org.apache.ibatis.annotations.Insert;

/**
 * MyBatis Mapper 接口 - 表：student
 * @since 2017-06-07 09:58:39
 */
public interface StudentMapper {
	/**
	 * 按主键删除
	 * @since 2017-06-07 09:58:39
	 */
	int deleteByPrimaryKey(Integer sId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-06-07 09:58:39
	 */
	@Insert("insert into student (name, province, city, \n" +
			"town, district, school_name, \n" +
			"grade, clas, agent, \n" +
			"id_no, age, school_roll_no, \n" +
			"height, weight)\n" +
			"values (#{name,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, \n" +
			"#{town,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, #{schoolName,jdbcType=VARCHAR}, \n" +
			"#{grade,jdbcType=VARCHAR}, #{clas,jdbcType=VARCHAR}, #{agent,jdbcType=VARCHAR}, \n" +
			"#{idNo,jdbcType=VARCHAR}, #{age,jdbcType=TINYINT}, #{schoolRollNo,jdbcType=VARCHAR}, \n" +
			"#{height,jdbcType=SMALLINT}, #{weight,jdbcType=DECIMAL})")
	int insert(Student record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-06-07 09:58:39
	 */
	int insertSelective(Student record);

	/**
	 * 按主键查询
	 * @since 2017-06-07 09:58:39
	 */
	Student selectByPrimaryKey(Integer sId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-06-07 09:58:39
	 */
	int updateByPrimaryKeySelective(Student record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-06-07 09:58:39
	 */
	int updateByPrimaryKey(Student record);

}