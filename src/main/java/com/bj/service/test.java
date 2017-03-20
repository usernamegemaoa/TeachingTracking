package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Question;
import org.junit.Test;

/**
 * Created by Neko on 2017/3/17.
 */
public class test {
    private IMajorDao im = new MajorDaoImpl();
    private ISubjectDao is = new SubjectDaoImpl();
    private IQuestionDao iq = new QuestionDaoImpl();
    @Test
    public void test (){
        //List<Major> mj;
        //Major major = new Major();
        //System.out.print(im.queryByMajorid(3).toString());
        //Subject subject = new Subject();
       // System.out.println(im.queryByMajorid(3).toString());
        //System.out.println(is.queryByMajorid(3).toString());

        Question q = new Question();
        q.setQuestionExam(4);
        q.setExamId(2);
        q.setQuestionMark(40);
        q.setQuestionHard(3);
        q.setQuestionText("试卷2");

        //iq.add(q);
        //iq.deleteById(3);
        System.out.println(iq.queryByExamid(1).toString());


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
