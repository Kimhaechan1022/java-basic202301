package org.example.java8.lambda;

// 람다를 사용가능한지 검증해주는 어노테이션 FunctionalInterface
@FunctionalInterface
public interface ApplePredicate {
    // 사과를 주고 필터조건을 오버라이딩 하면 참 거짓을 반환함
    boolean test(Apple apple);

    // 추상메서드아님
    // 오버라이딩 불가
    static void test2(){

    };

    // 오버라이딩 가능

    default void test3(){

    }
}
