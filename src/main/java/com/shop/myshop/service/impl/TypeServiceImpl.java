package com.shop.myshop.service.impl;

import com.shop.myshop.dao.TypeDao;
import com.shop.myshop.dao.UserDao;
import com.shop.myshop.dao.impl.TypeDaoImpl;
import com.shop.myshop.dao.impl.UserDaoImpl;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.TypeService;

import java.sql.SQLException;

public class TypeServiceImpl implements TypeService {
    @Override
    public int findtid(String typename) throws SQLException {
        //1、创建dao访问对象
        TypeDao typeDao = new TypeDaoImpl();
        //2、执行结果
        return typeDao.findTidByTname(typename);
    }
}
