package com.bj.dao;

import com.bj.po.Exam;

import java.util.List;

/**
 * Created by Neko on 2017/3/20.
 */
public interface IExamDao {
    boolean add(Exam exam);
    boolean deleteById(int exam_id);
    boolean update(Exam exam);
    Exam queryByExamid(int exam_id);
    List<Exam> queryBySubject(int subject_id);

}
