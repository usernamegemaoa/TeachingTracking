package com.bj.dao;

import com.bj.po.Feedback;
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
public class FeedbackDaoImpl implements IFeedbackDao{
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public FeedbackDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }


    @Override
    public boolean add(Feedback feedback) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(feedback);//增加方法 将值添加进数据库
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
    public boolean deleteById(int feedback_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Feedback fb = (Feedback) session.load(Feedback.class,feedback_id);//查询要删什么 主键
            session.delete(fb);
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
    public boolean update(Feedback feedback) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(feedback);//增加方法 如果ID存在 则为更新
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
    public Feedback queryByFeedbackid(int feedback_id) {
        Feedback fb = null;
        try {
            session = sf.openSession();
            String hql = "from Feedback as q where q.feedbackId="+feedback_id;//组合查询语句
            Query q = session.createQuery(hql);
            List<Feedback> list = q.list();
            fb = list.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return fb;
    }

    @Override
    public List<Feedback> queryByStuid(int stu_id) {
        List<Feedback> fb = null;
        try {
            session = sf.openSession();
            String hql = "from Feedback as q where q.stuId="+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            fb = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return fb;
    }

    @Override
    public List<Feedback> queryByLessonid(int lesson_id) {
        List<Feedback> fb = null;
        try {
            session = sf.openSession();
            String hql = "from Feedback as q where q.lessonId="+lesson_id;//组合查询语句
            Query q = session.createQuery(hql);
            fb = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return fb;
    }
}
