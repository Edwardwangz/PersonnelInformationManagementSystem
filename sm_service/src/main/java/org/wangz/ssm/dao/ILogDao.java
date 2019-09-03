package org.wangz.ssm.dao;

import org.wangz.ssm.domain.Log;

import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:08
 */
public interface ILogDao {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperationLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperationLog();
}
