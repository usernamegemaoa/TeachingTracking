package com.bj.dao;

import com.bj.po.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Neko on 2017/3/21.
 */
public class StudentDaoImpl implements IStudentDao {
    private Configuration cfg;
    private Session session;
    private SessionFactory sf;
    private Transaction trans;
    public StudentDaoImpl(){
        cfg = new Configuration().configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
    }

    @Override
    public boolean add(Student student) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.save(student);//增加方法 将值添加进数据库
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
    public boolean deleteById(int stu_id) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            Student st = (Student) session.load(Student.class,stu_id);//查询要删什么 主键
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
    public boolean update(Student student) {
        try {
            session = sf.openSession();
            trans = session.beginTransaction();//事务
            session.saveOrUpdate(student);//增加方法 如果ID存在 则为更新
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
    public Student queryByStuid(int stu_id) {
        Student st = null;
        try {
            session = sf.openSession();
            st = (Student) session.load(Student.class,stu_id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return st;
    }

    @Override
    public boolean login(int stu_id, String stu_pwd) {
        boolean flag = false;
        Student st = null;
        try {
            session = sf.openSession();
            st = (Student) session.load(Student.class,stu_id);
            if(st.getStuId()==stu_id && stu_pwd.equals(st.getStuPwd())){
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
