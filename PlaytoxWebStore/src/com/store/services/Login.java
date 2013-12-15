package com.store.services;

import com.store.dao2.dao.Factory;
import com.store.dao2.dao.UserDao;
import com.store.gen.UsersEntity;
import com.store.markers.ClientService;
import com.store.markers.ManagerService;
import com.store.utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/8/13
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
@ClientService
@ManagerService
public class Login extends AService {

    public static final String SIGNAL_LOGIN = "login";
    public static final String MESSAGE = "message";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String signal = getSignal(request);
        switch (signal) {
            case SIGNAL_LOGIN:
                processLogin(request, response);
                return;
            default:
                forwardToJsp(request, response);
        }
    }

    private void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDao userDao = Factory.newUserDao();
        UsersEntity user = userDao.findUserByLogin(request.getParameter(SIGNAL_LOGIN), request);
        if (user != null) {
            request.getSession().setAttribute(isClientRequest(request)?CLIENT:MANAGER, user);
            redirectToService(request, response, Welcome.class);
        }
        else {
            request.setAttribute(MESSAGE, "User not found");
            forwardToJsp(request, response);
        }
    }
}
