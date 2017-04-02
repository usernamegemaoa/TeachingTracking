package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Lesson;
import com.bj.po.StuWork;
import com.bj.po.Student;
import com.bj.po.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neko on 2017/3/26.
 */
public class HomeworkServiceImpl implements IHomeworkService {
    private IWorkDao iWorkDao = new WorkDaoImpl();
    private IStuWorkDao iStuWorkDao = new StuWorkDaoImpl();
    private ILessonDao iLessonDao = new LessonDaoImpl();
    private IDclassDao iDclassDao = new DClassDaoImpl();
    private IStudentDao iStudentDao = new StudentDaoImpl();

    @Override
    public boolean addwork(Work work) {
        return iWorkDao.add(work);
    }

    @Override
    public boolean addstuwork(StuWork stuWork) {
        return iStuWorkDao.add(stuWork);
    }

    @Override
    public Work queryBySubject(int subject_id, int lesson_num) {
        Lesson lesson = iLessonDao.queryByLessonnum(subject_id,lesson_num);
        return iWorkDao.queryByLessonid(lesson.getLessonId());
    }

    @Override
    public List<String> queryWorkStat(int subject_id,int major_id, int class_num,int class_inyear) {
        Integer class_id = null;
        List<Student> studentList = null;
        if(iDclassDao.queryBytoId(subject_id,class_num,class_inyear)!=null){
            class_id =  iDclassDao.queryBytoId(subject_id,class_num,class_inyear).getClassId();//查询班级编号class_id
            studentList = iStudentDao.queryByClass_id(class_id);//取出班级中的学生
        }

        //取出该科目的作业编号列表 准备查询
        List<Work> workList = iWorkDao.queryBySubjectid(major_id);
        List<String> returnlist = null;
        List<String> templist = new ArrayList<String>();
        int allwork = workList.size(); //目前作业总数


        //如果studentlist不为空 再进行格式化
        if(studentList!=null){
            returnlist = new ArrayList<String>();//防止空指针异常
            returnlist.add(String.valueOf(allwork));//作业总数
            int temp_list_p = 0;

            for(int j = 0;j<studentList.size();j++){//对每个学生的作业成绩格式化 并保存至数组中
                int uploadwork = 0 ; //交的作业总数
                for(int i = 0 ; i < workList.size();i++){
                    StuWork stuWork  = null;
                    stuWork = iStuWorkDao.queryByStuWorkid(workList.get(i).getWorkId(),studentList.get(j).getStuId());
                    if(stuWork!=null){//如果不为空再继续（异常处理）
                        if(stuWork.getStwkMark()!=0){//如果学生写了这节课的作业
                            uploadwork++;
                            templist.add(stuWork.getStwkMark().toString());//将成绩保存至暂存数列templist
                        }else{//如果没写,成绩记为0
                            templist.add(String.valueOf(0));
                        }
                    }
                }
                //该同学作业成绩信息处理完毕 开始保存
                returnlist.add(String.valueOf(studentList.get(j).getStuId()));//学号
                returnlist.add(String.valueOf(uploadwork));//完成的作业总数
                for(int i = temp_list_p; i < uploadwork+temp_list_p ;i++){
                    returnlist.add(templist.get(i));//将历次成绩存储
                }
                temp_list_p = temp_list_p + uploadwork;
                /*for(String i:templist){//for each 遍历templist
                    returnlist.add(i);//将历次成绩存储
                }*/
                returnlist.add("$");//用$号进行分隔
            }
        }

        return returnlist;
    }
}
