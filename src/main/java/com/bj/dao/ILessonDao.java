package com.bj.dao;

import com.bj.po.Lesson;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface ILessonDao {
    boolean add(Lesson lesson);
    boolean deleteById(int lesson_id);
    boolean update(Lesson lesson);
    List<Lesson> queryByLessonid(int lesson_id);
    List<Lesson> queryBySubjectid(int subject_id);
}
