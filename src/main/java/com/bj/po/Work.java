package com.bj.po;

/**
 * Created by Neko on 2017/3/21.
 */
public class Work {
    private int workId;
    private int subjectId;
    private int lessonId;
    private String workContent;

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (workId != work.workId) return false;
        if (subjectId != work.subjectId) return false;
        if (lessonId != work.lessonId) return false;
        if (workContent != null ? !workContent.equals(work.workContent) : work.workContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workId;
        result = 31 * result + subjectId;
        result = 31 * result + lessonId;
        result = 31 * result + (workContent != null ? workContent.hashCode() : 0);
        return result;
    }
}
