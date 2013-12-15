package com.store.dao2.dao;

import com.store.gen.UsersEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/8/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends GenericDaoImpl<UsersEntity, Integer> {

    public static final String LOGIN = "login";

    @Autowired
    public UserDao(@Qualifier("sessionFactory") org.hibernate.SessionFactory sessionFactory) {
        super(sessionFactory, UsersEntity.class);
    }

    public UsersEntity findUserByLogin(String login, HttpServletRequest request) {
        Session session = getSession();
        List<UsersEntity> users = session.createCriteria(UsersEntity.class).add(Restrictions.eq(LOGIN, login)).list();
        if (users.isEmpty()) {
            return null;
        }
        session.close();
        return users.get(0);
    }

}
