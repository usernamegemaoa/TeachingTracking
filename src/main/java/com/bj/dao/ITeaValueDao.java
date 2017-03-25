package com.bj.dao;

import com.bj.po.TeaValue;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface ITeaValueDao {
    boolean add(TeaValue teavalue);
    boolean deleteById(int value_id);
    boolean update(TeaValue teavalue);
    TeaValue queryByValueid(int value_id);
    List<TeaValue> queryByStuid(int stu_id);
    List<TeaValue> queryByTeaid(int tea_id);
}
