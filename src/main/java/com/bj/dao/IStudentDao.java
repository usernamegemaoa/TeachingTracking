package com.bj.dao;

import com.bj.po.Student;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface IStudentDao {

    boolean add(Student student);
    boolean deleteById(int stu_id);
    boolean update(Student student);
    Student queryByStuid(int stu_id);
    boolean login(int stu_id, String stu_pwd);

}
