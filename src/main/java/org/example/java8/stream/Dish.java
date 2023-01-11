package org.example.java8.stream;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter @ToString
@RequiredArgsConstructor // final field 만 골라서 초기화 (AllArg 랑 다름)
public class Dish {
    private final  String name;

    private final boolean vegetarian;

    private final int calories;

    private final Type type;

    public enum Type{
        MEAT, FISH, OTHER;
    }
    public static final List<Dish> menu = List.of(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );
}
