package com.bj.control;

import com.bj.service.HomeworkServiceImpl;
import com.bj.service.IHomeworkService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/3/31.
 */
@WebServlet(name = "SearchHomeworkControl" , urlPatterns = {"/searchhomework"})
public class SearchHomeworkControl extends HttpServlet {
    private IHomeworkService iHomeworkService = new HomeworkServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        req.setCharacterEncoding("utf-8");
        String subjectid = req.getParameter("subject");
        String lessonnum = req.getParameter("lesson");
        String result = null;
        if(iHomeworkService.queryBySubject(Integer.valueOf(subjectid),Integer.valueOf(lessonnum))!= null) {
            result = iHomeworkService.queryBySubject(Integer.valueOf(subjectid), Integer.valueOf(lessonnum)).toString();
        }
        RequestDispatcher dispatcher = null;
        if(result != null){
            req.setAttribute("success",result);
            dispatcher = req.getRequestDispatcher("/StudentPage/SearchHomework.jsp");
        }else {
            req.setAttribute("error","查询失败");
            dispatcher = req.getRequestDispatcher("/StudentPage/SearchHomework.jsp");
        }
        dispatcher.forward(req,resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
