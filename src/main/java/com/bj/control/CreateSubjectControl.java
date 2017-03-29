package com.bj.control;

import com.bj.dao.ISubjectDao;
import com.bj.po.Subject;
import com.bj.service.ICreateExamService;
import com.bj.service.IMajorService;
import com.bj.service.MajorServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/29.
 */
@WebServlet(name = "CreateSubjectControl" ,urlPatterns = {"/createsubject"},
            initParams = {
                @WebInitParam(name="success",value = "/AdminPage/CreateSubject.jsp")
            })
public class CreateSubjectControl extends HttpServlet{
        private IMajorService iMajorService = new MajorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        req.setCharacterEncoding("utf-8");
        String subjectname = req.getParameter("subjectname");
        String majorid = req.getParameter("majorid");
        String subjectyear = req.getParameter("subjectyear");
        String subjecttimes = req.getParameter("subjecttimes");
        String subjectintro = req.getParameter("subjectintro");

        Subject subject = new Subject();
        subject.setSubjectName(subjectname);
        subject.setMajorId(Integer.valueOf(majorid));
        subject.setSubjectYear(subjectyear);
        subject.setSubjectTimes(Integer.valueOf(subjecttimes));
        subject.setSubjectIntro(subjectintro);
        RequestDispatcher dispatcher = null;
        if(iMajorService.addSubject(subject)){
            req.setAttribute("success","添加成功");
            dispatcher = req.getRequestDispatcher("/AdminPage/CreateSubject.jsp");
        }else {
            req.setAttribute("error","添加失败");
            dispatcher = req.getRequestDispatcher("/AdminPage/CreateSubject.jsp");
        }
        dispatcher.forward(req,resp);

        System.out.print(subject.toString());

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
