package com.bj.service;

import com.bj.dao.IMajorDao;
import com.bj.dao.MajorDaoImpl;
import com.bj.po.Major;

/**
 * Created by Neko on 2017/3/18.
 */
public class MajorServiceImpl implements IMajorService {
    private IMajorDao iMajorDao = new MajorDaoImpl();

    @Override
    public boolean add(Major major) {
        return iMajorDao.add(major);
    }
}
