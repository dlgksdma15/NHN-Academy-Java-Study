package ch09.ex6;

import java.util.*;

public class VariableExpressionParser {

    // 수식 트리 노드들
    abstract static class ExpNode {
        abstract double value(double xValue);
        public abstract String toString();

        public DerivativeCalculator.ExpNode derivative() {
            return null;
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

        public String toString() {
            return String.valueOf(number);
        }
    }

    static class VariableNode extends ExpNode {
        double value(double xValue) {
            return xValue;
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
                default: throw new IllegalStateException("Unknown operator: " + op);
            }
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

        public String toString() {
            return "-" + operand;
        }
    }

    // 파서
    String input;
    int pos;

    private void skipSpaces() {
        while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) {
            pos++;
        }
    }

    private char peek() {
        skipSpaces();
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }

    private char next() {
        skipSpaces();
        if (pos < input.length()) {
            return input.charAt(pos++);
        }
        return '\0';
    }

    /**
     * 수식 파싱
     */
    public ExpNode parseExpression() throws ParseError {
        ExpNode left = parseTerm();

        while (peek() == '+' || peek() == '-') {
            char op = next();
            ExpNode right = parseTerm();
            left = new BinOpNode(op, left, right);
        }

        return left;
    }

    /**
     * 항 파싱
     */
    private ExpNode parseTerm() throws ParseError {
        ExpNode left = parseFactor();

        while (peek() == '*' || peek() == '/') {
            char op = next();
            ExpNode right = parseFactor();
            left = new BinOpNode(op, left, right);
        }

        return left;
    }

    /**
     * 인수 파싱 (변수 지원)
     */
    private ExpNode parseFactor() throws ParseError {
        skipSpaces();

        // 단항 마이너스
        if (peek() == '-') {
            next();
            return new UnaryMinusNode(parseFactor());
        }

        // 괄호
        if (peek() == '(') {
            next();
            ExpNode expr = parseExpression();
            if (next() != ')') {
                throw new ParseError("닫는 괄호가 필요합니다");
            }
            return expr;
        }

        // 변수 x
        if (peek() == 'x' || peek() == 'X') {
            next();
            return new VariableNode();
        }

        // 숫자
        if (Character.isDigit(peek()) || peek() == '.') {
            return new ConstNode(parseNumber());
        }

        throw new ParseError("예상치 못한 문자: " + peek());
    }

    private double parseNumber() throws ParseError {
        StringBuilder sb = new StringBuilder();

        while (Character.isDigit(peek()) || peek() == '.') {
            sb.append(next());
        }

        try {
            return Double.parseDouble(sb.toString());
        } catch (NumberFormatException e) {
            throw new ParseError("잘못된 숫자 형식");
        }
    }

    static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }

    /**
     * 수식 파싱 및 평가
     */
    public void evaluateExpression(String expression) {
        // TODO 22: 입력 수식과 위치 초기화
        this.input = expression;
        this.pos = 0;

        try {
            // TODO 23: parseExpression()을 호출하여 수식 트리 생성
            ExpNode tree = parseExpression();

            // TODO 24: 전체 수식이 파싱되었는지 확인
            if (pos < input.length()) {
                throw new ParseError("수식 끝에 예상치 못한 문자가 있습니다: " + input.substring(pos));
            }

            // TODO 25: 파싱 결과 출력
            System.out.println("원식: " + expression);
            System.out.println("파싱된 트리: " + tree);
            System.out.println("x=0일 때: " + tree.value(0));
            System.out.println("x=1일 때: " + tree.value(1));
            System.out.println("x=2일 때: " + tree.value(2));
            System.out.println("x=3일 때: " + tree.value(3));

            // TODO 26: 그래프용 데이터 생성
            System.out.println("그래프용 데이터 (x=-2.0 ~ 2.0, 0.5 간격):");
            for (double x = -2.0; x <= 2.0; x += 0.5) {
                System.out.printf("  f(%.1f) = %.2f%n", x, tree.value(x));
            }

        } catch (ParseError e) {
            System.err.println("파싱 오류: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        VariableExpressionParser parser = new VariableExpressionParser();

        String[] expressions = {
                "x + 1",
                "2 * x",
                "x * x",
                "3 * (x - 1) * (x + 1)",
                "x * x + 2 * x + 1",
                "-x + 5",
                "(x + 1) / (x - 1)"
        };

        for (String expr : expressions) {
            System.out.println("\n" + "=".repeat(50));
            parser.evaluateExpression(expr);
        }
    }
}