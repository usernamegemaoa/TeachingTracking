package com.bj.control;

import com.bj.po.Teacher;
import com.bj.service.IUserService;
import com.bj.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/30.
 */
@WebServlet(name = "CreateTeacherControl" , urlPatterns = {"/createteacher"})
public class CreateTeacherControl extends HttpServlet {
    private IUserService iUserService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        req.setCharacterEncoding("utf-8");
        String teaname = req.getParameter("teaname");
        String teasex = req.getParameter("teasex");
        String majorid = req.getParameter("majorid");
        String teapwd = req.getParameter("teapwd");
        Teacher t = new Teacher();
        t.setTeaName(teaname);
        t.setTeaSex(teasex);
        t.setMajorId(Integer.valueOf(majorid));
        t.setTeaPwd(teapwd);
        RequestDispatcher dispatcher = null;
        if(iUserService.addTeacher(t)){
            req.setAttribute("success","添加成功");
            dispatcher = req.getRequestDispatcher("/AdminPage/CreateTeacher.jsp");
        }else {
            req.setAttribute("error","添加失败");
            dispatcher = req.getRequestDispatcher("/AdminPage/CreateTeacher.jsp");
        }
        dispatcher.forward(req,resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
