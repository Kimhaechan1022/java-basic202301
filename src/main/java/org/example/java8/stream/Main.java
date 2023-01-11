package org.example.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Main {

    /**
     * 요리 목록에서 칼로리가 400칼로리 보다 작은 요리들만추출해서
     * 칼로리가 낮은 순서대로 오름차 정렬한 후
     * 그 요리의 이름들만 추출해서 리스트로 만들고 싶어요~!
     */

    //스트림을 사용하지않은 코드
    public static List<String> getHealthyDishName1(List<Dish> menu) {

        // 400칼로리 미만 요리만 담을거임
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        // 칼로리 낮은 순으로 오름차 정렬
        lowCaloricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });

        // 요리의 이름을 담을 리스트
        List<String> dishName = new ArrayList<>();
        for (Dish lowCaloricDish : lowCaloricDishes) {
            dishName.add(lowCaloricDish.getName());
        }
        return dishName;
    }


    //stream 써볼꺼임

    public static List<String> getHealthyDishName2(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {

        List<String> healthyDishName1 = getHealthyDishName1(Dish.menu);
        System.out.println(healthyDishName1);
        List<String> healthyDishName2 = getHealthyDishName2(Dish.menu);
        System.out.println(healthyDishName2);
    }
}
