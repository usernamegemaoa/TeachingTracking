package com.bj.service;

import com.bj.dao.ITeaValueDao;
import com.bj.dao.TeaValueDaoImpl;
import com.bj.po.TeaValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neko on 2017/3/25.
 */
public class ValueServiceImpl implements IValueService {
    ITeaValueDao iTeaValueDao = new TeaValueDaoImpl();
    @Override
    public boolean add(TeaValue teavalue) {
        return iTeaValueDao.add(teavalue);
    }

    @Override
    public TeaValue queryByValueid(int value_id) {
        return iTeaValueDao.queryByValueid(value_id);
    }

    @Override
    public List<String> queryByTeaid(int tea_id) {
        List<String> teavalue = new ArrayList<String>();
        int num = 0;//总评分人数
        int value_1 = 0;//value1总分
        int value_2 = 0;//value2总分
        int value_3 = 0;//value3总分
        List<TeaValue> tv = iTeaValueDao.queryByTeaid(tea_id);
        num = tv.size();
        for(int i = 0;i<num;i++){//取出成绩总分 从而计算平均分
            value_1 = value_1 + tv.get(i).getValue1();
            value_2 = value_2 + tv.get(i).getValue2();
            value_3 = value_3 + tv.get(i).getValue3();
        }
        for(int i = 0;i<num;i++){//添加反馈信息
            if(tv.get(i).getValueContent()!= null){
                teavalue.add(tv.get(i).getValueContent());
            }
        }
        //计算平均分回传
        teavalue.add(0,String.valueOf((double)value_1/(double)num));
        teavalue.add(0,String.valueOf((double)value_2/(double)num));
        teavalue.add(0,String.valueOf((double)value_3/(double)num));
        return teavalue;
    }
}
