package com.bj.dao;

import com.bj.po.StuAll;

import java.util.List;

/**
 * Created by Neko on 2017/3/20.
 */
public interface IStuAllDao {
    boolean add(StuAll stuall);
    boolean deleteById(int test_id);
    boolean update(StuAll stuall);
    List<StuAll> queryByStuid(int stu_id);
    List<StuAll> queryByExamid(int exam_id);
}
