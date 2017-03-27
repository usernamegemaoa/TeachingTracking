package com.bj.service;

import com.bj.dao.*;
import com.bj.po.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neko on 2017/3/26.
 */
public class MarkManagerServiceImpl implements IMarkManagerService {
    private IExamDao iExamDao = new ExamDaoImpl();
    private IStuAllDao iStuAllDao = new StuAllDaoImpl();
    private IStuExamDao iStuExamDao = new StuExamDaoImpl();
    private IQuestionDao iQuestionDao = new QuestionDaoImpl();
    private IDclassDao iDclassDao = new DClassDaoImpl();
    private IStudentDao iStudentDao = new StudentDaoImpl();
    @Override
    public boolean addStuMark(int subject_id,String exam_time,String exam_ab, int stu_id,List<Integer> mark) {
        Exam exam = iExamDao.queryByExamonly(subject_id,exam_time,exam_ab);
        int exam_id = exam.getExamId();//取得试卷编号
        int exam_num = exam.getExamNum();//取得试卷题目数量
        int test_mark = 0; //总成绩
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        List<Question> questionList = iQuestionDao.queryByExamid(exam_id);//取得所有试题题号

        for(int i =0; i<exam_num;i++){//每道题的成绩输入stu_exam
            StuExam stuExam = null;
            stuExam.setStuId(stu_id);
            stuExam.setQuestionId(questionList.get(i).getQuestionId());
            stuExam.setStexMark(mark.get(i));
            test_mark = test_mark +mark.get(i);
            flag1 = iStuExamDao.add(stuExam);
        }
        //将总成绩计入stu_all
        StuAll stuAll = null;
        stuAll.setStuId(stu_id);
        stuAll.setExamId(exam_id);
        stuAll.setTestMark(test_mark);
        flag2 = iStuAllDao.add(stuAll);
        if(flag1 && flag2){
           flag3 = true;
        }
        return flag3;

    }

    @Override
    public List<String> queryByclass(int subject_id, String exam_time, String exam_ab, int class_num,int class_inyear) {
        //取总分，求班级平均分，优秀率，及格率、
        List<Integer> marklist = new ArrayList<Integer>();
        List<Student> studentList = null;
        Dclass dclass =iDclassDao.queryBytoId(subject_id,class_num,class_inyear);//获得班级id
        Exam exam = iExamDao.queryByExamonly(subject_id,exam_time,exam_ab);//获得试卷id
        studentList = iStudentDao.queryByClass_id(dclass.getClassId());//查出班级所有学生学号
        for(int i = 0 ; i<studentList.size();i++){
            StuAll stuAll = iStuAllDao.queryByStuExamid(studentList.get(i).getStuId(),exam.getExamId());//获得第i个学生的成绩
            marklist.add(i,stuAll.getTestMark());//将成绩存入数列中markList
        }
        int class_avg = 0;//平均分
        double class_good = 0;//优秀率
        double class_pass = 0;//及格率
        int class_sigma = 0; //总分
        for(int i = 0 ;i<studentList.size();i++){
            //求总成绩
            class_sigma = class_sigma + marklist.get(i);
            if(marklist.get(i)>=80){
                class_good++;
            }else if(marklist.get(i)>=60){
                class_pass++;
            }
        }
        class_avg = class_sigma/studentList.size();//求平均分
        class_good = class_good/(double) studentList.size();//求优秀率
        class_pass = class_pass/(double) studentList.size();//求及格率
        //每道题的全班总分
        List<Integer> all_exam_mark = new ArrayList<Integer>();
        //求每道题的平均分
        List<Question> questionList = iQuestionDao.queryByExamid(exam.getExamId());//取得试题题号
        for(int i = 0 ; i<questionList.size();i++){
            int StExmark = 0; //临时小题成绩
            for(int j = 0;j<studentList.size();j++) {
                StuExam stuExam = iStuExamDao.queryByQuestionid(questionList.get(i).getQuestionId(), studentList.get(j).getStuId());
                int temp = stuExam.getStexMark();//某小题成绩
                StExmark = StExmark + temp;
                if(j+1==studentList.size()){
                    StExmark = StExmark/studentList.size();
                    all_exam_mark.add(StExmark);//将第i个小题的全班平均分保存至List all_exam_mark
                }
            }
        }
        List<String> returnlist = new ArrayList<String>();
        returnlist.add(String.valueOf(class_avg));
        returnlist.add(String.valueOf(class_good));
        returnlist.add(String.valueOf(class_pass));
        for(int i = 0 ; i<all_exam_mark.size();i++){
            returnlist.add(String.valueOf(all_exam_mark.get(i)));
        }
        return returnlist;
    }

    @Override
    public List<String> queryByQuestionhard(int subject_id, String exam_time, String exam_ab) {
        Exam exam = iExamDao.queryByExamonly(subject_id,exam_time,exam_ab);//试卷id
        List<Question> questionList = iQuestionDao.queryByExamid(exam.getExamId());//试题列表
        List<String> returnlist = new ArrayList<String>();
        for(int i = 0 ; i<questionList.size();i++){
            returnlist.add(String.valueOf(questionList.get(i).getQuestionHard()));
        }


        return returnlist;
    }


}
