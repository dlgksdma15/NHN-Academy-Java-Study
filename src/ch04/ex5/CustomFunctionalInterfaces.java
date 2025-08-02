package ch04.ex5;

// TODO 14: 두 개의 매개변수를 받는 함수형 인터페이스 만들기
interface BinaryOperator<T> {
    T apply(T t1, T t2);
}

// TODO 15: 세 개의 매개변수를 받는 함수형 인터페이스 만들기
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

// TODO 16: 조건 선택 함수형 인터페이스 만들기
interface ConditionalSelector<T> {
    T select(boolean condition, T ifTrue, T ifFalse);
}

public class CustomFunctionalInterfaces {
    public static void main(String[] args) {
        System.out.println("=== 커스텀 함수형 인터페이스 ===\n");

        // TODO 17: BinaryOperator 사용하기
        BinaryOperator<Integer> max = (a,b) -> Math.max(a,b);
        BinaryOperator<String> concat = (a,b) -> a+b;
        System.out.println("max(10, 20) = " + max.apply(10, 20));
        System.out.println("concat(\"Hello\", \"World\") = " + concat.apply("Hello", "World"));

        // TODO 18: TriFunction 사용하기
        TriFunction<Integer, Integer, Integer, Integer> sum3 = (a,b,c) -> a + b + c;
        TriFunction<String, String, String, String> join = (a,b,c) -> a + '-' + b + '-' + c;
        System.out.println("sum3(1, 2, 3) = " + sum3.apply(1, 2, 3));
        System.out.println("join = " + join.apply("2024", "03", "15"));

        // TODO 19: ConditionalSelector 사용하기
        ConditionalSelector<String> selector = (cond, t, f) -> cond ? t : f;
        System.out.println("선택 결과: " + selector.select(10 > 5, "크다", "작다"));
    }
}