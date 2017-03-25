package com.bj.service;

import com.bj.dao.FeedbackDaoImpl;
import com.bj.po.Feedback;

import java.util.List;

/**
 * Created by Neko on 2017/3/23.
 * 教学反馈模块（教师查看，学生提交）
 */
public interface IFeedbackService {
    boolean add(Feedback feedback);
    Feedback queryByFeedbackid(int feedback_id);
    List<Feedback> queryByStuid(int stu_id);//查询学生的疑问反馈
    List<Feedback> queryByLessonid(int subject_id,int lesson_num);//查询某节课的学生疑问反馈

}
