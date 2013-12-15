package com.store.filters;

import com.store.services.IService;
import com.store.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/8/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
@WebFilter(filterName = "ClientRequestFilter", urlPatterns={"/client"})
public class ClientRequestFilter implements Filter {

    public static final String CLIENT_SERVICE_LOGIN = "/client?service=login";
    private static final Object PRESENT = new Object();
    public static final String IS_CLIENT = "is_client";
    public static final String SERVICE = "service";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest)req;
            if (request.getSession().getAttribute(IService.CLIENT) == null) {
                String service = request.getParameter(SERVICE);
                if (!"login".equals(service) && !"create_client".equals(service)) {
                    ((HttpServletResponse) resp).sendRedirect(CLIENT_SERVICE_LOGIN);
                    return;
                }
            }
            request.setAttribute(IS_CLIENT, PRESENT);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
