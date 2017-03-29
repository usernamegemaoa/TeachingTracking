package com.bj.control;

import com.bj.dao.IMajorDao;
import com.bj.dao.MajorDaoImpl;
import com.bj.po.Major;
import com.bj.service.IMajorService;
import com.bj.service.MajorServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Neko on 2017/3/18.
 * 处理AJAX请求
 */
@WebServlet(name = "MajorControl", urlPatterns = {"/major"})
public class MajorControl extends HttpServlet{
        private IMajorService iMajorService = new MajorServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = iMajorService.queryMajorall().toString();
        System.out.print(result);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}
