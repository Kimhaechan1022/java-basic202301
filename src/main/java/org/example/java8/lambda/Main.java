package org.example.java8.lambda;

import java.util.List;
import static org.example.java8.lambda.Color.*;
public class Main {
    public static void main(String[] args) {
        // 사과바구니 생성
        List<Apple> appleList = List.of(
                new Apple(80, GREEN),
                new Apple(150, GREEN),
                new Apple(120, RED),
                new Apple(97, RED),
                new Apple(200, GREEN),
                new Apple(85, YELLOW),
                new Apple(75, YELLOW),
                new Apple(50, RED)
        );

        List<Apple> wantedColorApples = FilteringApple.filterApplesByColor(appleList, GREEN);
        for (Apple wantedColorApple : wantedColorApples) {
            System.out.println(wantedColorApple);
        }
    }
}
