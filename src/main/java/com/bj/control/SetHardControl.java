package com.bj.control;

import com.bj.dao.ExamDaoImpl;
import com.bj.dao.IExamDao;
import com.bj.dao.IQuestionDao;
import com.bj.dao.QuestionDaoImpl;
import com.bj.po.Exam;
import com.bj.po.Question;
import com.bj.service.CreateExamServiceImpl;
import com.bj.service.ICreateExamService;

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
@WebServlet(name = "SetHardControl", urlPatterns = {"/sethard"})
public class SetHardControl extends HttpServlet {
    private ICreateExamService iCreateExamService = new CreateExamServiceImpl();
    private IExamDao iExamDao = new ExamDaoImpl();
    private IQuestionDao iQuestionDao = new QuestionDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String majorid = request.getParameter("major");
        String subjectid = request.getParameter("subject");
        String examtime = request.getParameter("examtime");
        String examab = request.getParameter("examab");
        String questionexam = request.getParameter("questionexam");
        String questionhard = request.getParameter("questionhard");
        String questionmark = request.getParameter("questionmark");

        //取得Examid
        boolean flag_e = false;
        Exam e = null;
        e = iExamDao.queryByExamonly(Integer.valueOf(subjectid),examtime,examab);

        Question question = new Question();
        question.setQuestionExam(Integer.valueOf(questionexam));
        question.setQuestionMark(Integer.valueOf(questionmark));
        question.setQuestionHard(Integer.valueOf(questionhard));
        if(e != null){
            question.setExamId(e.getExamId());
            flag_e = true;
        }
        //查找出题号Question_id 便于Update
        Question query = null;
        if(flag_e){//确认examid存在 再继续查询
            query = iQuestionDao.queryByQuestionexam(e.getExamId(),Integer.valueOf(questionexam));
            question.setQuestionId(query.getQuestionId());
        }

        RequestDispatcher dispatcher = null;
        if(query!=null && flag_e){
            //更新试卷信息 添加分值和难度
            if(iCreateExamService.addQuestionhard(question)){
                request.setAttribute("success","添加成功");
                dispatcher=request.getRequestDispatcher("/TeacherPage/SetHard.jsp");

            }else{
                request.setAttribute("error","添加失败");
                dispatcher=request.getRequestDispatcher("/TeacherPage/SetHard.jsp");
            }
        }else{
            request.setAttribute("error","没有该题目");
            dispatcher=request.getRequestDispatcher("/TeacherPage/SetHard.jsp");
        }

        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
