package com.bj.dao;

import com.bj.po.Feedback;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface IFeedbackDao {
    boolean add(Feedback feedback);
    boolean deleteById(int feedback_id);
    boolean update(Feedback feedback);
    List<Feedback> queryByFeedbackid(int feedback_id);
    List<Feedback> queryByStuid(int stu_id);
    List<Feedback> queryByLessonid(int lesson_id);
}
