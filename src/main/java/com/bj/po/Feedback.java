package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/21.
 */
public class Feedback {
    private int feedbackId;
    private int stuId;
    private int subjectId;
    private int lessonId;
    private String feedbackTime;
    private String feedbackContent;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
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

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (feedbackId != feedback.feedbackId) return false;
        if (stuId != feedback.stuId) return false;
        if (subjectId != feedback.subjectId) return false;
        if (lessonId != feedback.lessonId) return false;
        if (feedbackTime != null ? !feedbackTime.equals(feedback.feedbackTime) : feedback.feedbackTime != null)
            return false;
        if (feedbackContent != null ? !feedbackContent.equals(feedback.feedbackContent) : feedback.feedbackContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = feedbackId;
        result = 31 * result + stuId;
        result = 31 * result + subjectId;
        result = 31 * result + lessonId;
        result = 31 * result + (feedbackTime != null ? feedbackTime.hashCode() : 0);
        result = 31 * result + (feedbackContent != null ? feedbackContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
