package com.bj.control;

import com.bj.dao.ExamDaoImpl;
import com.bj.dao.IExamDao;
import com.bj.dao.IQuestionDao;
import com.bj.dao.QuestionDaoImpl;
import com.bj.po.Exam;
import com.bj.po.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/21.
 */
@WebServlet(name = "CreateExamControl", urlPatterns = {"/createexam"})
public class CreateExamControl extends HttpServlet {
        public IExamDao ie = new ExamDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        request.setCharacterEncoding("utf-8");
        int subjectid = Integer.parseInt(request.getParameter("subjectid"));
        String examtime = request.getParameter("examtime");
        String examab = request.getParameter("examab");
        int examnum = Integer.parseInt(request.getParameter("examnum"));
        int exammark = Integer.parseInt(request.getParameter("exammark"));
        Exam exam = new Exam();
        exam.setSubjectId(subjectid);
        exam.setExamTime(examtime);
        exam.setExamAb(examab);
        exam.setExamNum(examnum);
        exam.setExamMark(exammark);
        //创建一张试卷 成功返回true 同时生成题号
        RequestDispatcher dispatcher = null;
        boolean flag = ie.add(exam);
        Exam em = new Exam();
        em= ie.queryByExamonly(subjectid,examtime,examab);
        int id = em.getExamId();
        if(flag){
            for(int i = 0; i < examnum; i++){
                IQuestionDao iq = new QuestionDaoImpl();
                Question q = new Question();
                q.setQuestionExam(i+1);
                q.setExamId(id);
                iq.add(q);
            }
            request.setAttribute("success","试卷创建成功");
            dispatcher=request.getRequestDispatcher("/CreateExam.jsp");
        }else{
            request.setAttribute("error","试卷创建失败");
            dispatcher=request.getRequestDispatcher("/CreateExam.jsp");
        }

        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
