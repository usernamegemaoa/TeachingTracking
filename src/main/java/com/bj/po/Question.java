package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/20.
 */
public class Question {
    private int questionId;
    private int questionExam;
    private int examId;
    private int questionMark;
    private int questionHard;
    private String questionText;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionExam() {
        return questionExam;
    }

    public void setQuestionExam(int questionExam) {
        this.questionExam = questionExam;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(int questionMark) {
        this.questionMark = questionMark;
    }

    public int getQuestionHard() {
        return questionHard;
    }

    public void setQuestionHard(int questionHard) {
        this.questionHard = questionHard;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != question.questionId) return false;
        if (questionExam != question.questionExam) return false;
        if (examId != question.examId) return false;
        if (questionMark != question.questionMark) return false;
        if (questionHard != question.questionHard) return false;
        if (questionText != null ? !questionText.equals(question.questionText) : question.questionText != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + questionExam;
        result = 31 * result + examId;
        result = 31 * result + questionMark;
        result = 31 * result + questionHard;
        result = 31 * result + (questionText != null ? questionText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
