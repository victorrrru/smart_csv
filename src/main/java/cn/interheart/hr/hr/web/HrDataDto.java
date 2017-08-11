package cn.interheart.hr.hr.web;

/**
 * Created by think on 2017/5/31.
 */
public class HrDataDto {
    private Integer hr;
    private String stuName;

    public HrDataDto(Integer hr, String stuName) {
        this.hr = hr;
        this.stuName = stuName;
    }

    public Integer getHr() {
        return hr;
    }

    public void setHr(Integer hr) {
        this.hr = hr;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
