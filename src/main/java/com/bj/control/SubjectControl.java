package com.bj.control;

import com.bj.service.IMajorService;
import com.bj.service.MajorServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Neko on 2017/3/29.
 * 处理AJAX请求
 */
@WebServlet(name = "/subject" ,urlPatterns = {"/subject"})
public class SubjectControl extends HttpServlet {
    private IMajorService iMajorService = new MajorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String majorid = req.getParameter("majorid");

        String result = iMajorService.queryBySubjecttoMajor(Integer.valueOf(majorid)).toString();
        System.out.print(result);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
