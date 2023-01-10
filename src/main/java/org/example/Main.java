package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

// ctrl alt v, 변수선언해줌
public class Main {
    public static void main(String[] args) {

        IdolDancer idolDancer1 = new IdolDancer("아이돌팀1", "아이돌1");
        IdolDancer idolDancer2 = new IdolDancer("아이돌팀2", "아이돌2");
        IdolDancer idolDancer3 = new IdolDancer("아이돌팀3", "아이돌3");

        StreetDancer streetDancer1 = new StreetDancer("스트릿팀1", "스트릿댄서1");
        StreetDancer streetDancer2 = new StreetDancer("스트릿팀2", "스트릿댄서2");
        StreetDancer streetDancer3 = new StreetDancer("스트릿팀3", "스트릿댄서3");

        PerformanceTeam team = new PerformanceTeam();

        team.joinDancer(idolDancer1);
        team.joinDancer(idolDancer2);
        team.joinDancer(idolDancer3);
        team.joinDancer(streetDancer1);
        team.joinDancer(streetDancer2);
        team.joinDancer(streetDancer3);
    }
}