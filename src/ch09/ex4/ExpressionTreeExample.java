package ch09.ex4;
// 추상 클래스
abstract class ExprNode {
    abstract double evaluate();
    abstract String toInfix();
    abstract String toPostfix();
}

// 숫자 노드
class NumberNode extends ExprNode {
    private double value;

    public NumberNode(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toInfix() {
        return String.valueOf(value);
    }

    @Override
    public String toPostfix() {
        return String.valueOf(value);
    }
}

// 이항 연산자 노드
class BinaryOpNode extends ExprNode {
    private char operator;
    private ExprNode left;
    private ExprNode right;

    public BinaryOpNode(char op, ExprNode left, ExprNode right) {
        this.operator = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        // TODO 1: 왼쪽 및 오른쪽 자식의 값 계산
        double leftValue = left.evaluate();
        double rightValue = right.evaluate();

        // TODO 2: 연산자에 따라 적절한 연산 수행
        // +, -, *, /, ^ 연산자 처리
        // 나눗셈의 경우 0으로 나누는지 확인
        switch (operator) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                if (rightValue == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return leftValue / rightValue;
            case '^':
                return Math.pow(leftValue, rightValue);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    @Override
    public String toInfix() {
        return "(" + left.toInfix() + " " + operator + " " + right.toInfix() + ")";
    }

    @Override
    public String toPostfix() {
        return left.toPostfix() + " " + right.toPostfix() + " " + operator;
    }
}

// 단항 연산자 노드
class UnaryOpNode extends ExprNode {
    private String operator;
    private ExprNode operand;

    public UnaryOpNode(String op, ExprNode operand) {
        this.operator = op;
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        double val = operand.evaluate();

        switch (operator) {
            case "-": return -val;
            case "sqrt": return Math.sqrt(val);
            case "abs": return Math.abs(val);
            case "sin": return Math.sin(val);
            case "cos": return Math.cos(val);
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    @Override
    public String toInfix() {
        return operator + "(" + operand.toInfix() + ")";
    }

    @Override
    public String toPostfix() {
        return operand.toPostfix() + " " + operator;
    }
}
public class ExpressionTreeExample {
    public static void main(String[] args) {
        // 수식: (3 + 4) * 5
        ExprNode expr1 = new BinaryOpNode('*',
                new BinaryOpNode('+',
                        new NumberNode(3),
                        new NumberNode(4)
                ),
                new NumberNode(5)
        );

        System.out.println("수식 1:");
        System.out.println("중위 표기법: " + expr1.toInfix());
        System.out.println("후위 표기법: " + expr1.toPostfix());
        System.out.println("계산 결과: " + expr1.evaluate());

        // 수식: sqrt(16) + 3^2
        ExprNode expr2 = new BinaryOpNode('+',
                new UnaryOpNode("sqrt", new NumberNode(16)),
                new BinaryOpNode('^', new NumberNode(3), new NumberNode(2))
        );

        System.out.println("\n수식 2:");
        System.out.println("중위 표기법: " + expr2.toInfix());
        System.out.println("계산 결과: " + expr2.evaluate());

        // 복잡한 수식: ((10 - 5) * 2) / (3 + 1)
        ExprNode expr3 = new BinaryOpNode('/',
                new BinaryOpNode('*',
                        new BinaryOpNode('-',
                                new NumberNode(10),
                                new NumberNode(5)
                        ),
                        new NumberNode(2)
                ),
                new BinaryOpNode('+',
                        new NumberNode(3),
                        new NumberNode(1)
                )
        );

        System.out.println("\n수식 3:");
        System.out.println("중위 표기법: " + expr3.toInfix());
        System.out.println("후위 표기법: " + expr3.toPostfix());
        System.out.println("계산 결과: " + expr3.evaluate());
    }
}