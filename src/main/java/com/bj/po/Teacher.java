package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/21.
 */
public class Teacher {
    private int teaId;
    private String teaName;
    private String teaSex;
    private int majorId;
    private String teaPwd;

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getTeaPwd() {
        return teaPwd;
    }

    public void setTeaPwd(String teaPwd) {
        this.teaPwd = teaPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (teaId != teacher.teaId) return false;
        if (majorId != teacher.majorId) return false;
        if (teaName != null ? !teaName.equals(teacher.teaName) : teacher.teaName != null) return false;
        if (teaSex != null ? !teaSex.equals(teacher.teaSex) : teacher.teaSex != null) return false;
        if (teaPwd != null ? !teaPwd.equals(teacher.teaPwd) : teacher.teaPwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teaId;
        result = 31 * result + (teaName != null ? teaName.hashCode() : 0);
        result = 31 * result + (teaSex != null ? teaSex.hashCode() : 0);
        result = 31 * result + majorId;
        result = 31 * result + (teaPwd != null ? teaPwd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
