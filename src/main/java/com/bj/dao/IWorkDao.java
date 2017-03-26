package com.bj.dao;

import com.bj.po.Work;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface IWorkDao {
    boolean add(Work work);
    boolean deleteById(int work_id);
    boolean update(Work work);
    Work queryByWorkid(int work_id);
    List<Work> queryBySubjectid(int subject_id);
    Work queryByLessonid(int lesson_id);

}
