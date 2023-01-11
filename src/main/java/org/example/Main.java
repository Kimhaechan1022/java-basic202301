package org.example;

import org.example.basic.Dancer;
import org.example.beans.Goods;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

import java.util.HashSet;
import java.util.Set;


// ctrl alt v, 변수선언해줌
public class Main {
    public static void main(String[] args) {
        Goods goods1 = new Goods("세탁기", 30000);
        Goods goods2 = new Goods("세탁기", 30000);
        

        System.out.println("goods1 = " + goods1);
        System.out.println("goods2 = " + goods2);
        System.out.println(goods1.equals(goods2));

        Set<Goods> set1 = new HashSet<>();
        set1.add(goods1);
        set1.add(goods2);
        System.out.println(set1);

    }
}