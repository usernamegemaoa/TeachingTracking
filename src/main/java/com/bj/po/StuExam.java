package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/20.
 */
public class StuExam {
    private int stexId;
    private int stuId;
    private int questionId;
    private int stexMark;

    public int getStexId() {
        return stexId;
    }

    public void setStexId(int stexId) {
        this.stexId = stexId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getStexMark() {
        return stexMark;
    }

    public void setStexMark(int stexMark) {
        this.stexMark = stexMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuExam stuExam = (StuExam) o;

        if (stexId != stuExam.stexId) return false;
        if (stuId != stuExam.stuId) return false;
        if (questionId != stuExam.questionId) return false;
        if (stexMark != stuExam.stexMark) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stexId;
        result = 31 * result + stuId;
        result = 31 * result + questionId;
        result = 31 * result + stexMark;
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
