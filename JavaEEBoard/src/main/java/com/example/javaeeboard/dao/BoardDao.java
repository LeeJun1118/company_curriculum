package com.example.javaeeboard.dao;

import com.example.javaeeboard.beans.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao extends CommonDao {
    public static BoardDao getInstance() {
        BoardDao boardDao = new BoardDao();
        boardDao.SetDB();
        return boardDao;
    }

    public ArrayList<board>getBoardList(int page) throws SQLException{ //리스트
        return (ArrayList<board>)GetDB().queryForList("getBoardList", null, page, 10);
    }

    @SuppressWarnings("unchecked")
    public board getBoard(int id_board) throws SQLException{ // 콘텐츠
        return (board)GetDB().queryForObject("getBoard", id_board);
    }

}
