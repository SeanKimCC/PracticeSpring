package ca.sean.kim.spring.dao;

/**
 * Created by 37264 on 5/20/16.
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
        getCurrentSession().persist(entity);
    }

    public void delete(Object entity) {
         getCurrentSession().delete(entity);
    }
}
