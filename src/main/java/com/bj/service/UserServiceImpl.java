package com.bj.service;

import com.bj.dao.*;
import com.bj.po.Student;
import com.bj.po.Teacher;

/**
 * Created by Neko on 2017/3/24.
 */
public class UserServiceImpl implements IUserService {
    private IStudentDao ist = new StudentDaoImpl();
    private ITeacherDao it = new TeacherDaoImpl();

    @Override
    public boolean addStudent(Student student) {
        return ist.add(student);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
       return it.add(teacher);
    }

    @Override
    public boolean loginStudent(int id, String pwd) {
        boolean flag = false;
        Student st = ist.queryByStuid(id);
        if(pwd.equals(st.getStuPwd())){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean loginTeacher(int id, String pwd) {
        boolean flag = false;
        Teacher t = it.queryByTeaid(id);
        if(pwd.equals(t.getTeaPwd())){
            flag = true;
        }
        return flag;
    }


}
