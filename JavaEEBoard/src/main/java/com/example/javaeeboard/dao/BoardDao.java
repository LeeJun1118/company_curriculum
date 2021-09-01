package com.example.javaeeboard.dao;

import com.example.javaeeboard.beans.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao extends CommonDao {
    public static BoardDao getInstance() {
        BoardDao boardDao = new BoardDao();
        return boardDao;
    }

    public ArrayList<board> getBoardList() throws SQLException {
        ResultSet rs = null;
        String sql = "select * from board order by id_board desc";
        rs = openConnection().executeQuery(sql);

        ArrayList<board> boardList = new ArrayList<board>();

        while (rs.next()) {
            board board = new board();

            board.setId_board(rs.getInt("id_board"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            boardList.add(board);
        }
        closeConnection();
        return boardList;
    }

    public board getBoard(int id_board) throws SQLException {
        ResultSet rs = null;
        String sql = "SELECT * from board where id_board = " + id_board;
        rs = openConnection().executeQuery(sql);
        board board = new board();

        while (rs.next()) {
            board.setId_board(rs.getInt("id_board"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
        }

        closeConnection();
        return board;
    }
}
