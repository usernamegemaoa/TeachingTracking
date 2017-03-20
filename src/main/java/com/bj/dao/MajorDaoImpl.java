package com.bj.dao;

import com.bj.po.Major;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Neko on 2017/3/17.
 */
public class MajorDaoImpl implements IMajorDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public MajorDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    public boolean add(Major major) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(major);//增加方法 将值添加进数据库
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public Major queryByMajorid(int major_id) {
        Major mj = null;
        try {
            session = sf.openSession();
            mj = (Major) session.load(Major.class,major_id);
            //System.out.println(mj.getMajorId()+"----"+mj.getMajorName()+"----"+mj.getMajorIntro());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return mj;
    }

    public boolean deleteById(int major_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Major dm = (Major) session.load(Major.class,major_id);//查询要删什么 主键
            session.delete(dm);
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public List<Major> queryAll() {
        List<Major> list = null;
        try {
            session = sf.openSession();
            Query q = session.createQuery("from Major as mj");//HQL:Hibernate Query Language
            list = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    public boolean update(Major major) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(major);//增加方法 如果ID存在 则为更新
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }
}
