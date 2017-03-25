package com.bj.service;

import com.bj.dao.*;
import com.bj.po.*;
import org.junit.Test;

/**
 * Created by Neko on 2017/3/17.
 */
public class test {
    //private IMajorDao im = new MajorDaoImpl();
    //private ISubjectDao is = new SubjectDaoImpl();
    //private IQuestionDao iq = new QuestionDaoImpl();
    private IExamDao ie = new ExamDaoImpl();
    private IClassManagerService iC = new ClassManagerServiceImpl();
    private IValueService iv = new ValueServiceImpl();
    //private IStuAllDao isa = new StuAllDaoImpl();
    //private IStuExamDao ise = new StuExamDaoImpl();
    @Test
    public void test (){
        //System.out.print(iC.queryByClassid(1,1,1).toString());
        System.out.print(iv.queryByTeaid(1).toString());

        //IStudentDao iStudentDao = new StudentDaoImpl();
        //System.out.print(iStudentDao.queryByClass_id(2).size());
        //System.out.println(ie.queryByExamonly(6,"2016-10-10","A"));
        //StuExam se = new StuExam();


        //ise.add(se);
        //ise.deleteById(5);
        //System.out.println(ise.queryByStuid(2).toString());
        //System.out.println(ise.queryByQuestionid(2).toString());
        //ie.deleteById(4);
       // System.out.println(ie.queryByExamid(3).toString());
       // System.out.println(ie.queryBySubject(3).toString());
        //major.setMajorId(im.queryByMajorname("haligong"));
        //subject.setdMajorByMajorId(major);
       //im.deleteById(4);
        //im.queryByMajorid(3);
        //mj = im.queryAll();
        //for(Major d : mj){
        //    System.out.println(d.getMajorId()+"----"+d.getMajorName()+"----"+d.getMajorIntro());
        //}
       // return true;
    }


}
