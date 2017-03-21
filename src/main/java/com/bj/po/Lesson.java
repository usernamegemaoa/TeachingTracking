package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/21.
 */
public class Lesson {
    private int lessonId;
    private int subjectId;
    private int lessonNum;
    private String lessonDate;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(int lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (lessonId != lesson.lessonId) return false;
        if (subjectId != lesson.subjectId) return false;
        if (lessonNum != lesson.lessonNum) return false;
        if (lessonDate != null ? !lessonDate.equals(lesson.lessonDate) : lesson.lessonDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lessonId;
        result = 31 * result + subjectId;
        result = 31 * result + lessonNum;
        result = 31 * result + (lessonDate != null ? lessonDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
