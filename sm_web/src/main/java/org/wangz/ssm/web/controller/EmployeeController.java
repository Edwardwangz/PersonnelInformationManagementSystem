package org.wangz.ssm.web.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.wangz.ssm.domain.Department;
import org.wangz.ssm.domain.Employee;
import org.wangz.ssm.service.IDepartmentService;
import org.wangz.ssm.service.IEmployeeService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：Edward wangz
 * @date ：2019/8/29 12:11
 */
@Controller("employeeController")
public class EmployeeController {
    @Resource(name = "employeeService")
    private IEmployeeService employeeService;
    @Resource(name = "departmentService")
    private IDepartmentService departmentService;

    //   /employee/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("LIST",employees);
        request.getRequestDispatcher("../employee_list.jsp").forward(request,response);
    }

    //   /employee/toAdd.do
    //要将所有已有部门信息传到employee_add.jsp页面，供下拉列表选择
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentService.findAll();
        request.setAttribute("DLIST",departments);
        request.getRequestDispatcher("../employee_add.jsp").forward(request,response);
    }

    //   /employee/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Integer eDepartment = Integer.valueOf(request.getParameter("eDepartment"));
        String eName = request.getParameter("eName");
        String idcards = request.getParameter("idcards");
        String born = request.getParameter("born");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bornDate = null;
        try {
            bornDate = sdf.parse(born);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String remark = request.getParameter("remark");

        Employee employee = new Employee();
        employee.setAccount(account);
        employee.setPassword(password);
        employee.seteDepartment(eDepartment);
        employee.seteName(eName);
        employee.setIdcards(idcards);
        employee.setBorn(bornDate);
        employee.setRemark(remark);

        employeeService.add(employee);
        response.sendRedirect("list.do");
    }

    //    /employee/toEdit.do  将要修改的员工id  以及所有部门列表放到request域
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer eId = Integer.valueOf(request.getParameter("eId"));
        Employee employee = employeeService.findById(eId);
        request.setAttribute("OBJ",employee);
        List<Department> departments = departmentService.findAll();
        request.setAttribute("DLIST",departments);
        request.getRequestDispatcher("../employee_edit.jsp").forward(request,response);
    }

    //    /employee/edit.do
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer eId = Integer.valueOf(request.getParameter("eId"));
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Integer dId = Integer.valueOf(request.getParameter("dId"));
        String eName = request.getParameter("eName");
        String gender = request.getParameter("gender");
        String idcards = request.getParameter("idcards");
        String born = request.getParameter("born");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bornDate = null;
        try {
            bornDate = sdf.parse(born);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String remark = request.getParameter("remark");

        Employee employee = employeeService.findById(eId);

        employee.setAccount(account);
        employee.setPassword(password);
        employee.seteDepartment(dId);
        employee.seteName(eName);
        employee.setGender(gender);
        employee.setIdcards(idcards);
        employee.setBorn(bornDate);
        employee.setRemark(remark);

        employeeService.edit(employee);
        response.sendRedirect("list.do");
    }

    //    /employee/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer eId = Integer.valueOf(request.getParameter("eId"));
        employeeService.remove(eId);
        response.sendRedirect("list.do");
    }

    //    /employee/detail.do
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer eId = Integer.valueOf(request.getParameter("eId"));
        Employee employee = employeeService.findById(eId);
        request.setAttribute("OBJ",employee);
        request.getRequestDispatcher("../employee_detail.jsp").forward(request,response);
    }
}
