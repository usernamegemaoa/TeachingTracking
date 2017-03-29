package com.bj.control;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Neko on 2017/3/27.
 * 处理登录请求
 */
@WebServlet(name = "LoginControl" ,urlPatterns = {"/login"},
            initParams = {
                    @WebInitParam(name="teacher",value = "/teacher.jsp"),
                    @WebInitParam(name="student",value = "/student.jsp"),
                    @WebInitParam(name="admin",value = "/admin.jsp")
            })
public class LoginControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        request.setCharacterEncoding("utf-8");
        String majorname = request.getParameter("name");
        String majorintro = request.getParameter("pwd");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Map<String,String> map = new HashMap<String,String>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("teacher",config.getInitParameter("teacher"));
        map.put("student",config.getInitParameter("student"));
        map.put("admin",config.getInitParameter("admin"));
    }
}
