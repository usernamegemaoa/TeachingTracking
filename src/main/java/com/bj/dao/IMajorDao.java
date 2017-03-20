package com.bj.dao;

import com.bj.po.Major;

import java.util.List;

/**
 * Created by Neko on 2017/3/17.
 */
public interface IMajorDao {

    boolean add(Major major);
    Major queryByMajorid(int major_id);
    boolean deleteById(int major_id);
    List<Major> queryAll();
    boolean update(Major major);


}
