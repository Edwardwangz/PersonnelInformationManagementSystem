package org.wangz.ssm.dao;

import org.springframework.stereotype.Repository;
import org.wangz.ssm.domain.Department;

import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:08
 */
@Repository("departmentDao")
public interface IDepartmentDao {
    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department selectById(Integer id);
    List<Department> selectAll();

}
