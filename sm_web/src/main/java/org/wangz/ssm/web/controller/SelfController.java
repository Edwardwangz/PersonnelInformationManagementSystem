package org.wangz.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.wangz.ssm.domain.Employee;
import org.wangz.ssm.service.ISelfService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：Edward wangz
 * @date ：2019/9/2 14:59
 */
@Controller("selfController")
public class SelfController {
    @Resource(name = "selfService")
    private ISelfService selfService;


    //    /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    //    /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Employee employee = selfService.login(account, password);
        if (employee == null) {
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("USER", employee);
            response.sendRedirect("main.do");
        }
    }

    //   /logout.do
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER", null);
        response.sendRedirect("main.do");
    }

    //   /main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    //   /self/info.do
    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request, response);
    }

    //    /self/toChangePassword.do
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request, response);
    }

    //    /self/changePassword.do
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("USER");
        //如果原密码输入有误，重定向回到修改密码页面
        if (!oldPassword.equals(employee.getPassword())){
            response.sendRedirect("toChangePassword.do");
        }else {
            selfService.changePassword(employee.geteId(), newPassword);
            response.sendRedirect("../logout.do");
//            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }
    }

}
