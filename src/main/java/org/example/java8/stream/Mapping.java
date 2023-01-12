package org.example.java8.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.example.java8.stream.Dish.menu;

public class Mapping {

    public static void main(String[] args) {
        // map list set과 같은 컬렉션에서만 사용가능함 -> stream
        List<String> dishNames = menu.stream()
                                    .map(Dish::getName)
                                    .collect(toList());
        System.out.println(dishNames.size() +"\n" +"dishNames =" + dishNames);

        System.out.println("============================================");

        List<String> words = List.of(
                "safari", "chrome", "edge", "opera","firefox"
        );

        words.stream()
                .map(str -> str.length())
                .collect(toList())
                .forEach(System.out::println);
        System.out.println("============================================");

        List<Integer> nums = List.of(1,2,3,4,5);

        //nums의 값들을 각각 제곱해서 새로운 리스트를 얻어내고 싶다.

        List<Integer> squares = nums.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println("squares = " + squares);

        System.out.println("============================================");

        // 요리 목록의 총 칼로리 수 구하기 , map 타입을 지정하면 추가메서드를 지원한다.
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("sum = " + sum);

        System.out.println("============================================");
        OptionalDouble average = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .mapToInt(d -> d.getCalories())
                .average();

        average.ifPresent(System.out::println);
        // 육류요리의 평균 칼로리
        double meatAverageCalories = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .mapToInt(Dish::getCalories)
                .average()
                .getAsDouble()
                ;

        // Optional은 자동 널체크 지원 : ifPresent
//        meatAverageCalories
//                .ifPresent(cal -> System.out.println("cal: " + cal));

        System.out.println("meatAverageCalories = " + meatAverageCalories);


        // 만약에 DB에서 특정 게시물의 정보를 조회했는데 게시물이 없으면 null
        // Article article = repository.findByArticle(330);
        // if (article != null) article.getTitle();


    }
}
