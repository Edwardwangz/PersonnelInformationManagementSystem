package org.wangz.ssm.dao;

import org.springframework.stereotype.Repository;
import org.wangz.ssm.domain.Employee;

/**
 * @author ：Edward wangz
 * @date ：2019/9/2 14:31
 */
@Repository("selfDao")
public interface ISelfDao {
    /**
     * 根据有户名查询Employee
     * @param account
     * @return
     */
    Employee selectByAccount(String account);
}
