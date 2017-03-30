package com.bj.control;

import com.bj.dao.DClassDaoImpl;
import com.bj.dao.IDclassDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Neko on 2017/3/30.
 */
@WebServlet(name = "ClassControl" , urlPatterns = {"/classid"})
public class ClassControl extends HttpServlet {
    private IDclassDao iDclassDao = new DClassDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //在class表中搜subjectid 找class_id
        String majorid = req.getParameter("majorid");
        String result = iDclassDao.queryByMajorid(Integer.valueOf(majorid)).toString();
        System.out.println(result);

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
