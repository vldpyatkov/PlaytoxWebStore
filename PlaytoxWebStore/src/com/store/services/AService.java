package com.store.services;

import com.store.filters.ClientRequestFilter;
import com.store.utils.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/5/13
 * Time: 1:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class AService implements IService {

    public static final String JSP_ROOT = "/pages/%s.jsp";
    public static final String REDIRECT_URL_PATTERN = "/%s?service=%s";

    @Override
    public void init() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        forwardToJsp(request, response);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void forwardToJsp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jspName = ServletUtils.camelToSnake(getClass().getSimpleName());
        forwardToJsp(jspName, request, response);
    }

    public void forwardToJsp(String page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(String.format(JSP_ROOT, page));
        dispatcher.forward(request, response);
    }

    public void redirectToService(HttpServletRequest request, HttpServletResponse response, Class serviceClass) throws IOException {
        String service = ServletUtils.camelToSnake(serviceClass.getSimpleName());
        String redirectUrl;
        if (request.getAttribute(ClientRequestFilter.IS_CLIENT) != null) {
            redirectUrl = String.format(REDIRECT_URL_PATTERN, CLIENT, service);
        } else {
            redirectUrl = String.format(REDIRECT_URL_PATTERN, MANAGER, service);
        }
        response.sendRedirect(redirectUrl);
    }

    String getSignal(HttpServletRequest request) {
        String signal = request.getParameter(SIGNAL);
        if (signal == null) {
            signal = STRING_EMPTY;
        }
        return signal;
    }

    static void prepareUserErrorMessage(String message, HttpServletRequest request) {
        request.setAttribute(ERROR_MESSAGE, message);
    }

    static boolean isClientRequest(HttpServletRequest request) {
        return request.getAttribute(ClientRequestFilter.IS_CLIENT)== null ? false : true;
    }
}
