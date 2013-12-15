package com.store.services;

import com.store.dao2.dao.Factory;
import com.store.dao2.dao.ProductsDao;
import com.store.gen.ProductsEntity;
import com.store.markers.ManagerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/15/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagerService
public class ManageProducts extends AService {

    public static final String SIGNAL_CREATE = "create";
    public static final String SIGNAL_UPDATE = "update";
    public static final String SIGNAL_DELETE = "delete";
    public static final String CREATE_JSP = "manage_products_create";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String signal = getSignal(request);
        switch (signal) {
            case SIGNAL_CREATE:
                String title = request.getParameter("product_title");
                if (title == null) {
                    forwardToJsp(CREATE_JSP, request, response);
                }
                else {
                    ProductsEntity product = new ProductsEntity();
                    product.setDescription(request.getParameter("product_desc"));
                    product.setPrice(new BigDecimal(request.getParameter("product_price")));
                    product.setQuantity(Integer.valueOf(request.getParameter("product_quantity")));
                    product.setTitle(request.getParameter("product_title"));
                    ProductsDao productsDao = Factory.newProductsDao();
                    productsDao.create(product);
                }
                return;
            case SIGNAL_UPDATE:
                return;
            case SIGNAL_DELETE:
                return;
            default:
                forwardToJsp(request, response);
        }
    }
}
