package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilteringApple {
    /**
     * @solution - try1 : 녹색사과를 필터링하는 매서드를 만들어야함
     * @problem
     * - 만약 다른 색 사과르 필터링 해야 할경우 또 다른 메서드를 만들어서 처리해야한다.
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }
    /**
     * @solution - try 2 : 색상을 파라미터화 한다.
     * @problem
     * - 만약 필터 기준이 색상이 아닌 무게라면?
     * - 두번째 파라미터로 무게 기준을 받아내는 메서드를 또 만들어 ?
     * ㄴㄴ
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }
    public static List<Apple> filterApplesByWeightLessThan(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() <= weight) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * @solution - try 3 : 동작을 파라미터화 한다잉! - 추상적 조건으로 필터링
     * - 전달할 함수를 클래스로 감싸서 전달
     * - p 인터페이스를 전달받는데 전달하는 쪽에서 구체화를 수행한다.(조건 검사 로직을 밖으로 뺀다)
     * 결국 test메소드를 전달하는데 목적이있는데 자바에선 불가능함으로 ApplePredicate 클래스로 감싸진 p 객체를 전달
     *
     * @problem
     * - 과일이 사과가 아니라 오렌지면 ?
     * - 과일이 아니라 가전제품이면 ?
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     *
     * 매개 인자의 형식을 확장할수 있는 방법! 제네릭을 사용한다!
     *
     * 재네릭 메서드는 리턴타입앞에 <T> 를 써야함, 변수 아무거나 와바 라는 뜻
     */
    public static <T> List<T> filter(List<T> inventory, GenericPredicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T,R> List<R> map(List<T> inventory, GenericProcess<T,R> p){
        List<R> result = new ArrayList<>();
        for (T t : inventory) {
            R r = p.process(t);
            result.add(r);
        }
        return result;
    }

}
