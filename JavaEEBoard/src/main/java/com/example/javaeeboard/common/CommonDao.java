package com.example.javaeeboard.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonDao {
    private final String driverName = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String db_id = "board";
    private final String db_pw = "board";

    private Connection con = null;
    private Statement stmt = null;

    public Statement openConnection() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,db_id,db_pw);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.err.println("Oracle Database Connection Something Problem");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return stmt;
    }
    public void closeConnection(){
        try {
            if(!con.isClosed())
                con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
