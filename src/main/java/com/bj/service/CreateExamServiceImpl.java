package com.bj.service;

import com.bj.dao.ExamDaoImpl;
import com.bj.dao.IExamDao;
import com.bj.dao.IQuestionDao;
import com.bj.dao.QuestionDaoImpl;
import com.bj.po.Exam;
import com.bj.po.Question;

/**
 * Created by Neko on 2017/3/25.
 */
public class CreateExamServiceImpl implements ICreateExamService {
    private IExamDao iExamDao = new ExamDaoImpl();
    private IQuestionDao iQuestionDao = new QuestionDaoImpl();
    @Override//如何做到同时添加试卷并产生题号，两者任一出现错误都不产生生成数据
    public boolean addExam(Exam exam) {
        boolean flag = false;
        flag = iExamDao.add(exam);
        Exam em = new Exam();
        em= iExamDao.queryByExamonly(exam.getSubjectId(),exam.getExamTime(),exam.getExamAb());
        int id = em.getExamId();
        if(flag) {
            for (int i = 0; i < exam.getExamNum(); i++) {
                IQuestionDao iq = new QuestionDaoImpl();
                Question q = new Question();
                q.setQuestionExam(i + 1);
                q.setExamId(id);
                iq.add(q);
                if(i+1==exam.getExamNum()){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override//设定难度，分值需要在前端判断必填
    public boolean addQuestionhard(Question question) {
        return iQuestionDao.update(question);
    }
}
