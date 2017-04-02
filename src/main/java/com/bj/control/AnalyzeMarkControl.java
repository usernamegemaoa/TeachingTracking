package com.bj.control;

import com.bj.service.IMarkManagerService;
import com.bj.service.MarkManagerServiceImpl;

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
@WebServlet(name = "AnalyzeMarkControl" , urlPatterns = {"/analyzemark"})
public class AnalyzeMarkControl extends HttpServlet{

    private IMarkManagerService iMarkManagerService = new MarkManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String majorid = req.getParameter("major");
        String subjectid = req.getParameter("subject");
        String classnum = req.getParameter("classid");
        String examtime = req.getParameter("examtime");
        String examab = req.getParameter("examab");
        String inyear = req.getParameter("inyear");

        //查询班级 回传参数（班级平均分，优秀率，及格率，每道题的平均分）
        List<String> list = new ArrayList<String>();
        list = iMarkManagerService.queryByclass(Integer.valueOf(subjectid),Integer.valueOf(majorid),examtime,examab,Integer.valueOf(classnum),Integer.valueOf(inyear));

        RequestDispatcher dispatcher = null;

            if(list!=null){
                List<String> list1 = new ArrayList<String>();
                for(int i = 3; i< list.size();i++){
                    list1.add(list.get(i));
                }
                String result ="班级平均分："+list.get(0)+" 优秀率："+list.get(1)+"% 及格率："+list.get(2)+"% 每道题的平均分："+list1.toString();

                req.setAttribute("success",result);
                dispatcher=req.getRequestDispatcher("/TeacherPage/AnalyzeMark.jsp");

            }else{
                req.setAttribute("error","查询失败");
                dispatcher=req.getRequestDispatcher("/TeacherPage/AnalyzeMark.jsp");
            }

        dispatcher.forward(req,resp);




    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
