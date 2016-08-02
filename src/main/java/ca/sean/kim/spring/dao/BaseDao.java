//package ca.sean.kim.spring.dao;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//public abstract class BaseDao<E>
//{
//    @Autowired(required = true)
//    private SessionFactory sessionFactory;
//
//    private final Class<E> entityClass;
//
//    /**
//     * Constructor
//     *
//     * @param inEntityClass the entity class this DAO work with
//     */
//    public BaseDao(Class<E> inEntityClass)
//    {
//        this.entityClass = inEntityClass;
//    }
//
//    protected Session getCurrentSession()
//    {
//        return this.sessionFactory.getCurrentSession();
//    }
//
//    protected Criteria getCriteria()
//    {
//        return getCurrentSession().createCriteria(entityClass);
//    }
//
//    @SuppressWarnings("unchecked")
//    @Transactional(propagation = Propagation.REQUIRED)
//    public E findById(long id)
//    {
//        return (E) this.getCurrentSession().get(this.entityClass, id);
//    }
//
//    @SuppressWarnings("unchecked")
//    @Transactional(propagation = Propagation.REQUIRED)
//    public List<E> all()
//    {
//        return this.getCurrentSession().createCriteria(this.entityClass).list();
//
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public long persist(E newEntity)
//    {
//        return (Long) this.getCurrentSession().save(newEntity);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void remove(E newEntity)
//    {
//        this.getCurrentSession().delete(newEntity);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void merge(E entity)
//    {
//        this.getCurrentSession().merge(entity);
//    }
//}
