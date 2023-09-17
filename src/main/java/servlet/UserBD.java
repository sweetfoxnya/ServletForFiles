package servlet;

import org.hibernate.Criteria;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class UserBD {

    private Session session;

    public UserBD(Session session) {this.session = session;};

    public boolean saveUser(User user){
        boolean save = true;
        session = HibernateUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(user);
        }catch (PersistentObjectException e){
            save = false;
        }

        transaction.commit();
        session.close();

        return save;
    }

    public User getUser(String name) {

        session = HibernateUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = getByName("name",name);

        transaction.commit();
        session.close();
        return user;

    }

    public User getByName(String variable, String value){
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq(variable, value)).uniqueResult();
    }

    public static User findById(int id) {
        return (User)HibernateUtil.sessionFactory.openSession().get(User.class, id);
    }

    public boolean delete(User user) {

        boolean delete = true;
        Session session = HibernateUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(user);
        }catch (PersistentObjectException e){
            delete = false;
        }

        transaction.commit();
        session.close();
        return delete;
    }

    public boolean update(User user) {

        boolean update = true;
        Session session = HibernateUtil.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try{
            session.merge(user);
        }catch (PersistentObjectException e){
            update = false;
        }
        tx1.commit();
        session.close();
        return update;
    }

}
