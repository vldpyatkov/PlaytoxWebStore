package com.store.services;

import com.store.dao2.dao.Factory;
import com.store.dao2.dao.RoleDao;
import com.store.dao2.dao.UserDao;
import com.store.gen.UsersEntity;
import com.store.markers.ClientService;
import com.store.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import static com.google.common.collect.Sets.newHashSet;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/8/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
@ClientService
public class CreateClient extends AService {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        String signal = getSignal(request);
        switch (signal) {
            case SIGNAL_CREATE:
                processCreateAndLogin(request);
                redirectToService(request, response, Welcome.class);
                return;
            default:
                forwardToJsp(request, response);
        }
    }

    private void processCreateAndLogin(HttpServletRequest request) throws NoSuchAlgorithmException {
        UserDao userDao = Factory.newUserDao();
        RoleDao roleDao = Factory.newRoleDao();
        UsersEntity user = new UsersEntity();
        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(ServletUtils.getSecurePassword(request.getParameter(PASSWORD)));
        user.setRoles(newHashSet(roleDao.findRoleByName(CLIENT)));
        userDao.create(user);
        request.getSession().setAttribute(CLIENT, userDao.findUserByLogin(user.getLogin(), request));
    }

}
