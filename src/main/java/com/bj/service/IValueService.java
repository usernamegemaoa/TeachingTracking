package com.bj.service;

import com.bj.po.TeaValue;

import java.util.List;

/**
 * Created by Neko on 2017/3/23.
 * 教师评价模块（教师查看，学生提交）
 */
public interface IValueService {
    //boolean queryByValueid(int value_id);
    boolean add(TeaValue teavalue);//学生提交对教师的评价
    TeaValue queryByValueid(int value_id);//对定编号评价的查询
    List<String> queryByTeaid(int tea_id);
    //对教师查询的结果统计 评分为每项100分
    //回传格式 Value_1 Value_2 Value_3 之后为额外补充部分，由于不记名所以放在一块回传即可


}
