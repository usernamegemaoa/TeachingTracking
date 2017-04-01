package com.bj.control;

import com.bj.po.Feedback;
import com.bj.service.FeedbackServiceImpl;
import com.bj.service.IFeedbackService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neko on 2017/4/2.
 */
@WebServlet(name = "ShowFeedbackControl" , urlPatterns = {"/showfeedback"})
public class ShowFeedbackControl extends HttpServlet {
    private IFeedbackService iFeedbackService = new FeedbackServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String majorid = req.getParameter("major");
        String subjectid = req.getParameter("subject");
        String lessonnum = req.getParameter("lesson");

        List<Feedback> feedbackList = null;
        feedbackList = iFeedbackService.queryByLessonid(Integer.valueOf(subjectid),Integer.valueOf(lessonnum));

        RequestDispatcher dispatcher = null;
        if(feedbackList != null){
            List<String> result = new ArrayList<String>();

            for(int i = 0; i<feedbackList.size(); i++){
                result.add("学生ID："+feedbackList.get(i).getStuId());
                result.add("反馈时间："+feedbackList.get(i).getFeedbackTime());
                result.add("反馈内容："+feedbackList.get(i).getFeedbackContent());
            }

            if(feedbackList.size()!=0){
                req.setAttribute("success",result.toString());
                dispatcher = req.getRequestDispatcher("/TeacherPage/ShowFeedback.jsp");
            }else {
                req.setAttribute("error","没有反馈内容");
                dispatcher = req.getRequestDispatcher("/TeacherPage/ShowFeedback.jsp");
            }
        }else {
            req.setAttribute("error","没有反馈内容");
            dispatcher = req.getRequestDispatcher("/TeacherPage/ShowFeedback.jsp");
        }


        dispatcher.forward(req,resp);



    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
