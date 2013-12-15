package com.store.dao2.dao;

import com.store.gen.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/15/13
 * Time: 1:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProductsDao extends GenericDaoImpl<ProductsEntity, Integer> {

    @Autowired
    public ProductsDao(@Qualifier("sessionFactory") org.hibernate.SessionFactory sessionFactory) {
        super(sessionFactory, ProductsEntity.class);
    }
}
