package com.store.dao2.dao;

import org.hibernate.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(propagation=Propagation.MANDATORY)
public class GenericDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {

	private Class<T> type;

	public GenericDaoImpl(SessionFactory sessionFactory, Class<T> type) {
		super.setSessionFactory(sessionFactory);
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public PK create(T o) {
        Session session = getSession();
        session.beginTransaction();
        PK key = (PK) session.save(o);
        session.getTransaction().commit();
        return key;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public T get(PK id) {
		T value = (T) getSession().get(type, id);
		if (value == null) {
            return null;
        }

        if (value instanceof HibernateProxy) {
			Hibernate.initialize(value);
	        value = (T) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
        }
        return value;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<T> getAll() {
		Criteria crit = getSession().createCriteria(type);
		return crit.list();
	}
	
	public void createOrUpdate(T o) {
        Transaction ta = getSession().beginTransaction();
        try {
            getSession().saveOrUpdate(o);
            ta.commit();
        } finally {
            if (!ta.wasCommitted()){
                ta.rollback();
            }
        }

//		if (o instanceof AbstractPersistentObject) {
//			if (((AbstractPersistentObject) o).isCreation()) {
//				getSession().saveOrUpdate(o);
//			} else {
//				getSession().merge(o);
//			}
//		} else {
//			throw new RuntimeException("this method support only AbstractPersistentObject");
//		}
	}


	public void update(T o) {
		getSession().update(o);
	}

	public void delete(T o) {
		getSession().delete(o);
	}

}