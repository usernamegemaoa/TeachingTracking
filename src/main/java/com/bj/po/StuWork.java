package com.bj.po;

/**
 * Created by Neko on 2017/3/21.
 */
public class StuWork {
    private int stwkId;
    private int stuId;
    private int workId;
    private Integer stwkMark;
    private String stwkText;

    public int getStwkId() {
        return stwkId;
    }

    public void setStwkId(int stwkId) {
        this.stwkId = stwkId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public Integer getStwkMark() {
        return stwkMark;
    }

    public void setStwkMark(Integer stwkMark) {
        this.stwkMark = stwkMark;
    }

    public String getStwkText() {
        return stwkText;
    }

    public void setStwkText(String stwkText) {
        this.stwkText = stwkText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuWork stuWork = (StuWork) o;

        if (stwkId != stuWork.stwkId) return false;
        if (stuId != stuWork.stuId) return false;
        if (workId != stuWork.workId) return false;
        if (stwkMark != null ? !stwkMark.equals(stuWork.stwkMark) : stuWork.stwkMark != null) return false;
        if (stwkText != null ? !stwkText.equals(stuWork.stwkText) : stuWork.stwkText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stwkId;
        result = 31 * result + stuId;
        result = 31 * result + workId;
        result = 31 * result + (stwkMark != null ? stwkMark.hashCode() : 0);
        result = 31 * result + (stwkText != null ? stwkText.hashCode() : 0);
        return result;
    }
}
