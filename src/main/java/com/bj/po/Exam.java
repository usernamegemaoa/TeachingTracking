package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/20.
 */
public class Exam {
    private int examId;
    private int majorId;
    private int subjectId;
    private String examTime;
    private String examAb;
    private int examNum;
    private int examMark;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExamAb() {
        return examAb;
    }

    public void setExamAb(String examAb) {
        this.examAb = examAb;
    }

    public int getExamNum() {
        return examNum;
    }

    public void setExamNum(int examNum) {
        this.examNum = examNum;
    }

    public int getExamMark() {
        return examMark;
    }

    public void setExamMark(int examMark) {
        this.examMark = examMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (examId != exam.examId) return false;
        if (majorId != exam.majorId) return false;
        if (subjectId != exam.subjectId) return false;
        if (examNum != exam.examNum) return false;
        if (examMark != exam.examMark) return false;
        if (examTime != null ? !examTime.equals(exam.examTime) : exam.examTime != null) return false;
        if (examAb != null ? !examAb.equals(exam.examAb) : exam.examAb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = examId;
        result = 31 * result + majorId;
        result = 31 * result + subjectId;
        result = 31 * result + (examTime != null ? examTime.hashCode() : 0);
        result = 31 * result + (examAb != null ? examAb.hashCode() : 0);
        result = 31 * result + examNum;
        result = 31 * result + examMark;
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
