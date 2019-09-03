package org.wangz.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.wangz.ssm.domain.Department;
import org.wangz.ssm.service.IDepartmentService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:10
 */
@Controller
public class DepartmentController {
    @Resource(name = "departmentService")
    private IDepartmentService departmentService;

    //  /department/list.do     /department_list.jsp
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.findAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../department_list.jsp").forward(request, response);
    }

    //  /department/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../department_add.jsp").forward(request, response);
    }

    //  /department/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dName = request.getParameter("dName");
        String dLocation = request.getParameter("dLocation");

        Department department = new Department();
        department.setdName(dName);
        department.setdLocation(dLocation);

        departmentService.add(department);
        response.sendRedirect("list.do");
    }

    //    /department/toEdit.do
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer dId = Integer.valueOf(request.getParameter("dId"));
        Department department = departmentService.findById(dId);
        request.setAttribute("OBJ",department);
        request.getRequestDispatcher("../department_edit.jsp").forward(request, response);
    }

    //    /department/edit.do
    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer dId = Integer.valueOf(request.getParameter("dId"));
        String dName = request.getParameter("dName");
        String dLocation = request.getParameter("dLocation");

        Department department = departmentService.findById(dId);
        department.setdName(dName);
        department.setdLocation(dLocation);

        departmentService.edit(department);
        response.sendRedirect("list.do");
    }

    //   /department/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer dId = Integer.valueOf(request.getParameter("dId"));
        departmentService.remove(dId);
        response.sendRedirect("list.do");
    }


}
