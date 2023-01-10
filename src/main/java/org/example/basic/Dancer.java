package org.example.basic;


import static org.example.basic.DanceLevel.*;

// 상속을 하지 않는 사용자 지정 클래스는 자동으로 extends object 됨
public abstract class Dancer {

    // 기본생성자 생성시 final로 지정한 필드값을 초기화 하지 못하기 떄문에 에러가 생길수 있음
    // 기본생성자로 객체 선언시 default 한 상수값을 처리해주면 에러 해결 가능
    private final String crewName;
    private final String myName;


    private DanceLevel level = LOW; // 춤수준(열거 타입), import static

    // 스트레칭 했는지
    private boolean stretch;
    private boolean flexible;

    public Dancer(){
        this("기본크루","이름없음");

//        this.crewName = "기본크루";
//        this.myName = "기본이름";
    }
    public Dancer(String crewName, String myName) {
        this.crewName = crewName;
        this.myName = myName;
//        System.out.println("부모 생성됨");
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

    public abstract void dance();

    public String getCrewName() {
        return crewName;
    }

    public String getMyName() {
        return myName;
    }
}
