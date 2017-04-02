package com.bj.control;

import com.bj.service.HomeworkServiceImpl;
import com.bj.service.IHomeworkService;

import javax.persistence.criteria.CriteriaBuilder;
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
@WebServlet(name = "AnalyzeHomeworkControl" , urlPatterns = {"/analyzehomework"})
public class AnalyzeHomeworkControl extends HttpServlet {

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
        String classnum = req.getParameter("classid");
        String classinyear = req.getParameter("classinyear");

        List<String> list = null;
        //回传信息格式为(目前作业总数，学号，交的作业总数，作业完成情况作业完成，分隔符$,按顺序回传)
        list = iHomeworkService.queryWorkStat(Integer.valueOf(majorid),Integer.valueOf(subjectid), Integer.valueOf(classnum),Integer.valueOf(classinyear));

        RequestDispatcher dispatcher = null;

        System.out.print(list.toString());
        if(list != null){
            List<String> result = new ArrayList<String>();
            //int temp = 0;
            result.add("目前作业总数："+list.get(0));
            for(int i = 1; i<list.size(); i++){
                result.add("学号："+list.get(i));
                result.add("交的作业总数："+list.get(i+1));
                result.add("作业完成情况：");
                //分隔符$
                for(int j = 1 ;j <list.size()+100 ;j++){
                    if(list.get(i+1+j).equals("$")){//为分隔符
                        i = i+1+j;
                        break;
                    }else{
                        result.add(list.get(i+1+j));
                    }
                }

            }
            System.out.print(result.toString());
            req.setAttribute("success",result.toString());
            dispatcher=req.getRequestDispatcher("/TeacherPage/AnalyzeHomework.jsp");
        }
        else{
            req.setAttribute("error","查询失败，不存在");
            dispatcher=req.getRequestDispatcher("/TeacherPage/AnalyzeHomework.jsp");
        }
        dispatcher.forward(req,resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}

