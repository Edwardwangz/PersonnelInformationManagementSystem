package org.wangz.ssm.service;

import org.wangz.ssm.domain.Department;

import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:12
 */
public interface IDepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department findById(Integer id);
    List<Department> findAll();
}
