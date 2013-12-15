package com.store.services;

import com.store.dao2.dao.Factory;
import com.store.dao2.dao.ProductsDao;
import com.store.dao2.dao.PurchaseDao;
import com.store.gen.ProductsEntity;
import com.store.gen.PurchaseEntity;
import com.store.gen.UsersEntity;
import com.store.markers.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/15/13
 * Time: 1:33 AM
 * To change this template use File | Settings | File Templates.
 */
@ClientService
public class ProductsList extends AService {

    public static final String PRODUCTS = "products";
    public static final String SIGNAL_PURCHASE = "purchase";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String signal = getSignal(request);
        ProductsDao productsDao = Factory.newProductsDao();
        switch (signal) {
            case SIGNAL_PURCHASE:
                PurchaseDao purchaseDao = Factory.newPurchaseDao();
                try {
                    purchaseDao.createComplexPurchase(request);
                } catch (Throwable e) {
                    prepareUserErrorMessage("Purchase is hasn't been Complete", request);
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                    throw e;
                }
                request.setAttribute(PRODUCTS, productsDao.getAll());
                forwardToJsp(request, response);
                return;
            default:
                request.setAttribute(PRODUCTS, productsDao.getAll());
                forwardToJsp(request, response);
        }
    }
}
