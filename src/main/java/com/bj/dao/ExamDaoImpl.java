package com.bj.dao;

import com.bj.po.Exam;
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
public class ExamDaoImpl implements IExamDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public ExamDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(Exam exam) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(exam);//增加方法 将值添加进数据库
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
    public boolean deleteById(int exam_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Exam ex = (Exam) session.load(Exam.class,exam_id);//查询要删什么 主键
            session.delete(ex);
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
    public boolean update(Exam exam) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(exam);//增加方法 如果ID存在 则为更新
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
    public Exam queryByExamid(int exam_id) {
        Exam ex = null;
        try {
            session = sf.openSession();
            ex = (Exam) session.load(Exam.class,exam_id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ex;
    }

    @Override
    public Exam queryByExamonly(int subject_id, String exam_time, String exam_ab) {
        Exam exam = null;
        try {
            session = sf.openSession();
            String hql = "from Exam as q where q.subjectId="+subject_id+" and q.examTime ="+"'"+exam_time+"'"+" and q.examAb="+"'"+exam_ab+"'";//组合查询语句
            Query q = session.createQuery(hql);
            List<Exam> li = q.list();
            exam = li.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return exam;
    }

    @Override
    public List<Exam> queryBySubject(int subject_id) {
        List<Exam> ex = null;
        try {
            session = sf.openSession();
            String hql = "from Exam as q where q.subjectId="+subject_id;//组合查询语句
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
