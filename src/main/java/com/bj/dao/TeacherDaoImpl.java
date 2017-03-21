package com.bj.dao;

import com.bj.po.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Neko on 2017/3/21.
 */
public class TeacherDaoImpl implements ITeacherDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public TeacherDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(Teacher teacher) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(teacher);//增加方法 将值添加进数据库
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
    public boolean deleteById(int tea_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Teacher st = (Teacher) session.load(Teacher.class,tea_id);//查询要删什么 主键
            session.delete(st);
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
    public boolean update(Teacher teacher) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(teacher);//增加方法 如果ID存在 则为更新
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
    public Teacher queryByTeaid(int tea_id) {
        Teacher st = null;
        try {
            session = sf.openSession();
            st = (Teacher) session.load(Teacher.class,tea_id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return st;
    }

    @Override
    public boolean login(int tea_id, String tea_pwd) {
        boolean flag = false;
        Teacher st = null;
        try {
            session = sf.openSession();
            st = (Teacher) session.load(Teacher.class,tea_id);
            if(st.getTeaId()==tea_id && tea_pwd.equals(st.getTeaPwd())){
                flag=true;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }
}
