package com.example.javaeeboard.Model;

import com.example.javaeeboard.common.CommonDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao extends CommonDao {
    public static BoardDao getInstance(){
        BoardDao boardDao = new BoardDao();
        return boardDao;
    }
    public ArrayList<Board> getBoardList() throws SQLException{
        ResultSet rs = null;
        String sql = "select * from board order by id_board desc";
        rs = openConnection().executeQuery(sql);

        ArrayList<Board> boardList = new ArrayList<Board>();

        while (rs.next()){
            Board board = new Board();

            board.setId_board(rs.getInt("id_board"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            boardList.add(board);
        }
        closeConnection();
        return boardList;
    }
}
