package com.shop.myshop.service.impl;

import com.shop.myshop.dao.ProductDao;
import com.shop.myshop.dao.impl.ProductDaoImpl;
import com.shop.myshop.entity.Product;
import com.shop.myshop.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> findProduct(String typeid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.selectProductByTid(typeid);
    }

    @Override
    public Product findProductByPid(String pid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.selectProductByPid(pid);
    }

    @Override
    public List<Product> findProductByPname(String pname) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.selectProductByPname(pname);
    }

    @Override
    public List<Product> findAll() throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.selectAllProduct();
    }

    @Override
    public void deleteProduct(String pid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.deleteProductByPid(pid);
    }

    @Override
    public void modifyProduct(String pid, int tid, String pname, String ptime, String pimage, String pprice, String pstate, String pinfo) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.updateProductByPid(pid, tid, pname, ptime, pimage, pprice, pstate, pinfo);
    }

    @Override
    public void addProduct(int tid, String pname, String pimage, String pprice, String pinfo) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.insertProduct(tid, pname, pimage, pprice, pinfo);
    }

}
