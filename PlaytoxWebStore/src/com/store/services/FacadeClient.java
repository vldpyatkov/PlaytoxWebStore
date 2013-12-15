package com.store.services;

import com.store.markers.ClientService;
import com.store.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/5/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "FacadeClient", urlPatterns = {"/client"})
public class FacadeClient extends HttpServlet {

    static final String SERVICE_PACKAGE_PATTERN = "com.store.services.%s";
    static final String SERVICE = "service";
    public static final String PAGE_NOT_FOUND_JSP = "/specific_pages/page_not_found.jsp";
    public static final String ERROR = "error";
    public static final String ERROR_JSP = "/specific_pages/error.jsp";

    private HashMap<String, IService> services;

    @Override
    public void init() {
        services = new HashMap<>();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String service = request.getParameter(SERVICE);
            if (service != null) {
                IService serviceInstance = services.get(service);
                if (serviceInstance == null) {
                    serviceInstance = initService(service);
                }
                serviceInstance.processRequest(request, response);
            } else {
                request.getRequestDispatcher(PAGE_NOT_FOUND_JSP).forward(request, response);
                //error  PNF
            }
        } catch (ClassNotFoundException e) {
            request.getRequestDispatcher(PAGE_NOT_FOUND_JSP).forward(request, response);
        } catch (Exception e) {
            request.setAttribute(ERROR, e);
            request.getRequestDispatcher(ERROR_JSP).forward(request, response);
            //throw new ServletException(e);
        }
    }
    
    private synchronized IService initService(String service) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        IService wService = services.get(service);
        if (wService == null) {
            Class serviceClass = null;
            try {
                serviceClass = Class.forName(String.format(SERVICE_PACKAGE_PATTERN, ServletUtils.snakeToCamel(service)));
                if (!serviceClass.isAnnotationPresent(ClientService.class)) {
                    throw new ClassNotFoundException("Service not matched.");
                }
                wService = (IService)serviceClass.newInstance();
                wService.init();
                services.put(service, wService);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, String.format("Service with name %s not loaded.", service));
                throw e;
                //welcome
            }
        }
        return wService;
    }

    @Override
    public void destroy() {
        for (IService service : services.values()) {
            service.destroy();
        }
    }
}
