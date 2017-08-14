package cn.smart.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：student
 * @since 2017-06-07 09:58:39
 */
@Alias("Student")
public class Student implements Serializable {
	/** s_id -- 主键 */
	private Integer sId;

	/** name -- 学生姓名 */
	@Length(max=10,message="hr.Student.name.Length")
	private String name;

	/** province -- 学校所在省 */
	@Length(max=10,message="hr.Student.province.Length")
	private String province;

	/** city -- 学校所在市 */
	@Length(max=10,message="hr.Student.city.Length")
	private String city;

	/** town -- 学校所在乡镇街道 */
	@Length(max=10,message="hr.Student.town.Length")
	private String town;

	/** district -- 学校所在区 */
	@Length(max=10,message="hr.Student.district.Length")
	private String district;

	/** school_name -- 学校名称 */
	@Length(max=20,message="hr.Student.schoolName.Length")
	private String schoolName;

	/** grade -- 年级 */
	@Length(max=10,message="hr.Student.grade.Length")
	private String grade;

	/** clas -- 班级 */
	@Length(max=10,message="hr.Student.clas.Length")
	private String clas;

	/** agent -- 性别 */
	@Length(max=1,message="hr.Student.agent.Length")
	private String agent;

	/** id_no -- 身份证 */
	@Length(max=20,message="hr.Student.idNo.Length")
	private String idNo;

	/** age -- 年龄 */
	private Byte age;

	/** school_roll_no -- 学籍 */
	@Length(max=20,message="hr.Student.schoolRollNo.Length")
	private String schoolRollNo;

	/** height -- 身高 */
	private Short height;

	/** weight -- 体重 */
	private BigDecimal weight;

	private static final long serialVersionUID = 1L;

	/** 获取主键 */
	public Integer getsId() {
		return sId;
	}

	/** 设置主键 */
	public void setsId(Integer sId) {
		this.sId = sId;
	}

	/** 获取学生姓名 */
	public String getName() {
		return name;
	}

	/** 设置学生姓名 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取学校所在省 */
	public String getProvince() {
		return province;
	}

	/** 设置学校所在省 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/** 获取学校所在市 */
	public String getCity() {
		return city;
	}

	/** 设置学校所在市 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/** 获取学校所在乡镇街道 */
	public String getTown() {
		return town;
	}

	/** 设置学校所在乡镇街道 */
	public void setTown(String town) {
		this.town = town == null ? null : town.trim();
	}

	/** 获取学校所在区 */
	public String getDistrict() {
		return district;
	}

	/** 设置学校所在区 */
	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}

	/** 获取学校名称 */
	public String getSchoolName() {
		return schoolName;
	}

	/** 设置学校名称 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName == null ? null : schoolName.trim();
	}

	/** 获取年级 */
	public String getGrade() {
		return grade;
	}

	/** 设置年级 */
	public void setGrade(String grade) {
		this.grade = grade == null ? null : grade.trim();
	}

	/** 获取班级 */
	public String getClas() {
		return clas;
	}

	/** 设置班级 */
	public void setClas(String clas) {
		this.clas = clas == null ? null : clas.trim();
	}

	/** 获取性别 */
	public String getAgent() {
		return agent;
	}

	/** 设置性别 */
	public void setAgent(String agent) {
		this.agent = agent == null ? null : agent.trim();
	}

	/** 获取身份证 */
	public String getIdNo() {
		return idNo;
	}

	/** 设置身份证 */
	public void setIdNo(String idNo) {
		this.idNo = idNo == null ? null : idNo.trim();
	}

	/** 获取年龄 */
	public Byte getAge() {
		return age;
	}

	/** 设置年龄 */
	public void setAge(Byte age) {
		this.age = age;
	}

	/** 获取学籍 */
	public String getSchoolRollNo() {
		return schoolRollNo;
	}

	/** 设置学籍 */
	public void setSchoolRollNo(String schoolRollNo) {
		this.schoolRollNo = schoolRollNo == null ? null : schoolRollNo.trim();
	}

	/** 获取身高 */
	public Short getHeight() {
		return height;
	}

	/** 设置身高 */
	public void setHeight(Short height) {
		this.height = height;
	}

	/** 获取体重 */
	public BigDecimal getWeight() {
		return weight;
	}

	/** 设置体重 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	
	 * @since 2017-06-07 09:58:39
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Student other = (Student) that;
		return (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
			&& (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
			&& (this.getTown() == null ? other.getTown() == null : this.getTown().equals(other.getTown()))
			&& (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
			&& (this.getSchoolName() == null ? other.getSchoolName() == null : this.getSchoolName().equals(other.getSchoolName()))
			&& (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
			&& (this.getClas() == null ? other.getClas() == null : this.getClas().equals(other.getClas()))
			&& (this.getAgent() == null ? other.getAgent() == null : this.getAgent().equals(other.getAgent()))
			&& (this.getIdNo() == null ? other.getIdNo() == null : this.getIdNo().equals(other.getIdNo()))
			&& (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
			&& (this.getSchoolRollNo() == null ? other.getSchoolRollNo() == null : this.getSchoolRollNo().equals(other.getSchoolRollNo()))
			&& (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
			&& (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()));
	}

	/**
	
	 * @since 2017-06-07 09:58:39
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
		result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
		result = prime * result + ((getTown() == null) ? 0 : getTown().hashCode());
		result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
		result = prime * result + ((getSchoolName() == null) ? 0 : getSchoolName().hashCode());
		result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
		result = prime * result + ((getClas() == null) ? 0 : getClas().hashCode());
		result = prime * result + ((getAgent() == null) ? 0 : getAgent().hashCode());
		result = prime * result + ((getIdNo() == null) ? 0 : getIdNo().hashCode());
		result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
		result = prime * result + ((getSchoolRollNo() == null) ? 0 : getSchoolRollNo().hashCode());
		result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
		result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
		return result;
	}
}