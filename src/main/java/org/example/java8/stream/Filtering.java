package org.example.java8.stream;

import java.beans.XMLEncoder;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static org.example.java8.stream.Dish.menu;

public class Filtering {
    public static void main(String[] args) {
        // stream의 필터링 : 리턴조건에 맞는데이터만 필터링
        // 요리 목록중채식주의자가 먹을수 있는 음식만필터링해주세요

        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        // for : + syso = forEach
//        vegetarianDishes.forEach(System.out::println);

        //요리 목록중에 고기면서 600칼로리미만 필터링
        List<Dish> selectedMenu = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT && d.getCalories() < 600)
                .collect(toList());

//        selectedMenu.forEach(out::println);


        // 필터링된 요소 중복 제거

        List<Integer> nums = List.of(1,2,3,1,2,6,3,2,3,2,1,4,5);

        //nums 리스트에서 짝수만 필터링한 후 중복을 제거해주세용

//        nums.stream()
//                .filter(n -> n%2==0)
//                .distinct()
//                .collect(toList())
//                .forEach(out::println);
//
//
//        // 원하는 개수만 필터링하기
//        // 칼로리가 300 칼로리 보다 큰 요리중에 처음 발견된 3개만 필터링
//        menu.stream()
//                .filter(d -> d.getCalories() > 300)
//                .limit(3)
//                .collect(toList())
//                .forEach(out::println);
//
//        // 요소 생략해서 필터링
//        // 칼로리가 300 칼로리 보다 큰 요리중에 처음2개는제끼고 필터링
//        menu.stream()
//                .filter(d -> d.getCalories() > 300)
//                .skip(2)
//                .collect(toList())
//                .forEach(out::println);

        // 처음등장하는고기요리 두개
        menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList())
                .forEach(out::println);

    }



}
