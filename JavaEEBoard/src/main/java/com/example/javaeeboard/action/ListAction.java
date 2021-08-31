package com.example.javaeeboard.action;

import com.example.javaeeboard.BoardList;
import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.Model.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

public class ListAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // TODO Auto-generated method stub
        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ResultSet rs = null;

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, "board", "board");
            System.out.println("Oracle DataBase Connection Success.");

            Statement stmt = con.createStatement();
            String sql = "SELECT id_board,title,content from board order by id_board desc";
            rs = stmt.executeQuery(sql);

            ArrayList<Board> boardList = new ArrayList<Board>(); // 이코드는 Board형 배열 형식으로 선언

            while (rs.next()) {
                Board board = new Board();

                board.setId_board(rs.getInt("id_board"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                boardList.add(board);
            }
            request.setAttribute("boardList", boardList);

            con.close();
        } catch (Exception e) {
            System.out.println("Orcale Db connection problem <hr>");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return "list.jsp";
    }

}
