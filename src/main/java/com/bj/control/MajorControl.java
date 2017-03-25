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
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Neko on 2017/3/18.
 */
@WebServlet(name = "MajorControl", urlPatterns = {"/major"},
        initParams = {
                @WebInitParam(name="success",value = "/index.jsp"),
                @WebInitParam(name="error",value = "/index.jsp")
        })
public class MajorControl extends HttpServlet{
        private IMajorService im = new MajorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        request.setCharacterEncoding("utf-8");
        String majorname = request.getParameter("majorname");
        String majorintro = request.getParameter("majorintro");
        String method = request.getParameter("method");
            Major mj = new Major();
            mj.setMajorName(majorname);
            mj.setMajorIntro(majorintro);
            RequestDispatcher dispatcher = null;
            if(im.addMajor(mj)){
                request.setAttribute("success","添加成功");
                dispatcher=request.getRequestDispatcher(map.get("success"));
            }else{
                request.setAttribute("error","添加失败");
                dispatcher=request.getRequestDispatcher(map.get("error"));
            }

            dispatcher.forward(request,response);


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private Map<String,String> map = new HashMap<String,String>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("success",config.getInitParameter("success"));
        map.put("error",config.getInitParameter("error"));

    }
}
