package cn.interheart.hr.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：hr_data
 * @since 2017-06-07 09:59:06
 */
@Alias("HrData")
public class HrData implements Serializable {
	/** hd_id -- 主键 */
	private Long hdId;

	/** stu_name -- 学生姓名 */
	@Length(max=50,message="hr.HrData.stuName.Length")
	private String stuName;

	/** step -- 步数 */
	private Integer step;

	/** hr -- 心率 */
	@NotNull(message="hr.HrData.hr.NotNull")
	private Integer hr;

	/** upload_time -- 上传时间 */
	@NotNull(message="hr.HrData.uploadTime.NotNull")
	private Date uploadTime;

	/** device_mac -- 设备mac */
	@NotEmpty(message="hr.HrData.deviceMac.NotEmpty")
	@Length(max=50,message="hr.HrData.deviceMac.Length")
	private String deviceMac;

	/** create_time --  */
	@NotNull(message="hr.HrData.createTime.NotNull")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	/** 获取主键 */
	public Long getHdId() {
		return hdId;
	}

	/** 设置主键 */
	public void setHdId(Long hdId) {
		this.hdId = hdId;
	}

	/** 获取学生姓名 */
	public String getStuName() {
		return stuName;
	}

	/** 设置学生姓名 */
	public void setStuName(String stuName) {
		this.stuName = stuName == null ? null : stuName.trim();
	}

	/** 获取步数 */
	public Integer getStep() {
		return step;
	}

	/** 设置步数 */
	public void setStep(Integer step) {
		this.step = step;
	}

	/** 获取心率 */
	public Integer getHr() {
		return hr;
	}

	/** 设置心率 */
	public void setHr(Integer hr) {
		this.hr = hr;
	}

	/** 获取上传时间 */
	public Date getUploadTime() {
		return uploadTime;
	}

	/** 设置上传时间 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	/** 获取设备mac */
	public String getDeviceMac() {
		return deviceMac;
	}

	/** 设置设备mac */
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac == null ? null : deviceMac.trim();
	}

	/** 获取 */
	public Date getCreateTime() {
		return createTime;
	}

	/** 设置 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	
	 * @since 2017-06-07 09:59:06
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
		HrData other = (HrData) that;
		return (this.getHdId() == null ? other.getHdId() == null : this.getHdId().equals(other.getHdId()))
			&& (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
			&& (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
			&& (this.getHr() == null ? other.getHr() == null : this.getHr().equals(other.getHr()))
			&& (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
			&& (this.getDeviceMac() == null ? other.getDeviceMac() == null : this.getDeviceMac().equals(other.getDeviceMac()))
			&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
	}

	/**
	
	 * @since 2017-06-07 09:59:06
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getHdId() == null) ? 0 : getHdId().hashCode());
		result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
		result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
		result = prime * result + ((getHr() == null) ? 0 : getHr().hashCode());
		result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
		result = prime * result + ((getDeviceMac() == null) ? 0 : getDeviceMac().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "HrData{" +
				"hdId=" + hdId +
				", stuName='" + stuName + '\'' +
				", step=" + step +
				", hr=" + hr +
				", uploadTime=" + uploadTime +
				", deviceMac='" + deviceMac + '\'' +
				", createTime=" + createTime +
				'}';
	}
}