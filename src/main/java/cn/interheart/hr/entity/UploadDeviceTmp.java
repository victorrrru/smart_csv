package cn.interheart.hr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：upload_device_tmp
 * @since 2017-06-07 09:56:27
 */
@Alias("UploadDeviceTmp")
public class UploadDeviceTmp implements Serializable {
	/** udt_id --  */
	private Integer udtId;

	/** device_mac -- device mac */
	@Length(max=50,message="hr.UploadDeviceTmp.deviceMac.Length")
	private String deviceMac;

	/** grade -- 年级 */
	@Length(max=10,message="hr.UploadDeviceTmp.grade.Length")
	private String grade;

	/** clas -- 班级 */
	@Length(max=10,message="hr.UploadDeviceTmp.clas.Length")
	private String clas;

	/** stu_name -- 学生姓名 */
	@Length(max=50,message="hr.UploadDeviceTmp.stuName.Length")
	private String stuName;

	/** upload_time --  */
	@NotNull(message="hr.UploadDeviceTmp.uploadTime.NotNull")
	private Date uploadTime;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getUdtId() {
		return udtId;
	}

	/** 设置 */
	public void setUdtId(Integer udtId) {
		this.udtId = udtId;
	}

	/** 获取device mac */
	public String getDeviceMac() {
		return deviceMac;
	}

	/** 设置device mac */
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac == null ? null : deviceMac.trim();
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

	/** 获取学生姓名 */
	public String getStuName() {
		return stuName;
	}

	/** 设置学生姓名 */
	public void setStuName(String stuName) {
		this.stuName = stuName == null ? null : stuName.trim();
	}

	/** 获取 */
	public Date getUploadTime() {
		return uploadTime;
	}

	/** 设置 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	
	 * @since 2017-06-07 09:56:27
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
		UploadDeviceTmp other = (UploadDeviceTmp) that;
		return (this.getUdtId() == null ? other.getUdtId() == null : this.getUdtId().equals(other.getUdtId()))
			&& (this.getDeviceMac() == null ? other.getDeviceMac() == null : this.getDeviceMac().equals(other.getDeviceMac()))
			&& (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
			&& (this.getClas() == null ? other.getClas() == null : this.getClas().equals(other.getClas()))
			&& (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
			&& (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()));
	}

	/**
	
	 * @since 2017-06-07 09:56:27
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUdtId() == null) ? 0 : getUdtId().hashCode());
		result = prime * result + ((getDeviceMac() == null) ? 0 : getDeviceMac().hashCode());
		result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
		result = prime * result + ((getClas() == null) ? 0 : getClas().hashCode());
		result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
		result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
		return result;
	}
}