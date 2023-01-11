package org.example.java8.anonymous;

public class Main {

    public static class SubCalculator implements Calculator{
        @Override
        public int operate(int n1, int n2) {
            return n1-n2;
        }
    }

    public static void main(String[] args) {

        // 덧셈기능을 구현한 계산기 객체를 생성
        Calculator addCalculator = new AddCalculator();
        System.out.println(addCalculator.operate(1,2));

        // 뺄셈 기능은 내부클래스로
        Calculator subCalculator = new SubCalculator();
        System.out.println(subCalculator.operate(2,1));

        // 곱셈은 익명 클래스로
        Calculator mulCalc = new Calculator(){
            @Override
            public int operate(int n1, int n2) {
                return n1 *n2;
            }
        };

        // 나눗셈, lambda, [ (매개번수) -> 리턴값 꼴 ]
        Calculator divCalc = (n1,n2) -> n1/n2;
        System.out.println(divCalc.operate(100,50));

        PowerOperator op = (n1,n2,cal) -> cal.operate(n1,n2);

        int rst = op.power(50,60,(n1,n2)-> n1+ n2);
        System.out.println(rst);



    }
}
