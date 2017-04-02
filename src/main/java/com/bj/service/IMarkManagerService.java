package com.bj.service;

import java.util.List;

/**
 * Created by Neko on 2017/3/23.
 * 期末成绩管理模块
 */

public interface IMarkManagerService {
    //录入成绩，成绩为List(计入小成绩表和成绩总表的总成绩)
    boolean addStuMark(int subject_id,String exam_time,String exam_ab,int stu_id,List<Integer> mark);
    //查询班级 回传参数（班级平均分，优秀率，及格率，每道题的平均分）
    List<String> queryByclass(int subject_id,int major_id,String exam_time,String exam_ab,int class_num,int class_inyear);
    //查询题目难度
    List<String> queryByQuestionhard(int subject_id,String exam_time,String exam_ab);

}
