package org.wangz.ssm.dao;

import org.springframework.stereotype.Repository;
import org.wangz.ssm.domain.Employee;

import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:08
 */
@Repository("employeeDao")
public interface IEmployeeDao {
    void insert(Employee employee);
    void delete(Integer id);
    void update(Employee employee);
    Employee selectById(Integer id);
    List<Employee> selectAll();
}
