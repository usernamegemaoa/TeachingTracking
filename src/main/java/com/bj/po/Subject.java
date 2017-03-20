package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/17.
 */
public class Subject {
    private int subjectId;
    private String subjectName;
    private String subjectIntro;
    private String subjectYear;
    private int subjectTimes;
    private int subjectWork;
    private int MajorId;

    public int getMajorId() {
        return MajorId;
    }

    public void setMajorId(int majorId) {
        MajorId = majorId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectIntro() {
        return subjectIntro;
    }

    public void setSubjectIntro(String subjectIntro) {
        this.subjectIntro = subjectIntro;
    }

    public String getSubjectYear() {
        return subjectYear;
    }

    public void setSubjectYear(String subjectYear) {
        this.subjectYear = subjectYear;
    }

    public int getSubjectTimes() {
        return subjectTimes;
    }

    public void setSubjectTimes(int subjectTimes) {
        this.subjectTimes = subjectTimes;
    }

    public int getSubjectWork() {
        return subjectWork;
    }

    public void setSubjectWork(int subjectWork) {
        this.subjectWork = subjectWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (subjectId != subject.subjectId) return false;
        if (subjectTimes != subject.subjectTimes) return false;
        if (subjectWork != subject.subjectWork) return false;
        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        if (subjectIntro != null ? !subjectIntro.equals(subject.subjectIntro) : subject.subjectIntro != null)
            return false;
        if (subjectYear != null ? !subjectYear.equals(subject.subjectYear) : subject.subjectYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectId;
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (subjectIntro != null ? subjectIntro.hashCode() : 0);
        result = 31 * result + (subjectYear != null ? subjectYear.hashCode() : 0);
        result = 31 * result + subjectTimes;
        result = 31 * result + subjectWork;
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
