package cn.smart.hr.web;

/**
 * Created by think on 2017/5/31.
 */
public class DeviceDto {
    private String deviceMac;
    private String stuName;
    private int age = 0;
    public DeviceDto(String deviceMac, String stuName) {
        this.deviceMac = deviceMac;
        this.stuName = stuName;
    }

    public DeviceDto(String deviceMac, String stuName, int age) {
        this.deviceMac = deviceMac;
        this.stuName = stuName;
        this.age = age;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
