package com.bj.control;

import com.bj.po.Work;
import com.bj.service.HomeworkServiceImpl;
import com.bj.service.IHomeworkService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/4/2.
 */
@WebServlet(name = "SetHomeworkControl" , urlPatterns = {"/sethomework"})
public class SetHomeworkControl extends HttpServlet {

    private IHomeworkService iHomeworkService = new HomeworkServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String majorid = req.getParameter("major");
        String subjectid = req.getParameter("subject");
        String lessonid = req.getParameter("lesson");
        String content = req.getParameter("workcontent");
        Work work = new Work();
        work.setSubjectId(Integer.valueOf(subjectid));
        work.setLessonId(Integer.valueOf(lessonid));
        work.setWorkContent(content);

        RequestDispatcher dispatcher = null;

        if(iHomeworkService.addwork(work)){
            req.setAttribute("success","添加成功");
            dispatcher=req.getRequestDispatcher("/TeacherPage/SetHomework.jsp");

        }else{
            req.setAttribute("error","添加失败");
            dispatcher=req.getRequestDispatcher("/TeacherPage/SetHomework.jsp");
        }
        dispatcher.forward(req,resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
