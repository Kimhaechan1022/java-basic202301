package org.example.java8.compare;


import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    // 객체 정렬 시도시 나이순으로 정렬이 가능해진다잉
    @Override
    public int compareTo(Person o) {
        /**
         * 비교 대상 객체 2개를 전달받음 (Person this[hide], Person o)
         * 비교대상(o) 이 더 크면 음수, 같으면 0 작으면 양수 리턴
         */
        return this.age - o.getAge();
    }
}
