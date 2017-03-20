package com.bj.dao;

import com.bj.po.Question;
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
public class QuestionDaoImpl implements IQuestionDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public QuestionDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(Question question) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(question);//增加方法 将值添加进数据库
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
    public boolean deleteById(int question_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Question dm = (Question) session.load(Question.class,question_id);//查询要删什么 主键
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

    @Override
    public boolean update(Question question) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(question);//增加方法 如果ID存在 则为更新
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
    public Question queryByQuestionid(int question_id) {
        Question q = null;
        try {
            session = sf.openSession();
            q = (Question) session.load(Question.class,question_id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return q;
    }

    @Override
    public Question queryByQuestionexam(int question_id, int question_exam) {
        Question question = null;
        try {
            session = sf.openSession();
            String hql = "from Question as q where q.questionId="+question_id+" and q.questionExam ="+question_exam;//组合查询语句
            Query q = session.createQuery(hql);
            List<Question> li = q.list();
            question = li.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return question;
    }

    @Override
    public List<Question> queryByExamid(int exam_id) {
        List<Question> lq = null;
        try {
            session = sf.openSession();
            String hql = "from Question as q where q.examId="+exam_id;//组合查询语句
            Query q = session.createQuery(hql);
            lq = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lq;
    }
}
