package org.wangz.ssm.service.impl;

import org.springframework.stereotype.Service;
import org.wangz.ssm.dao.IEmployeeDao;
import org.wangz.ssm.dao.ISelfDao;
import org.wangz.ssm.domain.Employee;
import org.wangz.ssm.service.ISelfService;

import javax.annotation.Resource;

/**
 * @author ：Edward wangz
 * @date ：2019/9/2 14:48
 */
@Service("selfService")
public class SelfServiceImpl implements ISelfService {
    @Resource(name = "selfDao")
    private ISelfDao selfDao;

    @Resource(name = "employeeDao")
    private IEmployeeDao employeeDao;

    @Override
    public Employee login(String account, String password) {
        Employee loginEmployee = selfDao.selectByAccount(account);
        //没有此用户，登陆失败
        if (loginEmployee == null) return null;

        String realPassword = loginEmployee.getPassword();
        //有此用户，密码不正确，登陆失败
        if (loginEmployee != null && !password.equals(realPassword)) {
            return null;
        } else {//用户名、密码都正确，登陆成功
            return loginEmployee;
        }
    }

    public void changePassword(int id, String password) {
        Employee employee = employeeDao.selectById(id);
        employee.setPassword(password);
        employeeDao.update(employee);
    }
}
