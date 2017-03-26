package com.bj.service;

import com.bj.po.StuWork;
import com.bj.po.Work;

import java.util.List;

/**
 * Created by Neko on 2017/3/23.
 * 作业布置查询模块 成绩上传
 */
public interface IHomeworkService {
    boolean addwork(Work work);//创建作业
    boolean addstuwork(StuWork stuWork);//作业成绩提交
    //lesson_num为本科目的第几节课 用于查询lessonid
    Work queryBySubject(int subject_id,int lesson_num);
    //可以按班级查询(class_num 班级号，class_inyear入学年份)
    List<String> queryWorkStat(int subject_id,int class_num,int class_inyear);
    //回传信息格式为(目前作业总数，学号，交的作业总数，作业完成情况作业完成，分隔符$,按顺序回传)

}
