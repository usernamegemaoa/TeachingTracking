package com.bj.control;

import com.bj.po.Feedback;
import com.bj.service.FeedbackServiceImpl;
import com.bj.service.IFeedbackService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Neko on 2017/3/31.
 */
@WebServlet(name = "SetFeedbackControl" , urlPatterns = {"/setfeedback"})
public class SetFeedbackControl extends HttpServlet{
    private IFeedbackService iFeedbackService = new FeedbackServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Feedback feedback = new Feedback();
        feedback.setSubjectId(Integer.valueOf(req.getParameter("subject")));
        feedback.setLessonId(Integer.valueOf(req.getParameter("lesson")));
        feedback.setStuId(Integer.valueOf(req.getParameter("stuid")));
        feedback.setFeedbackContent(req.getParameter("feedbackcontent"));
        //记录反馈时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        feedback.setFeedbackTime(df.format(new Date()));// new Date()为获取当前系统时间
        RequestDispatcher dispatcher = null;
        if(iFeedbackService.add(feedback)){
            req.setAttribute("success","提交成功");
            dispatcher = req.getRequestDispatcher("/StudentPage/SetFeedback.jsp");
        }else {
            req.setAttribute("error","查询失败");
            dispatcher = req.getRequestDispatcher("/StudentPage/SetFeedback.jsp");
        }
        dispatcher.forward(req,resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
