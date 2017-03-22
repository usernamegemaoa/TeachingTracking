package com.bj.dao;

import com.bj.po.Exam;

import java.util.List;

/**
 * Created by Neko on 2017/3/20.
 */
public interface IExamDao {
    public boolean add(Exam exam);
    public boolean deleteById(int exam_id);
    public boolean update(Exam exam);
    public Exam queryByExamid(int exam_id);
    public Exam queryByExamonly(int subject_id, String exam_time, String exam_ab);
    public List<Exam> queryBySubject(int subject_id);

}
