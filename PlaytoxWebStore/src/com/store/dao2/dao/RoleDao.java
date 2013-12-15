package com.store.dao2.dao;

import com.store.gen.RolesEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/14/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleDao extends GenericDaoImpl<RolesEntity, Integer> {

    public static final String FIELD_ROLE = "role";

    @Autowired
    public RoleDao(@Qualifier("sessionFactory") org.hibernate.SessionFactory sessionFactory) {
        super(sessionFactory, RolesEntity.class);
    }

    public RolesEntity findRoleByName(String role) {
        Session session = getSession();
        List<RolesEntity> roles = session.createCriteria(RolesEntity.class).add(Restrictions.eq(FIELD_ROLE, role)).list();
        if (roles.isEmpty()) {
            return null;
        }
        return roles.get(0);
    }

}
