package org.example.inherit;

import org.example.basic.Dancer;

/*
 상속받은 클래스의 객체를 선언할때는 부모의 객체도 선언되어 해당 부모를 링크한다.
 아이돌 클래스에 super 필드 안에 해당 부모 객체를 링크시킴
 상속은 객체두개를 만들어 링킹하는 개념이다. 즉 자식객체를 생성하면 자동적으로 부모객체를 생성하여 링킹을 함
 자동으로 부모의 생성자를 콜하게 되는데 필드값을 초기화해주지 않는다면 에러가 나온다리, 부모에 기본생성자가 있다면 컴파일 에러는 치유
 부모를 먼저 생성함, 링크를 만드려면 타겟을 먼저 생성해야 하니께

 */

public class IdolDancer extends Dancer {
    private int numberOfFan; //팬의 수


//     생성자를 선언하지 않을시 기본생성자가 자동으로 생성됨
//    public IdolDancer() {
//        super();
//    }
    public IdolDancer(String crewName, String myName){
        super(crewName, myName);
        this.numberOfFan = 10;
//        System.out.println("자식 생성됨");
    }
    private void wink(){
        System.out.println("윙크를 세게 갈깁니다.");
    }

    // 부모메서드의 시그니처(이름, 리턴타입, 파라미터)를 맞춰야함
    @Override
    public void dance() {
        super.dance();
        wink();
    }



}
