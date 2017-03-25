package com.bj.dao;

import com.bj.po.Lesson;
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
public class LessonDaoImpl implements ILessonDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public LessonDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(Lesson lesson) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(lesson);//增加方法 将值添加进数据库
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
    public boolean deleteById(int lesson_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Lesson le = (Lesson) session.load(Lesson.class,lesson_id);//查询要删什么 主键
            session.delete(le);
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
    public boolean update(Lesson lesson) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(lesson);//增加方法 如果ID存在 则为更新
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
    public List<Lesson> queryByLessonid(int lesson_id) {
        List<Lesson> le = null;
        try {
            session = sf.openSession();
            String hql = "from Lesson as q where q.lessonId="+lesson_id;//组合查询语句
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
    public List<Lesson> queryBySubjectid(int subject_id) {
        List<Lesson> le = null;
        try {
            session = sf.openSession();
            String hql = "from Lesson as q where q.subjectId="+subject_id;//组合查询语句
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
    public Lesson queryByLessonnum(int subject_id, int lesson_num) {
        Lesson le = null;
        List<Lesson> list = null;
        try {
            session = sf.openSession();
            String hql = "from Lesson as q where q.subjectId="+subject_id+" and q.lessonNum="+lesson_num;//组合查询语句
            Query q = session.createQuery(hql);
            list = q.list();
            le = list.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return le;
    }
}
