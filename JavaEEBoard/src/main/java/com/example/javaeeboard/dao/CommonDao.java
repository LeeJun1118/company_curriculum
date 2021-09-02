package com.example.javaeeboard.dao;

import com.example.javaeeboard.db.sqlconfig.IBatisDBConnector;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CommonDao {
    private SqlMapClient myDB;
    public void SetDB(){
        myDB = IBatisDBConnector.getSqlMapInstance();
    }
    protected SqlMapClient GetDB(){
        return myDB;
    }
}
