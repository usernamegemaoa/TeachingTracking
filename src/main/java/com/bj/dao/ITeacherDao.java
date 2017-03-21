package com.bj.dao;

import com.bj.po.Teacher;

/**
 * Created by Neko on 2017/3/21.
 */
public interface ITeacherDao {
    boolean add(Teacher teacher);
    boolean deleteById(int tea_id);
    boolean update(Teacher teacher);
    Teacher queryByTeaid(int tea_id);
    boolean login(int tea_id, String tea_pwd);
}
