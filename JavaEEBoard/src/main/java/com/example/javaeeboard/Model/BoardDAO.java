package com.example.javaeeboard.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.System.out;

public class BoardDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public BoardDAO() {
        try {
            String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
            String dbID = "board";
            String dbPassword = "board";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(dbURL, dbID, dbPassword);
            out.println("Oracle DB에 접속 완료");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
