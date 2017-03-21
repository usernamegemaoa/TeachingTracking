package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/21.
 */
public class TeaValue {
    private int valueId;
    private int stuId;
    private int teaId;
    private int value1;
    private int value2;
    private int value3;
    private String valueContent;

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public int getValue3() {
        return value3;
    }

    public void setValue3(int value3) {
        this.value3 = value3;
    }

    public String getValueContent() {
        return valueContent;
    }

    public void setValueContent(String valueContent) {
        this.valueContent = valueContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeaValue teaValue = (TeaValue) o;

        if (valueId != teaValue.valueId) return false;
        if (stuId != teaValue.stuId) return false;
        if (teaId != teaValue.teaId) return false;
        if (value1 != teaValue.value1) return false;
        if (value2 != teaValue.value2) return false;
        if (value3 != teaValue.value3) return false;
        if (valueContent != null ? !valueContent.equals(teaValue.valueContent) : teaValue.valueContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = valueId;
        result = 31 * result + stuId;
        result = 31 * result + teaId;
        result = 31 * result + value1;
        result = 31 * result + value2;
        result = 31 * result + value3;
        result = 31 * result + (valueContent != null ? valueContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
