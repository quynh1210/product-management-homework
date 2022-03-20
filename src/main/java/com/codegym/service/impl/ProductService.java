package com.codegym.service.impl;

import com.codegym.dao.IProductDao;
import com.codegym.dao.ProductDao;
import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.util.List;

public class ProductService  implements IProductService {
    IProductDao productDao = new ProductDao();
    @Override
    public List<Product> findAll(){
        return productDao.findAll();
    }
    @Override
    public Product findById(int id){
        return productDao.findById(id);
    }
    @Override
    public  void create(Product product){
        productDao.create(product);
    }
    @Override
    public void update(int id, Product product) {
        productDao.update(id,product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

}
