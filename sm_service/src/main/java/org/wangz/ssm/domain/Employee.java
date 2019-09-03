package org.wangz.ssm.domain;

import java.util.Date;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 11:01
 */
public class Employee {
    private Integer eId;//员工编号
    private String account;//员工账户名
    private String password;//员工账户密码
    private String status;//员工账户状态
    private Integer eDepartment;//员工所属部门
    private String eName;//员工名字
    private String gender;//员工性别
    private String idcards;//员工身份证号码
    private Date entryTime;//员工入职时间
    private Date separationTime;//员工离职时间
    private Date born;//员工出生日期
    private String remark;//备注
    private Department department;//部门引用

    public Employee() {
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(Integer eDepartment) {
        this.eDepartment = eDepartment;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcards() {
        return idcards;
    }

    public void setIdcards(String idcards) {
        this.idcards = idcards;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getSeparationTime() {
        return separationTime;
    }

    public void setSeparationTime(Date separationTime) {
        this.separationTime = separationTime;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", eDepartment=" + eDepartment +
                ", eName='" + eName + '\'' +
                ", gender='" + gender + '\'' +
                ", idcards='" + idcards + '\'' +
                ", entryTime=" + entryTime +
                ", separationTime=" + separationTime +
                ", born=" + born +
                ", remark='" + remark + '\'' +
                ", department=" + department +
                '}';
    }
}
