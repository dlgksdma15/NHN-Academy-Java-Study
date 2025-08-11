package ch09.ex5;

public class ExpressionTreeParser extends BasicParser {

    // <expression> ::= <term> [ ("+" | "-") <term> ]...
    public ExprNode parseExpression() throws ParseError {
        // TODO 1: parseTerm()으로 첫 번째 항을 트리로 파싱
        ExprNode left = parseTerm();

        // TODO 2: '+' 또는 '-' 연산자가 있는 동안 반복:
        while (peek() == '+' || peek() == '-') {
            //  - 연산자 저장
            char op = next();
            //  - parseTerm()으로 다음 항 파싱
            ExprNode right = parseTerm();
            //  - BinaryOpNode로 새 트리 노드 생성
            //  - left를 새 노드로 업데이트
            left = new BinaryOpNode(op, left, right);
        }

        return left;
    }

    // <term> ::= <factor> [ ("*" | "/") <factor> ]...
    public ExprNode parseTerm() throws ParseError {
        // TODO 1: parseFactor()로 첫 번째 인수를 트리로 파싱
        ExprNode left = parseFactor();

        // TODO 2: '*' 또는 '/' 연산자가 있는 동안 반복:
        while (peek() == '*' || peek() == '/') {
            //  - 연산자 저장
            char op = next();
            //  - parseFactor()로 다음 인수 파싱
            ExprNode right = parseFactor();
            //  - BinaryOpNode로 새 트리 노드 생성
            //  - left를 새 노드로 업데이트
            left = new BinaryOpNode(op, left, right);
        }

        return left;
    }

    // <factor> ::= <number> | "(" <expression> ")" | "-" <factor>
    public ExprNode parseFactor() throws ParseError {
        skipWhitespace();

        // TODO 1: 음수 처리 - '-'로 시작하면 UnaryMinusNode 생성
        if (peek() == '-') {
            next();
            ExprNode operand = parseFactor();
            return new UnaryMinusNode(operand);
        }

        // TODO 2: 괄호 처리 - '('로 시작하면:
        if (peek() == '(') {
            //  - '(' 소비
            next();
            //  - parseExpression() 호출
            ExprNode expr = parseExpression();
            //  - ')' 기대
            expect(')');
            return expr;
        }

        // TODO 3: 숫자 처리 - 숫자나 '.' 로 시작하면 NumberNode 생성
        if (Character.isDigit(peek()) || peek() == '.') {
            return new NumberNode(parseNumber());
        }

        // TODO 4: 그 외의 경우 ParseError 던지기
        throw new ParseError("예상치 못한 문자: " + peek());
    }

    private double parseNumber() throws ParseError {
        StringBuilder sb = new StringBuilder();

        while (Character.isDigit(peek())) {
            sb.append(next());
        }

        if (peek() == '.') {
            sb.append(next());
            while (Character.isDigit(peek())) {
                sb.append(next());
            }
        }

        return Double.parseDouble(sb.toString());
    }

    // 트리 시각화
    public static void printTree(ExprNode node, String prefix, boolean isLast) {
        if (node == null) return;

        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                nodeToString(node));

        if (node instanceof BinaryOpNode) {
            BinaryOpNode binNode = (BinaryOpNode) node;
            String childPrefix = prefix + (isLast ? "    " : "│   ");

            printTree(getLeft(binNode), childPrefix, false);
            printTree(getRight(binNode), childPrefix, true);
        } else if (node instanceof UnaryMinusNode) {
            UnaryMinusNode unaryNode = (UnaryMinusNode) node;
            String childPrefix = prefix + (isLast ? "    " : "│   ");

            printTree(getOperand(unaryNode), childPrefix, true);
        }
    }

    // 리플렉션을 사용한 private 필드 접근 (데모용)
    private static ExprNode getLeft(BinaryOpNode node) {
        try {
            var field = BinaryOpNode.class.getDeclaredField("left");
            field.setAccessible(true);
            return (ExprNode) field.get(node);
        } catch (Exception e) {
            return null;
        }
    }

    private static ExprNode getRight(BinaryOpNode node) {
        try {
            var field = BinaryOpNode.class.getDeclaredField("right");
            field.setAccessible(true);
            return (ExprNode) field.get(node);
        } catch (Exception e) {
            return null;
        }
    }

    private static ExprNode getOperand(UnaryMinusNode node) {
        try {
            var field = UnaryMinusNode.class.getDeclaredField("operand");
            field.setAccessible(true);
            return (ExprNode) field.get(node);
        } catch (Exception e) {
            return null;
        }
    }

    private static String nodeToString(ExprNode node) {
        if (node instanceof NumberNode) {
            return "Num: " + node.toInfix();
        } else if (node instanceof BinaryOpNode) {
            try {
                var field = BinaryOpNode.class.getDeclaredField("operator");
                field.setAccessible(true);
                char op = (char) field.get(node);
                return "Op: " + op;
            } catch (Exception e) {
                return "Op: ?";
            }
        } else if (node instanceof UnaryMinusNode) {
            return "Unary: -";
        }
        return "?";
    }

    // 테스트
    public static void main(String[] args) {
        ExpressionTreeParser parser = new ExpressionTreeParser();

        String[] expressions = {
                "2 + 3 * 4",
                "(2 + 3) * 4",
                "-5 + 3",
                "1 + 2 * 3 - 4 / 2"
        };

        for (String expr : expressions) {
            try {
                parser.input = expr;
                parser.position = 0;

                ExprNode tree = parser.parseExpression();

                System.out.println("\n수식: " + expr);
                System.out.println("계산 결과: " + tree.evaluate());
                System.out.println("중위 표기: " + tree.toInfix());
                System.out.println("전위 표기: " + tree.toPrefix());
                System.out.println("후위 표기: " + tree.toPostfix());
                System.out.println("트리 구조:");
                printTree(tree, "", true);

            } catch (ParseError e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
    }
}