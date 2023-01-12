package org.example.java8.stream;

public class Finding {
    public static void main(String[] args) {


        //anyMatch : 주어진 스트림에서 적어도 한 요소와 일치하는게 있는지 확인
        boolean flag1 = Dish.menu.stream()
                .anyMatch(Dish::isVegetarian);

        System.out.println("flag1 = " + flag1);

        boolean flag2 = Dish.menu.stream()
                .anyMatch(d -> d.getCalories() < 100);

        System.out.println("flag2 = " + flag2);

        //allMatch : 모든 요소가 조건에 일치하는지 확인
        // 요리 목록의 모든 요리가 1000칼로리 미만인가

        boolean flag3 = Dish.menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("flag3 = " + flag3);

        //noneMatch : allMatch 반대연산
        boolean flag4 = Dish.menu.stream()
                .noneMatch(d -> d.getCalories() > 1000);
        System.out.println("flag4 = " + flag4);

    }
}
