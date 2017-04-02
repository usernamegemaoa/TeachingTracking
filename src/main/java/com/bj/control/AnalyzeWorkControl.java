package com.bj.control;

import com.bj.service.ClassManagerServiceImpl;
import com.bj.service.IClassManagerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Neko on 2017/4/2.
 */
@WebServlet(name = "AnalyzeWorkControl" ,urlPatterns = {"/analyzeworkctrl"})
public class AnalyzeWorkControl extends HttpServlet {
    private IClassManagerService iClassManagerService = new ClassManagerServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String majorid = req.getParameter("major");
        String subjectid = req.getParameter("subject");
        String classid = req.getParameter("classid");
        String lessonid = req.getParameter("lesson");
        List<Integer> list = null;
        //查询某班级某节课出勤情况 返回值(出勤率，出勤人数，班级总人数)
        list = iClassManagerService.queryByClassid(Integer.valueOf(subjectid),Integer.valueOf(classid),Integer.valueOf(lessonid));
        RequestDispatcher dispatcher = null;
        if(list!=null){
            String result = "出勤率："+list.get(0)+"%"+" 出勤人数："+list.get(1)+"班级总人数："+list.get(2);
            if(list.get(2)!=0){
                req.setAttribute("success",result);
            }else {
                req.setAttribute("success",result+" 请确认您输入的信息是否正确！");
            }

            dispatcher=req.getRequestDispatcher("/TeacherPage/AnalyzeWork.jsp");
        }
        else{
            req.setAttribute("error","查询失败，不存在");
            dispatcher=req.getRequestDispatcher("/TeacherPage/AnalyzeWork.jsp");
        }
        dispatcher.forward(req,resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
