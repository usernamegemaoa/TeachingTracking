package com.bj.dao;

import com.bj.po.Dclass;

import java.util.List;

/**
 * Created by Neko on 2017/3/25.
 */
public interface IDclassDao {
    boolean add(Dclass dclass);
    boolean delById(int class_id);
    boolean update(Dclass dclass);
    List<Dclass> queryByMajorid(int major_id);
    Dclass queryByid(int class_id);
    Dclass queryBytoId(int subject_id, int class_num ,int class_inyear);
}
