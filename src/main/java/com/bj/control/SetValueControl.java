package com.bj.control;

import com.bj.po.TeaValue;
import com.bj.service.IValueService;
import com.bj.service.ValueServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neko on 2017/4/1.
 */
@WebServlet(name = "SetValueControl" , urlPatterns = {"/setvalue"})
public class SetValueControl extends HttpServlet{
    private IValueService iValueService = new ValueServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集 避免出现乱码
        req.setCharacterEncoding("utf-8");
        TeaValue teaValue = new TeaValue();
        teaValue.setStuId(Integer.valueOf(req.getParameter("stuid")));
        teaValue.setTeaId(Integer.valueOf(req.getParameter("teaid")));
        teaValue.setValue1(Integer.valueOf(req.getParameter("value1")));
        teaValue.setValue2(Integer.valueOf(req.getParameter("value2")));
        teaValue.setValue3(Integer.valueOf(req.getParameter("value3")));
        teaValue.setValueContent(req.getParameter("valuecontent"));
        RequestDispatcher dispatcher = null;
        if(iValueService.add(teaValue)){
            req.setAttribute("success","提交成功");
            dispatcher = req.getRequestDispatcher("/StudentPage/SetValue.jsp");
        }else {
            req.setAttribute("error","查询失败");
            dispatcher = req.getRequestDispatcher("/StudentPage/SetValue.jsp");
        }
        dispatcher.forward(req,resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
