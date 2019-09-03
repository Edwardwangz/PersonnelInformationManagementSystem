package org.wangz.ssm.domain;

import java.util.Date;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 11:01
 */
public class Log {
    private Date operaingTime;//操作时间
    private String type;//操作类型
    private String operator;//操作人
    private String module;//操作模块
    private String operation;//操作内容
    private String result;//操作结果

    public Log() {
    }

    public Date getOperaingTime() {
        return operaingTime;
    }

    public void setOperaingTime(Date operaingTime) {
        this.operaingTime = operaingTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
