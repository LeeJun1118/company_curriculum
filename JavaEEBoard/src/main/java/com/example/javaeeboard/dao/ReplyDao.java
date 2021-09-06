package com.example.javaeeboard.dao;

import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.beans.reply;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDao extends CommonDao{
    public static ReplyDao getInstance() {
        ReplyDao commentDao = new ReplyDao();
        commentDao.SetDB();
        return commentDao;
    }

    public void insertReply(reply reply) throws SQLException{
        GetDB().insert("insertReply", reply);
        return ;
    }

    public reply getReply(int id_board) throws SQLException { //리스트
        return (reply) GetDB().queryForObject("getReply",id_board);
    }

    public ArrayList<reply> getReplyList(int id_board) throws SQLException  {
        return (ArrayList<reply>)GetDB().queryForList("getReplyList", id_board);
    }
}
