package com.bj.control;

import com.bj.po.Student;
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
@WebServlet(name = "CreateStudentControl" , urlPatterns = {"/createstudent"})
public class CreateStudentControl extends HttpServlet {
    private IUserService iUserService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        req.setCharacterEncoding("utf-8");
        String stuname = req.getParameter("stuname");
        String stusex = req.getParameter("stusex");
        String studate = req.getParameter("studate");
        String majorid = req.getParameter("majorid");
        String classid = req.getParameter("classid");
        String stuinyear = req.getParameter("stuinyear");
        String stupwd = req.getParameter("stupwd");
        Student st = new Student();
        st.setStuName(stuname);
        st.setStuSex(stusex);
        st.setStuDate(studate);
        st.setMajorId(Integer.valueOf(majorid));
        st.setClassId(Integer.valueOf(classid));
        st.setStuInyear(stuinyear);
        st.setStuPwd(stupwd);
        RequestDispatcher dispatcher = null;
        if(iUserService.addStudent(st)){
            req.setAttribute("success","添加成功");
            dispatcher = req.getRequestDispatcher("/AdminPage/CreateStudent.jsp");
        }else {
            req.setAttribute("error","添加失败");
            dispatcher = req.getRequestDispatcher("/AdminPage/CreateStudent.jsp");
        }
        dispatcher.forward(req,resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
