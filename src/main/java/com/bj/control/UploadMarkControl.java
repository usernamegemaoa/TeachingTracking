package com.bj.control;

import com.bj.dao.IStuAllDao;
import com.bj.dao.IStuExamDao;
import com.bj.dao.StuAllDaoImpl;
import com.bj.dao.StuExamDaoImpl;
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
@WebServlet(name = "UploadMarkControl" , urlPatterns = {"/uploadmark"})
public class UploadMarkControl extends HttpServlet {
    private IStuAllDao iStuAllDao = new StuAllDaoImpl();
    private IStuExamDao iStuExamDao = new StuExamDaoImpl();
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
        String examtime = req.getParameter("examtime");
        String examab = req.getParameter("examab");
        String stuid = req.getParameter("stuid");
        //小题分数进入列表
        List<Integer> list = new ArrayList<Integer>();
       /* for(int i = 0 ; i <10 ; i++){
            String m = "mark" +1;
            if(req.getParameter(m)!=null){
                list.add(Integer.valueOf(req.getParameter(m)));
            }
        }*/

        list.add(Integer.valueOf(req.getParameter("mark1")));
        list.add(Integer.valueOf(req.getParameter("mark2")));
        list.add(Integer.valueOf(req.getParameter("mark3")));
        list.add(Integer.valueOf(req.getParameter("mark4")));
        list.add(Integer.valueOf(req.getParameter("mark5")));
        list.add(Integer.valueOf(req.getParameter("mark6")));
        list.add(Integer.valueOf(req.getParameter("mark7")));
        list.add(Integer.valueOf(req.getParameter("mark8")));
        list.add(Integer.valueOf(req.getParameter("mark9")));
        list.add(Integer.valueOf(req.getParameter("mark10")));


        //iMarkManagerService.addStuMark(Integer.valueOf(subjectid),examtime,examab,Integer.valueOf(stuid),list);
        RequestDispatcher dispatcher = null;
        if(iMarkManagerService.addStuMark(Integer.valueOf(subjectid),examtime,examab,Integer.valueOf(stuid),list)){
            req.setAttribute("success","分数添加成功");
            dispatcher=req.getRequestDispatcher("/TeacherPage/UploadMark.jsp");
        }else{
            req.setAttribute("error","分数添加失败");
            dispatcher=req.getRequestDispatcher("/TeacherPage/UploadMark.jsp");
        }

        dispatcher.forward(req,resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
