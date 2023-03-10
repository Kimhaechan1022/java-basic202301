package org.example.java8.stream.practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static final String CAMBRIDGE = "Cambridge";

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Trader> traders = new ArrayList<>();
        traders.add(raoul);
        traders.add(mario);
        traders.add(alan);
        traders.add(brian);

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>
        transactions.stream()
                .filter(t -> t.getYear() == 2021)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(out::println);

        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        // List<String>
        traders.stream()
                .map(t -> t.getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(out::println);

        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 이름순으로 오름차정렬.
        // List<Trader>
        traders.stream()
                .filter(t -> Objects.equals(t.getCity(), CAMBRIDGE))
                .sorted(Comparator.comparing(e -> e.getName().toLowerCase()))
                .collect(Collectors.toList())
                .forEach(out::println);

        // 모든 거래자의 이름을 리스트에 모아서 알파벳 순으로 오름차순 정렬
        // List<String>
        traders.stream()
                .map(Trader::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(out::println);

        out.println("===================================================");

        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        boolean isPre = traders.stream()
                .anyMatch(t -> t.getCity() == "Milan");
        out.println("isPre = " + isPre);

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.

        int sum = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(t -> t.getValue())
                .sum();
        out.println("sum = " + sum);

        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
        int max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        out.println("max = " + max);

        // 가장작은 거래액을 가진 거래 정보를 탐색
        Optional<Transaction> smallestTran = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        smallestTran.ifPresent(out::println);


    }
}
