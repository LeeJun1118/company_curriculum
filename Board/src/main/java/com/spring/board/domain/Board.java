package com.spring.board.domain;


import lombok.*;

import javax.persistence.*;

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
    /*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")*/
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String filename;
}
