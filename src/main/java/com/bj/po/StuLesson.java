package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/21.
 */
public class StuLesson {
    private int stleId;
    private int stuId;
    private int lessonId;
    private int stleWork;

    public int getStleId() {
        return stleId;
    }

    public void setStleId(int stleId) {
        this.stleId = stleId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getStleWork() {
        return stleWork;
    }

    public void setStleWork(int stleWork) {
        this.stleWork = stleWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuLesson stuLesson = (StuLesson) o;

        if (stleId != stuLesson.stleId) return false;
        if (stuId != stuLesson.stuId) return false;
        if (lessonId != stuLesson.lessonId) return false;
        if (stleWork != stuLesson.stleWork) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stleId;
        result = 31 * result + stuId;
        result = 31 * result + lessonId;
        result = 31 * result + stleWork;
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
