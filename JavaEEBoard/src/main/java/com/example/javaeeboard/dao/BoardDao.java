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

    public ArrayList<board>getBoardList(String search,int page) throws SQLException{ //리스트
        return (ArrayList<board>)GetDB().queryForList("getBoardList", search, page, 10);
    }

    public ArrayList<board>getSearchList(String search) throws SQLException{ //리스트
        return (ArrayList<board>)GetDB().queryForList("getBoardList", search);
    }
    public ArrayList<board>getMaxList() throws SQLException{ //리스트
        return (ArrayList<board>)GetDB().queryForList("getBoardList", null);
    }

    @SuppressWarnings("unchecked")
    public board getBoard(int id_board) throws SQLException{ // 콘텐츠
        return (board)GetDB().queryForObject("getBoard", id_board);
    }

    public void deleteBoard(int id_board) throws SQLException{ // 딜리트
        GetDB().delete("deleteBoard", id_board);
        return ;
    }

    public void insertBoard(board board) throws SQLException{
        GetDB().insert("insertBoard",board);
        return;
    }

    public void updateBoard(board board) throws SQLException{
        GetDB().update("updateBoard",board);
        return;
    }
}
