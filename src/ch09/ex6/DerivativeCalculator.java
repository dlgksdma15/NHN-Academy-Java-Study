package ch09.ex6;

public class DerivativeCalculator {

    // 기존 ExpNode 클래스들에 derivative() 메서드 추가
    abstract static class ExpNode {
        abstract double value(double xValue);
        abstract ExpNode derivative();
        public abstract String toString();

        // 단순화 메서드
        ExpNode simplify() {
            return this;  // 기본적으로는 변경 없음
        }
    }

    static class ConstNode extends ExpNode {
        double number;

        ConstNode(double number) {
            this.number = number;
        }

        double value(double xValue) {
            return number;
        }

        ExpNode derivative() {
            // 상수의 도함수는 0
            return new ConstNode(0);
        }

        public String toString() {
            return String.valueOf(number);
        }
    }

    static class VariableNode extends ExpNode {
        double value(double xValue) {
            return xValue;
        }

        ExpNode derivative() {
            // x의 도함수는 1
            return new ConstNode(1);
        }

        public String toString() {
            return "x";
        }
    }

    static class BinOpNode extends ExpNode {
        char op;
        ExpNode left, right;

        BinOpNode(char op, ExpNode left, ExpNode right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }

        double value(double xValue) {
            double leftVal = left.value(xValue);
            double rightVal = right.value(xValue);

            switch (op) {
                case '+': return leftVal + rightVal;
                case '-': return leftVal - rightVal;
                case '*': return leftVal * rightVal;
                case '/': return leftVal / rightVal;
                default: throw new IllegalStateException();
            }
        }

        ExpNode derivative() {
            // TODO 27: 왼쪽과 오른쪽 자식의 도함수 계산
            ExpNode dLeft = left.derivative();
            ExpNode dRight = right.derivative();

            // TODO 28: 연산자에 따라 도함수 규칙 적용
            switch (op) {
                // - 덧셈: (A + B)' = A' + B'
                case '+': return new BinOpNode('+', dLeft, dRight);
                // - 뺄셈: (A - B)' = A' - B'
                case '-': return new BinOpNode('-', dLeft, dRight);
                // - 곱셈: (A * B)' = A' * B + A * B'
                case '*':
                    ExpNode term1 = new BinOpNode('*', dLeft, right);
                    ExpNode term2 = new BinOpNode('*', left, dRight);
                    return new BinOpNode('+', term1, term2);
                // - 나눗셈: (A / B)' = (A' * B - A * B') / (B * B)
                case '/':
                    ExpNode numerator = new BinOpNode('-', new BinOpNode('*', dLeft, right), new BinOpNode('*', left, dRight));
                    ExpNode denominator = new BinOpNode('*', right, right);
                    return new BinOpNode('/', numerator, denominator);
                default:
                    throw new IllegalStateException("Unknown operator: " + op);
            }
        }

        @Override
        ExpNode simplify() {
            ExpNode simpLeft = left.simplify();
            ExpNode simpRight = right.simplify();

            // 0과의 연산 단순화
            if (simpLeft instanceof ConstNode && ((ConstNode)simpLeft).number == 0) {
                switch (op) {
                    case '+': return simpRight;  // 0 + B = B
                    case '-': return new UnaryMinusNode(simpRight);  // 0 - B = -B
                    case '*': return new ConstNode(0);  // 0 * B = 0
                    case '/': return new ConstNode(0);  // 0 / B = 0
                }
            }

            if (simpRight instanceof ConstNode && ((ConstNode)simpRight).number == 0) {
                switch (op) {
                    case '+': return simpLeft;  // A + 0 = A
                    case '-': return simpLeft;  // A - 0 = A
                    case '*': return new ConstNode(0);  // A * 0 = 0
                }
            }

            // 1과의 곱셈 단순화
            if (op == '*') {
                if (simpLeft instanceof ConstNode && ((ConstNode)simpLeft).number == 1) {
                    return simpRight;  // 1 * B = B
                }
                if (simpRight instanceof ConstNode && ((ConstNode)simpRight).number == 1) {
                    return simpLeft;  // A * 1 = A
                }
            }

            return new BinOpNode(op, simpLeft, simpRight);
        }

        public String toString() {
            return "(" + left + " " + op + " " + right + ")";
        }
    }

    static class UnaryMinusNode extends ExpNode {
        ExpNode operand;

        UnaryMinusNode(ExpNode operand) {
            this.operand = operand;
        }

        double value(double xValue) {
            return -operand.value(xValue);
        }

        ExpNode derivative() {
            // (-A)' = -A'
            return new UnaryMinusNode(operand.derivative());
        }

        @Override
        ExpNode simplify() {
            ExpNode simpOperand = operand.simplify();

            // --A = A
            if (simpOperand instanceof UnaryMinusNode) {
                return ((UnaryMinusNode)simpOperand).operand;
            }

            return new UnaryMinusNode(simpOperand);
        }

        public String toString() {
            return "-" + operand;
        }
    }

    /**
     * 도함수 계산 및 테스트
     */
    public static void testDerivatives() {
        // 파서는 이전 예제의 것을 사용
        VariableExpressionParser parser = new VariableExpressionParser();

        String[] expressions = {
                "x",                    // x' = 1
                "5",                    // 5' = 0
                "x + 3",                // (x + 3)' = 1
                "2 * x",                // (2x)' = 2
                "x * x",                // (x²)' = 2x
                "x * x * x",            // (x³)' = 3x²
                "3 * x + 1",            // (3x + 1)' = 3
                "(x + 1) * (x - 1)",    // (x² - 1)' = 2x
                "1 / x"                 // (1/x)' = -1/x²
        };

        for (String expr : expressions) {
            parser.input = expr;
            parser.pos = 0;

            try {
                VariableExpressionParser.ExpNode tree = parser.parseExpression();
                ExpNode derivative = tree.derivative();
                ExpNode simplified = derivative.simplify();

                System.out.println("\n원식: " + expr);
                System.out.println("파싱: " + tree);
                System.out.println("도함수: " + derivative);
                System.out.println("단순화: " + simplified);

                // 특정 점에서의 값 확인
                System.out.println("x=2에서:");
                System.out.printf("  f(2) = %.2f%n", tree.value(2));
                System.out.printf("  f'(2) = %.2f%n", simplified.value(2));

            } catch (Exception e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        testDerivatives();
    }
}