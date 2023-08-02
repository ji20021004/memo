package com.example.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor //기본생성자를 생성한다.
@Getter
@Entity //Memo클래스는 테이블임을 알려준다.
public class Memo extends Timestamped{

    @Id //Primary Key로 설정한다.
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment 적용한다.
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto){ //controller에서 입력
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
