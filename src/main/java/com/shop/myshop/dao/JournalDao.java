package com.shop.myshop.dao;

import com.shop.myshop.entity.Journal;

import java.sql.SQLException;
import java.util.List;

public interface JournalDao {
    void insertJournal(String pid, String uid) throws SQLException;

    List<Journal> selectAllJournal() throws SQLException;
}
