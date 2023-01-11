package org.example.java8.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        // 정렬을 위해 비교 기준을 세움, 해당 클래스에 Comparable 인터페이스 구현해야함
        List<Person> pList = new ArrayList<>(
                List.of(
                new Person("김철수",11),
                new Person("홍길동",22),
                new Person("박영희",33),
                new Person("희",34)
        ));

//        pList.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getName().compareTo(o1.getName());
//            }
//        });

        pList.sort(comparing(Person::getAge).reversed());

        System.out.println(pList);
    }
}
