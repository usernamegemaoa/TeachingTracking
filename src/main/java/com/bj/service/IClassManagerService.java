package com.bj.service;

import com.bj.po.StuLesson;
import com.bj.po.Student;

import java.util.List;

/**
 * Created by Neko on 2017/3/23.
 * 日常教学管理模块
 */
public interface IClassManagerService {
    boolean addStulesson(StuLesson stuLesson);
    List<StuLesson> queryByStuid(int stu_id,int subject_id);//查询某学生改科目出勤情况
    //查询某班级某节课出勤情况 返回值(出勤率，出勤人数，班级总人数)
    List<Integer> queryByClassid(int subject_id,int class_id,int lesson_id);


}
