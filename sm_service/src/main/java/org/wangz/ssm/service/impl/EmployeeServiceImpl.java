package org.wangz.ssm.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.wangz.ssm.dao.IEmployeeDao;
import org.wangz.ssm.domain.Employee;
import org.wangz.ssm.service.IEmployeeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:14
 */
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {
    @Resource(name = "employeeDao")
    private IEmployeeDao employeeDao;

    @Override
    public void add(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public void remove(Integer eId) {
        employeeDao.delete(eId);
    }

    @Override
    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public Employee findById(Integer eId) {
        return employeeDao.selectById(eId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.selectAll();
    }
}
