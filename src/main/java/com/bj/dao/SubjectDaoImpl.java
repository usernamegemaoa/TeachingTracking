package com.bj.dao;

import com.bj.po.Major;
import com.bj.po.Subject;
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
public class SubjectDaoImpl implements ISubjectDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public SubjectDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    public boolean add(Subject subject) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(subject);//增加方法 将值添加进数据库
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public Subject queryBySubjectid(int subject_id) {
        Subject sj = null;
        try {
            session = sf.openSession();
            sj = (Subject) session.load(Subject.class,subject_id);
            //System.out.println(mj.getMajorId()+"----"+mj.getMajorName()+"----"+mj.getMajorIntro());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sj;
    }

    @Override
    public Subject querySubject(int major_id, String subject_name, String subject_year) {
        Subject subject = new Subject();
        try {
            session = sf.openSession();
            String hql = "from Subject as sj where sj.MajorId="+major_id+" and sj.subjectName="+"'"+subject_name+"'"+" and sj.subjectYear="+"'"+subject_year+"'";//组合查询语句
            Query q = session.createQuery(hql);
            List<Subject> li = q.list();
            subject = li.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return subject;
    }

    public List<Subject> queryByMajorid(int major_id) {
        List<Subject> li = null;
        try {
            session = sf.openSession();
            String hql = "from Subject as sj where sj.MajorId="+major_id;//组合查询语句
            Query q = session.createQuery(hql);
            li = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return li;
    }

    public boolean deleteById(int subject_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Subject dm = (Subject) session.load(Subject.class,subject_id);//查询要删什么 主键
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

    public List<Subject> queryAll() {
        List<Subject> list = null;
        try {
            session = sf.openSession();
            Query q = session.createQuery("from Subject as sj");//HQL:Hibernate Query Language
            list = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    public boolean update(Subject subject) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(subject);//增加方法 如果ID存在 则为更新
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
