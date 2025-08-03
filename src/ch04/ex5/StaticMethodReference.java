package ch04.ex5;

interface MathFunction {
    double apply(double x);
}

interface StringFunction {
    int apply(String s);
}

public class StaticMethodReference {
    public static void main(String[] args) {
        System.out.println("=== 정적 메서드 참조 ===\n");

        // TODO 44: Math 클래스의 메서드 참조 사용하기
        MathFunction sqrt = Math::sqrt; ;
        MathFunction abs = Math::abs;
        System.out.println("sqrt(16) = " + sqrt.apply(16));
        System.out.println("abs(-10) = " + abs.apply(-10));

        // TODO 45: Integer 클래스의 메서드 참조 사용하기
        StringFunction parseInt = Integer::parseInt;
        System.out.println("parseInt(\"123\") = " + parseInt.apply("123"));

        // TODO 46: 사용자 정의 정적 메서드 참조 사용하기
        MathFunction doubleIt = StaticMethodReference::doubleValue;
        MathFunction tripleIt = StaticMethodReference::tripleValue;
        System.out.println("double(5) = " + doubleIt.apply(5));
        System.out.println("triple(5) = " + tripleIt.apply(5));
    }

    // TODO 47: doubleValue 메서드 구현하기
    static double doubleValue(double x) {
        return x * 2;
    }

    // TODO 48: tripleValue 메서드 구현하기
    static double tripleValue(double x) {
        return x * 3;
    }
}
