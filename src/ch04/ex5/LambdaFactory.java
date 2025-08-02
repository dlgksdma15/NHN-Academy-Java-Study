package ch04.ex5;

interface Operation {
    int apply(int x);
}

interface BiOperation {
    int apply(int x, int y);
}

public class LambdaFactory {
    public static void main(String[] args) {
        System.out.println("=== 람다를 반환하는 함수 ===\n");

        // TODO 32: 단항 연산 생성 테스트하기
        Operation addFive = makeAdder(5);
        Operation multiplyByTen = makeMultiplier(10);
        System.out.println("7 + 5 = " + addFive.apply(7));
        System.out.println("7 × 10 = " + multiplyByTen.apply(7));

        // TODO 33: 범위 검사기 테스트하기
        Operation inRange = makeRangeChecker(0, 100);
        System.out.println("50은 0-100 범위? " + (inRange.apply(50) == 1));
        System.out.println("150은 0-100 범위? " + (inRange.apply(150) == 1));

        // TODO 34: 이항 연산 선택 테스트하기
        BiOperation op = getOperation("+");
        System.out.println("10 + 5 = " + op.apply(10, 5));
    }

    // TODO 35: makeAdder 메서드 구현하기
    static Operation makeAdder(int n) {
        return x -> x + n;
    }

    // TODO 36: makeMultiplier 메서드 구현하기
    static Operation makeMultiplier(int n) {
        return x -> x * n;
    }

    // TODO 37: makeRangeChecker 메서드 구현하기
    static Operation makeRangeChecker(int min, int max) {
        return x -> x > min && x < max ? 1 : 0;
    }

    // TODO 38: getOperation 메서드 구현하기
    static BiOperation getOperation(String op) {
        switch (op){
            case "+":
                return (a,b) -> a + b;
            case "-":
                return (a,b) -> a + b;
            case "*":
                return (a,b) -> a * b;
            case "/":
                return (a,b) -> a / b;
            default:
                throw new IllegalArgumentException("연산자를 제대로 입력하십시오.");
        }
    }
}
