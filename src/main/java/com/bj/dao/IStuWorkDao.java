package com.bj.dao;

import com.bj.po.StuWork;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public interface IStuWorkDao {
    boolean add(StuWork stuwork);
    boolean deleteById(int stwk_id);
    boolean update(StuWork stuwork);
    List<StuWork> queryByStuid(int stu_id);
    StuWork queryByStuWorkid(int work_id,int stu_id);
}
