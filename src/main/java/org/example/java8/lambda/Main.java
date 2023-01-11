package org.example.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import static org.example.java8.lambda.Color.*;

public class Main {

    // 무게가 100그램 이하인 사과 필터 조건 클래스
    public static class LightApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() <= 100;
        }
    }

    public static void main(String[] args) {
        // 사과바구니 생성
        List<Apple> appleList = List.of(new Apple(80, GREEN), new Apple(150, GREEN), new Apple(120, RED), new Apple(97, RED), new Apple(200, GREEN), new Apple(85, YELLOW), new Apple(75, YELLOW), new Apple(50, RED));

//        List<Apple> wantedColorApples = FilteringApple.filterApplesByColor(appleList, GREEN);
//        for (Apple wantedColorApple : wantedColorApples) {
//            System.out.println(wantedColorApple);
//        }

        // 노랑 사과만 필터링 하고 싶다면?
        // ApplePredicate구현체를 두번째 파라미터로하면됨
        // 아 매번 클래스 만들기 짜증난다잉
//        List<Apple> testPassApples = FilteringApple.filterApples(appleList, new YellowApplePredicate());
//        for (Apple testPassApple : testPassApples) {
//            System.out.println(testPassApple);
//        }
//
//        // 무게 100 이하만 필터링 하고 싶다면?
//        List<Apple> testPassApples2 = FilteringApple.filterApples(appleList, new LightApplePredicate());
//        for (Apple testPassApple : testPassApples2) {
//            System.out.println(testPassApple);
//        }


        // 무게가 100그램 보다 큰 사과?
        // 귀찮아 클래스를 자꾸만들기도 -> 익명클래스
//        List<Apple> testPassApples3 = FilteringApple.filterApples(appleList, new ApplePredicate() {
//            @Override
//            public boolean test(Apple apple) {
//                return apple.getWeight() >100;
//            }
//        });
//        for (Apple testPassApple : testPassApples3) {
//            System.out.println(testPassApple);
//        }

        // 람다 사용의 전제조건!!!!, (매개변수) -> {return 실행 결과}
        // 인터페이스의 추상메서드가 단 하나일경우 !!!
        // 람다가 오버라이딩 하는 메서드가 단한줄일 경우 중괄호 생략 가능
        // 그 한줄이 리턴문이라면 리턴 키워드 생략가능 파라미터가 단한개라면 소괄호 생략가능
//        List<Apple> testPassApples3 = FilteringApple.filterApples(appleList, apple -> apple.getColor() == GREEN);
//        List<Apple> testPassApples4 = FilteringApple.filterApples(appleList, apple -> apple.getColor() == RED
//                && apple.getWeight() > 100);
//
//        for (Apple testPassApple : testPassApples4) {
//            System.out.println(testPassApple);
//        }


        FilteringApple.filter(appleList, a -> a.getColor() == RED);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNum = FilteringApple.filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNum);

        /**
         * 리스트와 변경조건을 전달하면 리스트 내부조건에 따라 변환한뒤 반환하는 map 메소드 규현
         * map(appleList, apple -> apple.setColor(RED))
         */
        List<Color> colorOfApples = FilteringApple.map(appleList, Apple::getColor);
        for (Color colorOfApple : colorOfApples) {
            System.out.println(colorOfApple);
        }
        List<Integer> weightList = FilteringApple.map(appleList, Apple::getWeight);
        for (Integer weight : weightList) {
            System.out.println(weight);
        }
        List<AppleInfo> appleInfo = FilteringApple.map(appleList, AppleInfo::new);
        System.out.println(appleInfo);

        List<Apple> colorOfApples2 = FilteringApple.map(appleList, (apples) -> {
            apples.setColor(YELLOW);
            return apples;
        });
        for (Apple colorOfApple : colorOfApples2) {
            System.out.println(colorOfApple);
        }


    }

    // 사과에서 필요한 데이터 몇개만 추출
    @Getter
    @NoArgsConstructor
    @ToString
    @AllArgsConstructor
    public static class AppleInfo {

        private Color color;
        private int weight;
        public AppleInfo(Apple a){
            this.color = a.getColor();
            this.weight = a.getWeight();
        }
    }
}