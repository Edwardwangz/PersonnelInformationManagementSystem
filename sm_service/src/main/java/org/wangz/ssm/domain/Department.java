package org.wangz.ssm.domain;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 11:01
 */
public class Department {
    private Integer dId;//部门编号
    private String dName;//部门名称
    private String dLocation;//部门位置

    public Department() {
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdLocation() {
        return dLocation;
    }

    public void setdLocation(String dLocation) {
        this.dLocation = dLocation;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dLocation='" + dLocation + '\'' +
                '}';
    }
}
