package com.bj.dao;

import com.bj.po.Subject;

import java.util.List;

/**
 * Created by Neko on 2017/3/17.
 */
public interface ISubjectDao {

    boolean add(Subject subject);
    Subject queryBySubjectid(int subject_id);
    Subject queryByMajorid(int Major_id);
    boolean deleteById(int subject_id);
    List<Subject> queryAll();
    boolean update(Subject subject);
}
