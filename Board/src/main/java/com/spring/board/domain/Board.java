package com.spring.board.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//lombok 어노테이션
//클래스 내 모든 필드의 Get 매소드를 자동 생성
@Getter
@Setter
//기본 생성자 자동 추가
//public 클래스명(){} 와 같은 효과
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    //해당 테이블의 PK 필드를 나타냄
    //PK 의 생성 규칙을 나타냄 strategy = GenerationType.IDENTITY 로 자동 증가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "board",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    private List<MyFile> fileList = new ArrayList<>();

    // Board에서 파일 처리 위함
    public void addFile(MyFile file) {
        this.fileList.add(file);

        // 게시글에 파일이 저장되어있지 않은 경우
        if (file.getBoard() != this)
            // 파일 저장
            file.setBoard(this);
    }
}
