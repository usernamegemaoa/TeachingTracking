package com.bj.control;

import com.bj.dao.ILessonDao;
import com.bj.dao.LessonDaoImpl;
import com.bj.service.ClassManagerServiceImpl;
import com.bj.service.HomeworkServiceImpl;
import com.bj.service.IClassManagerService;
import com.bj.service.IHomeworkService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Neko on 2017/3/31.
 * 处理AJAX请求
 */
@WebServlet(name = "LessonControl" , urlPatterns = {"/lesson"})
public class LessonControl extends HttpServlet {
    private ILessonDao iLessonDao = new LessonDaoImpl();
    private IHomeworkService iHomeworkService = new HomeworkServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询本科目第几节课
        String subjectid = req.getParameter("subjectid");
        String result = iLessonDao.queryBySubjectid(Integer.valueOf(subjectid)).toString();
        System.out.print(result);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
