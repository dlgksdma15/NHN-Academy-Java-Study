package ch09.ex5;
// 수식 트리의 기본 노드
abstract class ExprNode {
    abstract double evaluate();
    abstract String toInfix();
    abstract String toPrefix();
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
    public String toPrefix() {
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
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();

        switch (operator) {
            case '+': return leftVal + rightVal;
            case '-': return leftVal - rightVal;
            case '*': return leftVal * rightVal;
            case '/':
                if (rightVal == 0) {
                    throw new ArithmeticException("0으로 나눔");
                }
                return leftVal / rightVal;
            default:
                throw new IllegalStateException("Unknown operator: " + operator);
        }
    }

    @Override
    public String toInfix() {
        return "(" + left.toInfix() + " " + operator + " " + right.toInfix() + ")";
    }

    @Override
    public String toPrefix() {
        return operator + " " + left.toPrefix() + " " + right.toPrefix();
    }

    @Override
    public String toPostfix() {
        return left.toPostfix() + " " + right.toPostfix() + " " + operator;
    }
}

// 단항 마이너스 노드
class UnaryMinusNode extends ExprNode {
    private ExprNode operand;

    public UnaryMinusNode(ExprNode operand) {
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        return -operand.evaluate();
    }

    @Override
    public String toInfix() {
        return "-" + operand.toInfix();
    }

    @Override
    public String toPrefix() {
        return "- " + operand.toPrefix();
    }

    @Override
    public String toPostfix() {
        return operand.toPostfix() + " -";
    }
}