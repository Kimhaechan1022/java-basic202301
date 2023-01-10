package org.example.basic;


import static org.example.basic.DanceLevel.*;

public class Dancer {

    private final String crewName;
    private final String myName;


    private DanceLevel level = LOW; // 춤수준(열거 타입), import static

    // 스트레칭 했는지
    private boolean stretch;
    private boolean flexible;

    public Dancer(String crewName, String myName) {
        this.crewName = crewName;
        this.myName = myName;
    }

    // function of dancer
    private void stretct() {
        System.out.println(myName + "님이 스트레칭 함");
        this.stretch = true;
    }

    private void makeFlexible() {
        if(!stretch){
            System.out.println("스트레칭 안해서 죽음");
            return;
        }
        System.out.println(myName + "님이 유연성 운동함");
        this.flexible = true;
    }

    public void dance() {
        // 캡슐화를 위한 private 강제와 클래스내 호출
        stretct();
        makeFlexible();

        if(!flexible){
            System.out.println("유연성 운동 안해서 죽음");
            return;
        }
        System.out.println(myName + "님이 춤을 춤");
    }

}
