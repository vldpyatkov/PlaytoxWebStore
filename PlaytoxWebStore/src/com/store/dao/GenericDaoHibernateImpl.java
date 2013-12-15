package com.store.dao;

import com.store.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/7/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenericDaoHibernateImpl <T, PK extends Serializable>
        implements IGenericDao<T, PK> {
    private Class<T> type;

    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }

    public PK create(T o) {
        return (PK) getSession().save(o);
    }

    public T read(PK id) {
        return (T) getSession().get(type, id);
    }

    public void update(T o) {
        getSession().update(o);
    }

    public void delete(T o) {
        getSession().delete(o);
    }

    // Не показаны реализации getSession() и setSessionFactory()

    private static Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
