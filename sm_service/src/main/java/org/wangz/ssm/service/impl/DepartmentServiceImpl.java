package org.wangz.ssm.service.impl;

import org.springframework.stereotype.Service;
import org.wangz.ssm.dao.IDepartmentDao;
import org.wangz.ssm.domain.Department;
import org.wangz.ssm.service.IDepartmentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:13
 */
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

    @Resource(name = "departmentDao")
    private IDepartmentDao departmentDao;

    @Override
    public void add(Department department) {
        departmentDao.insert(department);
    }

    @Override
    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    @Override
    public void edit(Department department) {
        departmentDao.update(department);
    }

    @Override
    public Department findById(Integer id) {
        return departmentDao.selectById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.selectAll();
    }
}
