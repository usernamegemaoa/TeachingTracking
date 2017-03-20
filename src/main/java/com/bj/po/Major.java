package com.bj.po;

import com.google.gson.Gson;

/**
 * Created by Neko on 2017/3/17.
 */
public class Major {
    private int majorId;
    private String majorName;
    private String majorIntro;

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorIntro() {
        return majorIntro;
    }

    public void setMajorIntro(String majorIntro) {
        this.majorIntro = majorIntro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Major major = (Major) o;

        if (majorId != major.majorId) return false;
        if (majorName != null ? !majorName.equals(major.majorName) : major.majorName != null) return false;
        if (majorIntro != null ? !majorIntro.equals(major.majorIntro) : major.majorIntro != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = majorId;
        result = 31 * result + (majorName != null ? majorName.hashCode() : 0);
        result = 31 * result + (majorIntro != null ? majorIntro.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
