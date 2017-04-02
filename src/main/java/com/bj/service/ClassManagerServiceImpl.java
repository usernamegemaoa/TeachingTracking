package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Lesson;
import com.bj.po.StuLesson;
import com.bj.po.Student;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neko on 2017/3/25.
 */
public class ClassManagerServiceImpl implements IClassManagerService {
    private IStuLessonDao iStuLessonDao = new StuLessonDaoImpl();
    private ILessonDao iLessonDao = new LessonDaoImpl();
    private IStudentDao iStudentDao = new StudentDaoImpl();
    @Override
    public boolean addStulesson(StuLesson stuLesson) {
        return iStuLessonDao.add(stuLesson);
    }

    @Override
    public List<StuLesson> queryByStuid(int stu_id, int subject_id) {
        List<Lesson> lessonList = iLessonDao.queryBySubjectid(subject_id);//该科目下的课时编号
        List<StuLesson> stulessonList = null;
        Lesson lesson = null;
        StuLesson stuLesson = null;
        for(int i = 0;i<lessonList.size();i++){
            lesson = lessonList.get(i);
            stuLesson = iStuLessonDao.queryByStuLesson(stu_id,lesson.getLessonId());//从表dlesson中取出的课时编号来查询该学生的出勤状态
            stulessonList.add(i,stuLesson);//将该学生的该门课的出勤情况储存在List中
        }
        return stulessonList;
    }

    @Override
    public List<Integer> queryByClassid(int subject_id, int class_id,int lesson_id){
        List<Integer> ratelist = new ArrayList<Integer>();//需要new ArrayList 否则空指针异常
        List<Student> studentList= null;//班级的学生列表
        int stat_man = 0;//出勤人数
        int class_man = 0;//班级人数
        studentList = iStudentDao.queryByClass_id(class_id);
        class_man = studentList.size();//班级人数
        for(int i = 0;i<class_man ;i++){
            int work = iStuLessonDao.queryByStuLesson(studentList.get(i).getStuId(),lesson_id).getStleWork();//取出该学生该课时出勤状态
            if(work == 1){//如果出勤了出勤人数加一
                stat_man++;
            }
        }
        double work_rate =  (double)stat_man/(double)class_man * 100;//出勤率
        ratelist.add((int)work_rate);
        ratelist.add(stat_man);
        ratelist.add(class_man);

        return ratelist;
    }
}
