package com.bj.dao;

import com.bj.po.StuLesson;
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
public class StuLessonDaoImpl implements IStuLessonDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public StuLessonDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(StuLesson stulesson) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(stulesson);//增加方法 将值添加进数据库
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
    public boolean deleteById(int stle_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            StuLesson sl = (StuLesson) session.load(StuLesson.class,stle_id);//查询要删什么 主键
            session.delete(sl);
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
    public boolean update(StuLesson stulesson) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(stulesson);//增加方法 如果ID存在 则为更新
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
    public List<StuLesson> queryByStuid(int stu_id) {
        List<StuLesson> le = null;
        try {
            session = sf.openSession();
            String hql = "from StuLesson as q where q.stuId="+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            le = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return le;
    }

    @Override
    public List<StuLesson> queryByLessonid(int lesson_id) {
        List<StuLesson> le = null;
        try {
            session = sf.openSession();
            String hql = "from StuLesson as q where q.lessonId="+lesson_id;//组合查询语句
            Query q = session.createQuery(hql);
            le = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return le;
    }

    @Override
    public StuLesson queryByStuLesson(int stu_id, int lesson_id) {
        StuLesson st = null;
        List<StuLesson> le = null;
        try {
            session = sf.openSession();
            String hql = "from StuLesson as q where q.stuId="+stu_id +" and q.lessonId="+lesson_id;//组合查询语句
            Query q = session.createQuery(hql);
            le = q.list();
            st = le.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return st;
    }
}
