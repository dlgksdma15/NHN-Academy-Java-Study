package ch04.ex5;

// 함수형 인터페이스 정의 (이미 구현됨)
interface Calculator {
    int calculate(int a, int b);
}

interface Greeting {
    void sayHello(String name);
}

interface NumberTest {
    boolean test(int n);
}

public class BasicLambdaExample {
    public static void main(String[] args) {
        System.out.println("=== 기본 람다 표현식 ===\n");

        // TODO 1: 덧셈 람다 구현하기
        Calculator add = (a, b) -> a + b;
        System.out.println("10 + 5 = " + add.calculate(10, 5));

        // TODO 2: 곱셈 람다 구현하기
        Calculator multiply = (a,b) -> a * b;
        System.out.println("10 × 5 = " + multiply.calculate(10, 5));

        // TODO 3: 최대값 람다 구현하기
        Calculator max = (a,b) ->  Math.max(a,b);
        System.out.println("max(10, 5) = " + max.calculate(10, 5));

        // TODO 4: 인사 람다 구현하기
        Greeting greeting = (name) -> System.out.println("안녕하세요, " + name + "님!");
        greeting.sayHello("김철수");

        // TODO 5: 짝수 판별 람다 구현하기
        NumberTest isEven = (num) -> num  % 2 == 0;

        System.out.println("8은 짝수인가? " + isEven.test(8));
        System.out.println("7은 짝수인가? " + isEven.test(7));
    }
}