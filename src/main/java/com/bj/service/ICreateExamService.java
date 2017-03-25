package com.bj.service;

import com.bj.po.Exam;
import com.bj.po.Question;

/**
 * Created by Neko on 2017/3/23.
 * 试卷创建模块
 */
public interface ICreateExamService {
    boolean addExam(Exam exam);
    boolean addQuestionhard(Question question);//Update(Question_id,Question_mark,Question_hard)
}
