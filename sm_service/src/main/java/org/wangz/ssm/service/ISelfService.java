package org.wangz.ssm.service;

import org.wangz.ssm.domain.Employee;

/**
 * @author ：Edward wangz
 * @date ：2019/9/2 14:48
 */
public interface ISelfService {
    /**
     * 根据用户输入的用户名密码，进行登录验证
     * @param account
     * @param password
     * @return
     */
    Employee login(String account,String password);

    /**
     * 根据用户id 更改密码
     * @param id 用户密码
     * @param password  新密码
     */
    void changePassword(int id, String password);
}
