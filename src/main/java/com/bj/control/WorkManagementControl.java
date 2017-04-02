package com.bj.control;

import com.bj.dao.IStudentDao;
import com.bj.dao.StudentDaoImpl;
import com.bj.po.StuLesson;
import com.bj.service.ClassManagerServiceImpl;
import com.bj.service.IClassManagerService;

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
@WebServlet(name = "WorkManagementControl" , urlPatterns = {"/workmanagement"})
public class WorkManagementControl extends HttpServlet {

    private IClassManagerService iClassManager = new ClassManagerServiceImpl();
    private IStudentDao iStudentDao = new StudentDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String majorid = req.getParameter("major");
        //String subjectid = req.getParameter("subject");
        String lessonid = req.getParameter("lesson");
        String stuid = req.getParameter("stuid");

        StuLesson stuLesson = new StuLesson();
        stuLesson.setLessonId(Integer.valueOf(lessonid));
        stuLesson.setStuId(Integer.valueOf(stuid));
        stuLesson.setStleWork(1);

        RequestDispatcher dispatcher = null;



        if(iStudentDao.queryByStuid(Integer.valueOf(stuid))!=null){

            //如果学生是这专业的
            if(iStudentDao.queryByStuid(Integer.valueOf(stuid)).getMajorId() == Integer.valueOf(majorid)){

                if(iClassManager.addStulesson(stuLesson)){
                    req.setAttribute("success","添加成功");
                    dispatcher=req.getRequestDispatcher("/TeacherPage/WorkManagement.jsp");

                }else{
                    req.setAttribute("error","添加失败");
                    dispatcher=req.getRequestDispatcher("/TeacherPage/WorkManagement.jsp");
                }

            }else{
                req.setAttribute("error","该专业没有此学生");
                dispatcher=req.getRequestDispatcher("/TeacherPage/WorkManagement.jsp");
            }

        }else{
            req.setAttribute("error","该学生不存在");
            dispatcher=req.getRequestDispatcher("/TeacherPage/WorkManagement.jsp");
        }


        dispatcher.forward(req,resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
