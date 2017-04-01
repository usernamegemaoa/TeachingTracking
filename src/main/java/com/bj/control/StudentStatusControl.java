package com.bj.control;

import com.bj.service.IStudentStatService;
import com.bj.service.StudentStatServiceImpl;

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
 * Created by Neko on 2017/4/1.
 */
@WebServlet(name = "StudentStatusControl" , urlPatterns = {"/studentstatus"})
public class StudentStatusControl extends HttpServlet {
    private IStudentStatService iStudentStatService = new StudentStatServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        req.setCharacterEncoding("utf-8");
        int stuid = Integer.valueOf(req.getParameter("stuid"));
        int subjectid = Integer.valueOf(req.getParameter("subject"));
        List<String> list = iStudentStatService.queryByStuid(stuid,subjectid);
        //查询学生学习状态，回传信息格式为
        //(总课时，出勤数，出勤率，目前作业总数，交的作业总数，作业完成情况作业完成按顺序回传)
        List<String> temp_list = new ArrayList<String>();
        for(int i = 5 ; i<list.size();i++){
            temp_list.add(list.get(i));
        }

        String result = "总课时："+list.get(0)+" 出勤数："+list.get(1)+" 出勤率："+list.get(2)+" 目前作业总数："+list.get(3)+" 交的作业总数："+list.get(4)+" 作业完成情况："+temp_list.toString();
        RequestDispatcher dispatcher = null;
        if(list.size()!=0){
            req.setAttribute("success",result);
            dispatcher = req.getRequestDispatcher("/StudentPage/StudentStatus.jsp");
        }else {
            req.setAttribute("error","查询失败");
            dispatcher = req.getRequestDispatcher("/StudentPage/StudentStatus.jsp");
        }
        dispatcher.forward(req,resp);



    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
