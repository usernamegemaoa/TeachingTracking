package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Lesson;
import com.bj.po.Major;
import com.bj.po.Subject;

import java.util.List;

/**
 * Created by Neko on 2017/3/18.
 */
public class MajorServiceImpl implements IMajorService {
    private IMajorDao iMajorDao = new MajorDaoImpl();
    private ISubjectDao iSubjectDao = new SubjectDaoImpl();
    private ILessonDao iLessonDao = new LessonDaoImpl();

    @Override
    public boolean addMajor(Major major) {
        return iMajorDao.add(major);
    }

    @Override
    public boolean addSubject(Subject subject) {
        boolean flag = false;
        flag = iSubjectDao.add(subject);
        Subject subject1 = new Subject();
        //添加后反查 科目ID
        subject1 = iSubjectDao.querySubject(subject.getMajorId(),subject.getSubjectName(),subject.getSubjectYear());
        int id = subject1.getSubjectId();//科目ID
        if(flag){
            for(int i = 0;i<subject.getSubjectTimes();i++){
                Lesson lesson = new Lesson();
                lesson.setSubjectId(id);
                lesson.setLessonNum(i+1);
                flag = iLessonDao.add(lesson);
                if(i+1==subject.getSubjectTimes()){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public boolean delMajor(int major_id) {
        return iMajorDao.deleteById(major_id);
    }

    @Override
    public boolean delSubject(int subject_id) {
        return iSubjectDao.deleteById(subject_id);
    }

    @Override
    public boolean updateMajor(Major major) {
        return iMajorDao.update(major);
    }

    @Override
    public boolean updateSubject(Subject subject) {
        return iSubjectDao.update(subject);
    }

    @Override
    public List<Major> queryMajorall() {
        return iMajorDao.queryAll();
    }

    @Override
    public List<Subject> querySubjectall() {
        return iSubjectDao.queryAll();
    }

    @Override
    public Major queryByMajorid(int major_id) {
        return iMajorDao.queryByMajorid(major_id);
    }

    @Override
    public Subject queryBySubjectid(int subject_id) {
        return iSubjectDao.queryBySubjectid(subject_id);
    }

    @Override
    public List<Subject> queryBySubjecttoMajor(int major_id) {
        return iSubjectDao.queryByMajorid(major_id);
    }
}
