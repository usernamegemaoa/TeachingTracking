package com.bj.service;

import com.bj.dao.*;
import com.bj.po.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neko on 2017/3/26.
 */
public class StudentStatServiceImpl implements IStudentStatService {
    private IStuLessonDao iStuLessonDao = new StuLessonDaoImpl();
    private ILessonDao iLessonDao = new LessonDaoImpl();
    private IWorkDao iWorkDao = new WorkDaoImpl();
    private IStuWorkDao iStuWorkDao = new StuWorkDaoImpl();
    @Override
    public List<String> queryByStuid(int stu_id, int subject_id) {
        //取出该科目的课时编号数列（目前仅为专业不分学年）
        List<Lesson> lessonList = iLessonDao.queryBySubjectid(subject_id);
        //计算出勤率
        int allclass = lessonList.size();//总数
        int onair = 0;//出勤数
        StuLesson temp = new StuLesson();
        for(int i = 0 ;i< lessonList.size();i++){
            temp=iStuLessonDao.queryByStuLesson(stu_id,lessonList.get(i).getLessonId());
            //取出该学生该节课的出勤记录
            if(temp.getStleWork()==1){
                onair++;
            }
        }
        //取出该科目的作业编号列表 准备查询
        List<Work> workList = iWorkDao.queryBySubjectid(subject_id);
        List<String> templist = new ArrayList<String>();
        int allwork = workList.size(); //目前作业总数
        int uploadwork = 0 ; //交的作业总数
        StuWork stuWork = new StuWork();
        for(int i = 0 ; i < workList.size();i++){
            stuWork = iStuWorkDao.queryByStuWorkid(workList.get(i).getWorkId(),stu_id);
            if(stuWork.getStwkMark()!=0){//如果学生写了这节课的作业
                uploadwork++;
                templist.add(stuWork.getStwkMark().toString());//将成绩保存至暂存数列templist
            }else{//如果没写,成绩记为0
                templist.add(String.valueOf(0));
            }

        }

        //开始将回传数据放入数列
        List<String> returnlist = new ArrayList<String>();
        returnlist.add(String.valueOf(allclass));//总数
        returnlist.add(String.valueOf(onair));//出勤数
        returnlist.add(String.valueOf((double) onair/(double) allclass));//出勤率
        returnlist.add(String.valueOf(allwork));//目前作业总数
        returnlist.add(String.valueOf(uploadwork));//学生上交的作业数
        for(String i:templist){//for each 遍历templist
            returnlist.add(i);//将历次成绩存储
        }
        return returnlist;
    }
}
