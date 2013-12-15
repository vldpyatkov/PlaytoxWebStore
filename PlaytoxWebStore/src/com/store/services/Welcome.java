package com.store.services;

import com.store.dao2.dao.UserDao;
import com.store.markers.ClientService;
import com.store.markers.ManagerService;
import com.store.utils.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/4/13
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagerService
@ClientService
public class Welcome extends AService {

    private UserDao userDao;

    @Override
    public void init() {
        super.init();
        userDao = new UserDao(HibernateUtil.getSessionFactory());

    }

    @Override
    public void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        request.setAttribute("users", userDao.getAll());
        forwardToJsp(request, response);
    }
}
