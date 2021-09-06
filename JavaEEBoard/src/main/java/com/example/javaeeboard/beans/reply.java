package com.example.javaeeboard.beans;

public class reply {
    private int id_reply;
    private String content;
    private int board_id;

    public int getId_reply() {
        return id_reply;
    }

    public void setId_reply(int id_reply) {
        this.id_reply = id_reply;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }
}
