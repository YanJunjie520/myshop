package com.shop.myshop.service;

import com.shop.myshop.entity.Journal;

import java.sql.SQLException;
import java.util.List;

public interface JournalService {
    void addJournal(String pid, String uid) throws SQLException;

    List<Journal> findAll() throws SQLException;
}
