package com.bj.dao;

import com.bj.po.Question;

import java.util.List;

/**
 * Created by Neko on 2017/3/20.
 */
public interface IQuestionDao {
    public boolean add(Question question);
    public boolean deleteById(int question_id);
    public boolean update(Question question);
    public Question queryByQuestionid(int question_id);
    //根据试卷编号和卷子中的题号来查询试题
    public Question queryByQuestionexam(int question_id,int question_exam);
    public List<Question> queryByExamid(int exam_id);



}
