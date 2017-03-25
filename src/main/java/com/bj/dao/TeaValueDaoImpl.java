package com.bj.dao;

import com.bj.po.TeaValue;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Neko on 2017/3/21.
 */
public class TeaValueDaoImpl implements ITeaValueDao{
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public TeaValueDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(TeaValue teavalue) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(teavalue);//增加方法 将值添加进数据库
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
    public boolean deleteById(int value_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            TeaValue tv = (TeaValue) session.load(TeaValue.class,value_id);//查询要删什么 主键
            session.delete(tv);
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
    public boolean update(TeaValue teavalue) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(teavalue);//增加方法 如果ID存在 则为更新
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
    public TeaValue queryByValueid(int value_id) {
        List<TeaValue> tv = null;
        TeaValue teaValue = null;
        try {
            session = sf.openSession();
            String hql = "from TeaValue as q where q.valueId="+value_id;//组合查询语句
            Query q = session.createQuery(hql);
            tv = q.list();
            teaValue = tv.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teaValue;
    }

    @Override
    public List<TeaValue> queryByStuid(int stu_id) {
        List<TeaValue> tv = null;
        try {
            session = sf.openSession();
            String hql = "from TeaValue as q where q.stuId="+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            tv = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tv;
    }

    @Override
    public List<TeaValue> queryByTeaid(int tea_id) {
        List<TeaValue> tv = null;
        try {
            session = sf.openSession();
            String hql = "from TeaValue as q where q.teaId="+tea_id;//组合查询语句
            Query q = session.createQuery(hql);
            tv = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tv;
    }
}
