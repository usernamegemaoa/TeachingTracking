package com.bj.dao;

import com.bj.po.StuWork;
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
public class StuWorkDaoImpl implements IStuWorkDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public StuWorkDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }


    @Override
    public boolean add(StuWork stuwork) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(stuwork);//增加方法 将值添加进数据库
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
    public boolean deleteById(int stwk_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            StuWork wk = (StuWork) session.load(StuWork.class,stwk_id);//查询要删什么 主键
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
    public boolean update(StuWork stuwork) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(stuwork);//增加方法 如果ID存在 则为更新
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
    public List<StuWork> queryByStuid(int stu_id) {
        List<StuWork> wk = null;
        try {
            session = sf.openSession();
            String hql = "from StuWork as q where q.stuId="+stu_id;//组合查询语句
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
    public StuWork queryByStuWorkid(int work_id,int stu_id) {
        StuWork stuWork = null;
        try {
            session = sf.openSession();
            String hql = "from StuWork as q where q.workId="+work_id+" and q.stuId = "+stu_id;//组合查询语句
            Query q = session.createQuery(hql);
            List<StuWork> wk = q.list();
            if(wk.size()>0){
                stuWork = wk.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stuWork;
    }
}
