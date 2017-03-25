package com.bj.dao;

import com.bj.po.StuLesson;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface IStuLessonDao {
    boolean add(StuLesson stulesson);
    boolean deleteById(int stle_id);
    boolean update(StuLesson stulesson);
    List<StuLesson> queryByStuid(int stu_id);
    List<StuLesson> queryByLessonid(int lesson_id);
    StuLesson queryByStuLesson(int stu_id, int lesson_id);
}
