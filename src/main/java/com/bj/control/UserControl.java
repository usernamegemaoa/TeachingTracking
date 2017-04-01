package com.bj.control;

import com.bj.service.IUserService;
import com.bj.service.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/31.
 */
@WebServlet(name = "userControl" , urlPatterns = {"/user"})
public class UserControl extends HttpServlet {
    private IUserService iUserService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String key = req.getParameter("log");
        if(key.equals("0")){//处理学生登录
            //iUserService.loginStudent();

        }else if(key.equals("1")){//处理教师管理员登录
            //iUserService.loginStudent();

        }



    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
