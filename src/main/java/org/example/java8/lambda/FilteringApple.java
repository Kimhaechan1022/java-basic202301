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
     *
     */

}
