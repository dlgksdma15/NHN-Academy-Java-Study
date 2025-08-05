package ch05.ex8;

public class FunctionFactory {

    // 함수 인터페이스
    public interface MathFunction {
        double apply(double x);
        String getDescription();
    }

    // 다항식 생성
    public static MathFunction createPolynomial(final double... coefficients) {
        // 로컬 클래스 Polynomial
        class Polynomial implements MathFunction {
            @Override
            public double apply(double x) {
                double result = 0;
                for (int i = 0; i < coefficients.length; i++) {
                    result += coefficients[i] * Math.pow(x, i);
                }
                return result;
            }

            @Override
            public String getDescription() {
                StringBuilder sb = new StringBuilder("f(x) = ");
                for (int i = 0; i < coefficients.length; i++) {
                    if (i > 0) sb.append(" + ");
                    sb.append(coefficients[i]);
                    if (i > 0) sb.append("x");
                    if (i > 1) sb.append("^").append(i);
                }
                return sb.toString();
            }
        }
        return new Polynomial();
    }

    // 삼각함수 조합 생성
    public static MathFunction createTrigFunction(
            final double amplitude, final double frequency, final double phase) {
        // 익명 클래스 사용
        return new MathFunction() {
            @Override
            public double apply(double x) {
                return amplitude * Math.sin(frequency * x + phase);
            }

            @Override
            public String getDescription() {
                return String.format("f(x) = %.2f * sin(%.2fx + %.2f)",
                        amplitude, frequency, phase);
            }
        };
    }

    // 함수 배열 생성
    public static MathFunction[] createFunctionArray() {
        MathFunction[] functions = new MathFunction[5];

        // 로컬 클래스 SquareFunction
        class SquareFunction implements MathFunction {
            @Override
            public double apply(double x) {
                return x * x;
            }

            @Override
            public String getDescription() {
                return "f(x) = x²";
            }
        }

        // 익명 클래스 세제곱 함수
        MathFunction cubeFunction = new MathFunction() {
            @Override
            public double apply(double x) {
                return x * x * x;
            }

            @Override
            public String getDescription() {
                return "f(x) = x³";
            }
        };

        functions[0] = new SquareFunction();
        functions[1] = cubeFunction;
        functions[2] = createPolynomial(0, 1);       // f(x) = x
        functions[3] = createPolynomial(1, 2, 1);    // f(x) = 1 + 2x + x²
        functions[4] = createTrigFunction(2, 1, 0);  // f(x) = 2sin(x)

        return functions;
    }

    public static void main(String[] args) {
        // 다항식 함수 테스트
        MathFunction poly = createPolynomial(1, -2, 1); // 1 - 2x + x²
        System.out.println(poly.getDescription() + " f(3) = " + poly.apply(3));

        // 삼각함수 테스트
        MathFunction trig = createTrigFunction(1, 2 * Math.PI, 0);
        System.out.println(trig.getDescription() + " f(0.25) = " + trig.apply(0.25));

        // 함수 배열 테스트
        System.out.println("\n=== 함수 배열 ===");
        MathFunction[] arr = createFunctionArray();
        double x = 2.0;
        for (MathFunction f : arr) {
            System.out.printf("%s: f(%.1f) = %.2f%n", f.getDescription(), x, f.apply(x));
        }
    }
}
