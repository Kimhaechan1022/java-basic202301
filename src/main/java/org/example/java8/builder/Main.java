package org.example.java8.builder;

public class Main {

    public static void main(String[] args) {

        // setter를 쓰면 필수값을 지나칠수 있다.
        // 생성자를 쓰기에도 null을 채워야하고 파라미터 순서를 기억해서 입력해야한다.

        // 그래서 옛날에는 필수입력을 생성자로 만듬(기본생성자, allArg를 막음) 그리고 선택값은 setter로 입력

        Member mem1 = Member.builder()
                .account("ac")
                .age(12)
                .password("123")
                .build();

        Board board = Board.builder()
                .id(1L)
                .content("testcon")
                .build();

    }
}
