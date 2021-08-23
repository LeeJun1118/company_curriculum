package com.search.javasearch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    String message = "오류 없음";
    String href = "/";

    public Message(String message, String href){
        this.message = message;
        this.href = href;
    }
}
