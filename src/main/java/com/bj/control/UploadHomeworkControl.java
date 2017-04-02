package com.bj.control;

import com.bj.dao.IWorkDao;
import com.bj.dao.WorkDaoImpl;
import com.bj.po.StuWork;
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
 * Created by Neko on 2017/4/2.
 */
@WebServlet(name = "UploadHomeworkControl" , urlPatterns = {"/uploadhomework"})
public class UploadHomeworkControl extends HttpServlet {

    private IHomeworkService iHomeworkService = new HomeworkServiceImpl();
    private IWorkDao iWorkDao = new WorkDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String majorid = req.getParameter("major");
        String subjectid = req.getParameter("subject");
        String lessonid = req.getParameter("lesson");
        String stuid = req.getParameter("stuid");
        String stumark = req.getParameter("stumark");
        String stutext = req.getParameter("stutext");


        StuWork stuWork = new StuWork();
        stuWork.setStuId(Integer.valueOf(stuid));
        stuWork.setStwkMark(Integer.valueOf(stumark));
        stuWork.setStwkText(stutext);


        RequestDispatcher dispatcher = null;
        //判断该节课有没有作业
        if(iWorkDao.queryByLessonid(Integer.valueOf(lessonid))!= null){
            int work_id = iWorkDao.queryByLessonid(Integer.valueOf(lessonid)).getWorkId();
            stuWork.setWorkId(work_id);
            if(iHomeworkService.addstuwork(stuWork)){
                req.setAttribute("success","添加成功");
                dispatcher=req.getRequestDispatcher("/TeacherPage/UploadHomework.jsp");
            }
            else{
                req.setAttribute("error","添加失败");
                dispatcher=req.getRequestDispatcher("/TeacherPage/UploadHomework.jsp");
            }

        }else{
            req.setAttribute("error","该节课没有作业");
            dispatcher=req.getRequestDispatcher("/TeacherPage/UploadHomework.jsp");
        }
        dispatcher.forward(req,resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
