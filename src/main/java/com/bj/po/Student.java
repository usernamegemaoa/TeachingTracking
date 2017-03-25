package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/21.
 */
public class Student {
    private int stuId;
    private String stuName;
    private String stuSex;
    private String stuDate;
    private int majorId;
    private int classId;
    private String stuInyear;
    private int stuPwd;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuDate() {
        return stuDate;
    }

    public void setStuDate(String stuDate) {
        this.stuDate = stuDate;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getStuInyear() {
        return stuInyear;
    }

    public void setStuInyear(String stuInyear) {
        this.stuInyear = stuInyear;
    }

    public int getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(int stuPwd) {
        this.stuPwd = stuPwd;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (stuId != student.stuId) return false;
        if (majorId != student.majorId) return false;
        if (stuPwd != student.stuPwd) return false;
        if (stuName != null ? !stuName.equals(student.stuName) : student.stuName != null) return false;
        if (stuSex != null ? !stuSex.equals(student.stuSex) : student.stuSex != null) return false;
        if (stuDate != null ? !stuDate.equals(student.stuDate) : student.stuDate != null) return false;
        if (stuInyear != null ? !stuInyear.equals(student.stuInyear) : student.stuInyear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuId;
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        result = 31 * result + (stuSex != null ? stuSex.hashCode() : 0);
        result = 31 * result + (stuDate != null ? stuDate.hashCode() : 0);
        result = 31 * result + majorId;
        result = 31 * result + (stuInyear != null ? stuInyear.hashCode() : 0);
        result = 31 * result + stuPwd;
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
