package org.example.java8.builder;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Member {
    private String account; //필수 입력
    private String password; //필수 입력

    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }

    //선택 입력
    private String email;
    private LocalDateTime regDate;
    private int age;
    private boolean emailSend;

    // 빌더 호출 메서드
    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    // 빌더 패턴 구현
    public static class MemberBuilder {
        private String account; //필수 입력
        private String password; //필수 입력
        //선택 입력
        private String email;
        private LocalDateTime regDate;
        private int age;
        private boolean emailSend;

        // 내부 기본 생성자를 private 으로 잠굼
        private MemberBuilder() {

        }

        // 빌더 메서드를 선언
        public MemberBuilder account(String account) {
            this.account = account;
            // acc값이 초기화된 자기자신 객체를 리턴하기 때문에 다음 내용도 .찍고 메소드 호출가능해진다.
            return this;
        }

        public MemberBuilder password(String password) {
            this.password = password;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder regDate(LocalDateTime regDate) {
            this.regDate = regDate;
            return this;
        }

        public MemberBuilder age(int age) {
            this.age = age;
            return this;
        }

        public MemberBuilder emailSend(boolean emailSend) {
            this.emailSend = emailSend;
            return this;
        }
        // 빌딩완료
        public Member build() {
            Member member = new Member(account, password);
            member.setAge(age);
            member.setEmail(email);
            member.setRegDate(regDate);
            member.setEmailSend(emailSend);
            return member;
        }


    }

}
