package org.wangz.ssm.service;

import org.wangz.ssm.domain.Employee;

import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:13
 */
public interface IEmployeeService {
    void add(Employee employee);
    void remove(Integer eId);
    void edit (Employee employee);
    Employee findById(Integer eId);
    List<Employee> findAll();
}
