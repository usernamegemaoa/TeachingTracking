package com.bj.dao;

import com.bj.po.Work;
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
public class WorkDaoImpl implements IWorkDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public WorkDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }


    @Override
    public boolean add(Work work) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(work);//增加方法 将值添加进数据库
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
    public boolean deleteById(int work_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Work wk = (Work) session.load(Work.class,work_id);//查询要删什么 主键
            session.delete(wk);
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
    public boolean update(Work work) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(work);//增加方法 如果ID存在 则为更新
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
    public Work queryByWorkid(int work_id) {
        Work work = null;
        try {
            session = sf.openSession();
            String hql = "from Work as q where q.workId="+work_id;//组合查询语句
            Query q = session.createQuery(hql);
            List<Work> wk = q.list();
            work = wk.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return work;
    }

    @Override
    public List<Work> queryBySubjectid(int subject_id) {
        List<Work> wk = null;
        try {
            session = sf.openSession();
            String hql = "from Work as q where q.subjectId="+subject_id;//组合查询语句
            Query q = session.createQuery(hql);
            wk = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return wk;
    }

    @Override
    public Work queryByLessonid(int lesson_id) {
        Work work = null;
        try {
            session = sf.openSession();
            String hql = "from Work as q where q.lessonId="+lesson_id;//组合查询语句
            Query q = session.createQuery(hql);
            List<Work> wk = q.list();
            if(wk.size()!= 0) {
                work = wk.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return work;
    }
}
