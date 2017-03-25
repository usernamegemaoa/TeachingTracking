package com.bj.service;

import com.bj.dao.IMajorDao;
import com.bj.dao.ISubjectDao;
import com.bj.dao.MajorDaoImpl;
import com.bj.dao.SubjectDaoImpl;
import com.bj.po.Major;
import com.bj.po.Subject;

import java.util.List;

/**
 * Created by Neko on 2017/3/18.
 */
public class MajorServiceImpl implements IMajorService {
    private IMajorDao iMajorDao = new MajorDaoImpl();
    private ISubjectDao iSubjectDao = new SubjectDaoImpl();

    @Override
    public boolean addMajor(Major major) {
        return iMajorDao.add(major);
    }

    @Override
    public boolean addSubject(Subject subject) {
        return iSubjectDao.add(subject);
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
