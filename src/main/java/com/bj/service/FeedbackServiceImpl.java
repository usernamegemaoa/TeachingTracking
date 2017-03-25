package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Feedback;
import com.bj.po.Lesson;

import java.util.List;

/**
 * Created by Neko on 2017/3/24.
 */
public class FeedbackServiceImpl implements IFeedbackService {
    private IFeedbackDao iFeedbackDao = new FeedbackDaoImpl();
    @Override
    public boolean add(Feedback feedback) {
        return iFeedbackDao.add(feedback);
    }

    @Override
    public Feedback queryByFeedbackid(int feedback_id) {
        return iFeedbackDao.queryByFeedbackid(feedback_id);
    }

    @Override
    public List<Feedback> queryByStuid(int stu_id) {
        return iFeedbackDao.queryByStuid(stu_id);
    }

    //这里lesson_num是第几节课的意思
    @Override
    public List<Feedback> queryByLessonid(int subject_id, int lesson_num) {
        Lesson lesson = new Lesson();
        ILessonDao iLessonDao = new LessonDaoImpl();
        lesson = iLessonDao.queryByLessonnum(subject_id,lesson_num);
        List<Feedback> list = null;
        list = iFeedbackDao.queryByLessonid(lesson.getLessonId());
        return list;
    }
}
