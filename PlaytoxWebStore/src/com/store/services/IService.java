package com.store.services;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/5/13
 * Time: 12:38 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IService {

    static final String SIGNAL = "signal";
    static final String STRING_EMPTY = "";
    static final String SIGNAL_CREATE = "create";
    static final String SIGNAL_UPDATE = "update";
    public static final String CLIENT = "client";
    public static final String MANAGER = "manager";
    public static final String ERROR_MESSAGE = "error_message";

    public void init();

    public void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws Exception;

    public void destroy();

}
