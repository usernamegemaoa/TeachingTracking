package com.bj.service;

import java.util.List;

/**
 * Created by Neko on 2017/3/23.
 * 学习状态查询模块
 */
public interface IStudentStatService {
    List<String> queryByStuid(int stu_id, int subject_id);
    //查询学生学习状态，回传信息格式为(总课时，出勤数，出勤率，目前作业总数，交的作业总数，作业完成情况作业完成按顺序回传)
}
