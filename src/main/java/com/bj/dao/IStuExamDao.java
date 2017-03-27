package com.bj.dao;

import com.bj.po.StuExam;

import java.util.List;

/**
 * Created by Neko on 2017/3/20.
 */
public interface IStuExamDao {
    boolean add(StuExam stuexam);
    boolean deleteById(int stex_id);
    boolean update(StuExam stuexam);
    List<StuExam> queryByStuid(int stu_id);
    List<StuExam> queryByQuestionid(int question_id);
    StuExam queryByQuestionid(int question_id,int stu_id);
}
