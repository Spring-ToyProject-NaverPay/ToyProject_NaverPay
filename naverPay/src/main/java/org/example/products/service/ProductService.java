package org.example.products.service;

import org.example.products.dao.ProductDAO;
import org.example.shopping.entity.Product;

import java.util.List;

public class ProductService {

    public List<Product> getAllList(int pId) {
        return ProductDAO.getInstance().getAlllist(pId);
    }

}
