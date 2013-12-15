package com.store.services;

import com.store.markers.ManagerService;
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
 * Date: 12/6/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "FacadeManager", urlPatterns = {"/manager"})
public class FacadeManager extends HttpServlet {

    static final String SERVICE_PACKAGE_PATTERN = "com.store.services.%s";
    static final String SERVICE = "service";

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
                //error  PNF
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private synchronized IService initService(String service) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        IService wService = services.get(service);
        if (wService == null) {
            Class serviceClass = null;
            try {
                serviceClass = Class.forName(String.format(SERVICE_PACKAGE_PATTERN, ServletUtils.snakeToCamel(service)));
                if (!serviceClass.isAnnotationPresent(ManagerService.class)) {
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
