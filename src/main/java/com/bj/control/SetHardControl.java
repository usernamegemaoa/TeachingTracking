package com.bj.control;

import com.bj.dao.IQuestionDao;
import com.bj.dao.QuestionDaoImpl;
import com.bj.po.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/22.
 */
@WebServlet(name = "SetHardControl", urlPatterns = {"/SetHard"})
public class SetHardControl extends HttpServlet {
    public IQuestionDao iq = new QuestionDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionexam = Integer.parseInt(request.getParameter("questionexam"));
        int examid = Integer.parseInt(request.getParameter("examid"));
        int questionmark = Integer.parseInt(request.getParameter("questionmark"));
        int questionhard = Integer.parseInt(request.getParameter("questionhard"));
        String questiontext = request.getParameter("questiontext");
        Question q =new Question();
        Question query = new Question();
        q.setQuestionExam(questionexam);
        q.setExamId(examid);
        q.setQuestionMark(questionmark);
        q.setQuestionHard(questionhard);
        q.setQuestionText(questiontext);
        //查找出题号Question_id 便于Update
        query = iq.queryByQuestionexam(examid,questionexam);
        q.setQuestionId(query.getQuestionId());
        //更新试卷信息 添加分值和难度
        RequestDispatcher dispatcher = null;
        if(iq.update(q)){
            request.setAttribute("success","添加成功");
            dispatcher=request.getRequestDispatcher("/SetHard.jsp");

        }
        else{
            request.setAttribute("error","添加失败");
            dispatcher=request.getRequestDispatcher("/SetHard.jsp");
        }

        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
