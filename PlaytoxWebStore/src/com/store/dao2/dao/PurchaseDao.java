package com.store.dao2.dao;

import com.store.gen.ProductsEntity;
import com.store.gen.PurchaseEntity;
import com.store.gen.UsersEntity;
import com.store.services.IService;
import com.store.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/15/13
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseDao extends GenericDaoImpl<PurchaseEntity, Integer> {

    @Autowired
    public PurchaseDao(@Qualifier("sessionFactory") org.hibernate.SessionFactory sessionFactory) {
        super(sessionFactory, PurchaseEntity.class);
    }

    public void createComplexPurchase(HttpServletRequest request) {
        Session session = getSession();
        try {
            session.beginTransaction();
            List<ProductsEntity> products = session.createCriteria(ProductsEntity.class).list();
            UsersEntity user = (UsersEntity) session.createCriteria(UsersEntity.class).add(Restrictions.eq("login",
                    ((UsersEntity) request.getSession().getAttribute(IService.CLIENT)).getLogin())).list().get(0);
            PurchaseEntity purchase;
            for (ProductsEntity product : products) {
                String countString = request.getParameter(String.valueOf(product.getId()));
                if (countString != null) {
                    Integer count = Integer.valueOf(countString);
                    if (product.getQuantity() >= count) {
                        if (count > 0) {
                            product.setQuantity(product.getQuantity() - count);
                            //session.update(product);
                            for (int i=0; i<count; i++) {
                                purchase = new PurchaseEntity();
                                purchase.setProduct(product);
                                purchase.setPrice(product.getPrice());
                                purchase.setPurchaseDate(new Timestamp(new Date().getTime()));
                                purchase.setUser(user);
                                session.save(purchase);
                            }
                        }
                    }
                }
            }
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        }
    }
}
