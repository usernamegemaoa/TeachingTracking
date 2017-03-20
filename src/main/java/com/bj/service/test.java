package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Exam;
import com.bj.po.Question;
import com.bj.po.StuAll;
import com.bj.po.StuExam;
import org.junit.Test;

/**
 * Created by Neko on 2017/3/17.
 */
public class test {
    //private IMajorDao im = new MajorDaoImpl();
    //private ISubjectDao is = new SubjectDaoImpl();
    //private IQuestionDao iq = new QuestionDaoImpl();
    //private IExamDao ie = new ExamDaoImpl();
    //private IStuAllDao isa = new StuAllDaoImpl();
    private IStuExamDao ise = new StuExamDaoImpl();
    @Test
    public void test (){

        StuExam se = new StuExam();
        se.setStuId(2);
        se.setQuestionId(1);
        se.setStexMark(5);

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
