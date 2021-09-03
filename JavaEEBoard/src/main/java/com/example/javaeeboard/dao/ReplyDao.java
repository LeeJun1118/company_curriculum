package com.example.javaeeboard.dao;

import com.example.javaeeboard.beans.reply;

import java.sql.SQLException;

public class ReplyDao extends CommonDao{
    public static ReplyDao getInstance() {
        ReplyDao commentDao = new ReplyDao();
        commentDao.SetDB();
        return commentDao;
    }

    public void insertReply(reply reply) throws SQLException{ // �ۼ�
        GetDB().insert("insertReply", reply);
        return ;
    }

    public reply getReply(int id_board) throws SQLException { //리스트
        return (reply) GetDB().queryForObject("getReply",id_board);
    }
}
