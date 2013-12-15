package com.store.dao2.dao;

import com.store.utils.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/14/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Factory {

    public static UserDao newUserDao() {
        return new UserDao(HibernateUtil.getSessionFactory());
    }

    public static RoleDao newRoleDao() {
        return new RoleDao(HibernateUtil.getSessionFactory());
    }

    public static ProductsDao newProductsDao() {
        return new ProductsDao(HibernateUtil.getSessionFactory());
    }

    public static PurchaseDao newPurchaseDao() {
        return new PurchaseDao(HibernateUtil.getSessionFactory());
    }
}
