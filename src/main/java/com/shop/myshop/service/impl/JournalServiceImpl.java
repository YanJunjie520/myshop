package com.shop.myshop.service.impl;

import com.shop.myshop.dao.JournalDao;
import com.shop.myshop.dao.impl.JournalDaoImpl;
import com.shop.myshop.entity.Journal;
import com.shop.myshop.service.JournalService;

import java.sql.SQLException;
import java.util.List;

public class JournalServiceImpl implements JournalService {
    @Override
    public void addJournal(String pid, String uid) throws SQLException {
        JournalDao journalDao = new JournalDaoImpl();
        journalDao.insertJournal(pid, uid);
    }

    @Override
    public List<Journal> findAll() throws SQLException {
        JournalDao journalDao = new JournalDaoImpl();
        return journalDao.selectAllJournal();
    }
}
