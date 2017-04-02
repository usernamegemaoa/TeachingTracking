package com.bj.dao;

import com.bj.po.Dclass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Neko on 2017/3/25.
 */
public class DClassDaoImpl implements IDclassDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public DClassDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }
    @Override
    public boolean add(Dclass dclass) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(dclass);//增加方法 将值添加进数据库
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
    public boolean delById(int class_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Dclass dc = (Dclass) session.load(Dclass.class,class_id);//查询要删什么 主键
            session.delete(dc);
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
    public boolean update(Dclass dclass) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(dclass);//增加方法 如果ID存在 则为更新
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
    public List<Dclass> queryByMajorid(int major_id) {
        List<Dclass> list = null;
        try {
            session = sf.openSession();
            String hql = "from Dclass as q where q.subjectId="+major_id;//组合查询语句
            Query q = session.createQuery(hql);
            list = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Dclass queryByid(int class_id) {
        Dclass dc = null;
        try {
            session = sf.openSession();
            String hql = "from Dclass as q where q.classId="+class_id;//组合查询语句
            Query q = session.createQuery(hql);
            List<Dclass> li = q.list();
            dc = li.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dc;
    }

    @Override
    public Dclass queryBytoId(int subject_id, int class_num, int class_inyear) {
        Dclass dc = null;
        try {
            session = sf.openSession();
            String hql = "from Dclass as q where q.subjectId="+subject_id+" and q.classNum ="+class_num+" and q.classInyear="+class_inyear;//组合查询语句
            Query q = session.createQuery(hql);
            List<Dclass> li = q.list();
            if(li.size()>0){
                dc = li.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dc;
    }
}
