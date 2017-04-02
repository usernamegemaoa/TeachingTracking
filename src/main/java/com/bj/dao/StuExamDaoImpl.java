package com.bj.dao;

import com.bj.po.StuExam;
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
public class StuExamDaoImpl implements IStuExamDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public StuExamDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(StuExam stuexam) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(stuexam);//增加方法 将值添加进数据库
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
    public boolean deleteById(int stex_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            StuExam sa = (StuExam) session.load(StuExam.class,stex_id);//查询要删什么 主键
            session.delete(sa);
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
    public boolean update(StuExam stuexam) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(stuexam);//增加方法 如果ID存在 则为更新
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
    public List<StuExam> queryByStuid(int stu_id) {
        List<StuExam> ex = null;
        try {
            session = sf.openSession();
            String hql = "from StuExam as q where q.stuId="+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            ex = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ex;
    }

    @Override
    public List<StuExam> queryByQuestionid(int question_id) {
        List<StuExam> ex = null;
        try {
            session = sf.openSession();
            String hql = "from StuExam as q where q.questionId="+question_id;//组合查询语句
            Query q = session.createQuery(hql);
            ex = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ex;
    }

    @Override
    public StuExam queryByQuestionid(int question_id,int stu_id) {
        StuExam stuExam = null;
        try {
            session = sf.openSession();
            String hql = "from StuExam as q where q.questionId="+question_id+" and q.stuId="+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            List<StuExam> ex = q.list();
            if(ex.size()>0){
                stuExam = ex.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stuExam;
    }
}
