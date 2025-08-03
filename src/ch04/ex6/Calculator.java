package ch04.ex6;

// TODO 31: 클래스에 대한 Javadoc 주석 작성하기
/**
 * 간단한 사칙연산 계산기 클래스
 * <p>덧셈, 뺄셈, 나눗셈을 지원합니다.</p>
 *
 * @author 홍길동
 * @version 1.0
 * @since 2024-01-01
 */
public class Calculator {

    // TODO 32: add 메서드에 Javadoc 주석 작성하기
    /**
     * 두 수를 더합니다.
     *
     * @param a 첫 번째 수
     * @param b 두 번째 수
     * @return 두 수의 합
     */
    public static double add(double a, double b) {
        return a + b;
    }

    // TODO 33: subtract 메서드에 Javadoc 주석 작성하기
    /**
     * 두 수를 뺍니다.
     *
     * @param a 첫 번째 수
     * @param b 두 번째 수
     * @return a에서 b를 뺀 결과
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    // TODO 34: divide 메서드에 Javadoc 주석 작성하기 (예외 포함)
    /**
     * 두 수를 나눕니다.
     *
     * @param dividend 피제수
     * @param divisor 제수
     * @return 나눗셈 결과
     * @throws ArithmeticException 0으로 나눌 때 발생
     */
    public static double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return dividend / divisor;
    }
}
