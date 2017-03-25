package com.bj.service;

import com.bj.po.Major;
import com.bj.po.Student;
import com.bj.po.Subject;

import java.util.List;

/**
 * Created by Neko on 2017/3/18.
 * 创建修改专业学科模块
 */
public interface IMajorService {
   boolean addMajor(Major major);
   boolean addSubject (Subject subject);
   boolean delMajor(int major_id);
   boolean delSubject(int subject_id);
   boolean updateMajor(Major major);
   boolean updateSubject(Subject subject);
   List<Major> queryMajorall();
   List<Subject> querySubjectall();
   Major queryByMajorid(int major_id);
   Subject queryBySubjectid(int subject_id);
   List<Subject> queryBySubjecttoMajor(int major_id);

}
