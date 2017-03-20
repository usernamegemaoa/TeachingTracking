package com.bj.dao;

import com.bj.po.StuAll;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Neko on 2017/3/20.
 */
public class StuAllDaoImpl implements IStuAllDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public StuAllDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(StuAll stuall) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(stuall);//增加方法 将值添加进数据库
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean deleteById(int test_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            StuAll sa = (StuAll) session.load(StuAll.class,test_id);//查询要删什么 主键
            session.delete(sa);
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean update(StuAll stuall) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(stuall);//增加方法 如果ID存在 则为更新
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<StuAll> queryByStuid(int stu_id) {
        List<StuAll> ex = null;
        try {
            session = sf.openSession();
            String hql = "from StuAll as q where q.stuId="+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            ex = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ex;
    }

    @Override
    public List<StuAll> queryByExamid(int exam_id) {
        List<StuAll> ex = null;
        try {
            session = sf.openSession();
            String hql = "from StuAll as q where q.examId="+exam_id;//组合查询语句
            Query q = session.createQuery(hql);
            ex = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ex;
    }
}
