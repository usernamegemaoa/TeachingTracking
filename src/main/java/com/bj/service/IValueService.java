package com.bj.service;

import com.bj.po.TeaValue;

/**
 * Created by Neko on 2017/3/23.
 * 教师评价模块（教师查看，学生提交）
 */
public interface IValueService {
    //boolean queryByValueid(int value_id);
    boolean add(TeaValue teavalue);//学生提交对教师的评价
    TeaValue queryByValueid(int value_id);//对定编号评价的查询
    //补充


}
