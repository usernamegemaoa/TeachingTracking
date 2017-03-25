package com.bj.service;

import com.bj.po.Student;
import com.bj.po.Teacher;

/**
 * Created by Neko on 2017/3/23.
 * 登录注册模块
 */
public interface IUserService {
    boolean addStudent(Student student);
    boolean addTeacher(Teacher teacher);
    boolean loginStudent(int id,String pwd);
    boolean loginTeacher(int id,String pwd);
}
