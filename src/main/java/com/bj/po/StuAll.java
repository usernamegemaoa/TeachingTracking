package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/20.
 */
public class StuAll {
    private int testId;
    private int stuId;
    private int examId;
    private Integer testMark;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Integer getTestMark() {
        return testMark;
    }

    public void setTestMark(Integer testMark) {
        this.testMark = testMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuAll stuAll = (StuAll) o;

        if (testId != stuAll.testId) return false;
        if (stuId != stuAll.stuId) return false;
        if (examId != stuAll.examId) return false;
        if (testMark != null ? !testMark.equals(stuAll.testMark) : stuAll.testMark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId;
        result = 31 * result + stuId;
        result = 31 * result + examId;
        result = 31 * result + (testMark != null ? testMark.hashCode() : 0);
        return result;
    }
    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
