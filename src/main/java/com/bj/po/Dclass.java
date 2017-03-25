package com.bj.po;

/**
 * Created by Neko on 2017/3/25.
 */
public class Dclass {
    private int classId;
    private Integer classInyear;
    private Integer subjectId;
    private Integer classNum;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Integer getClassInyear() {
        return classInyear;
    }

    public void setClassInyear(Integer classInyear) {
        this.classInyear = classInyear;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dclass dclass = (Dclass) o;

        if (classId != dclass.classId) return false;
        if (classInyear != null ? !classInyear.equals(dclass.classInyear) : dclass.classInyear != null) return false;
        if (subjectId != null ? !subjectId.equals(dclass.subjectId) : dclass.subjectId != null) return false;
        if (classNum != null ? !classNum.equals(dclass.classNum) : dclass.classNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + (classInyear != null ? classInyear.hashCode() : 0);
        result = 31 * result + (subjectId != null ? subjectId.hashCode() : 0);
        result = 31 * result + (classNum != null ? classNum.hashCode() : 0);
        return result;
    }
}
