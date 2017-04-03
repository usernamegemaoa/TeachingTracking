package com.bj.control;

import com.bj.dao.IStudentDao;
import com.bj.dao.ITeacherDao;
import com.bj.dao.StudentDaoImpl;
import com.bj.dao.TeacherDaoImpl;
import com.bj.po.Student;
import com.bj.po.Teacher;
import com.bj.service.IUserService;
import com.bj.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/31.
 */
@WebServlet(name = "userControl" , urlPatterns = {"/user"})
public class UserControl extends HttpServlet {
    private IUserService iUserService = new UserServiceImpl();
    private IStudentDao iStudentDao = new StudentDaoImpl();
    private ITeacherDao iTeacherDao = new TeacherDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String key = req.getParameter("key");//登录编号

        RequestDispatcher dispatcher =  null;
        HttpSession session = req.getSession();
        if(Integer.valueOf(key)==0){//处理学生登录
            if(iUserService.loginStudent(Integer.valueOf(id),pwd)){//如果登录成功
                Student student = null;
                student = iStudentDao.queryByStuid(Integer.valueOf(id));
                session.setAttribute("user",student);
                System.out.println("学生登录成功");
                req.setAttribute("success","学生登录成功");
                dispatcher=req.getRequestDispatcher("/student.jsp");
            }else{
                session.removeAttribute("user");
                System.out.println("学生登录失败");
                req.setAttribute("error","学生登录失败");
                dispatcher=req.getRequestDispatcher("/login.jsp");
            }
        }else if(Integer.valueOf(key)==1){//处理教师管理员登录
            if(iUserService.loginTeacher(Integer.valueOf(id),pwd)){//如果登录成功
                Teacher teacher = null;
                teacher = iTeacherDao.queryByTeaid(Integer.valueOf(id));
                if(teacher.getTeaId()==1){//一号为管理员
                    session.setAttribute("user",teacher);
                    System.out.println("管理员登录成功");
                    req.setAttribute("success","管理员登录成功");
                    dispatcher=req.getRequestDispatcher("/admin.jsp");
                }else{
                    session.setAttribute("user",teacher);
                    System.out.println("教师登录成功");
                    req.setAttribute("success","教师登录成功");
                    dispatcher=req.getRequestDispatcher("/teacher.jsp");
                }
            }else{
                session.removeAttribute("user");
                System.out.println("教师，管理员登录失败");
                req.setAttribute("error","教师，管理员登录失败");
                dispatcher=req.getRequestDispatcher("/login.jsp");
            }
        }

        dispatcher.forward(req,resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
