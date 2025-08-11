package ch09.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.EmptyStackException;

public class BracketMatcher {

    private static final Map<Character, Character> BRACKET_PAIRS = new HashMap<>();

    static {
        BRACKET_PAIRS.put(')', '(');
        BRACKET_PAIRS.put('}', '{');
        BRACKET_PAIRS.put(']', '[');
    }

    /**
     * 주어진 표현식의 괄호가 올바르게 매칭되는지 검사
     */
    public static boolean isBalanced(String expression) {
        GenericLinkedStack<Character> stack = new GenericLinkedStack<>();

        // TODO 1: expression의 각 문자를 순회
        for (char ch : expression.toCharArray()) {
            // TODO 2: 여는 괄호이면 스택에 push
            if (isOpenBracket(ch)) {
                stack.push(ch);
            }
            // TODO 3: 닫는 괄호이면:
            else if (isCloseBracket(ch)) {
                try {
                    //   - 스택이 비었으면 false 반환
                    char openBracket = stack.pop();
                    //   - 매칭이 맞는지 확인
                    if (!isMatchingPair(openBracket, ch)) {
                        return false;
                    }
                } catch (EmptyStackException e) {
                    return false; // 닫는 괄호가 너무 많음
                }
            }
        }

        // TODO 4: 모든 문자 처리 후 스택이 비어있는지 확인
        return stack.isEmpty();
    }

    /**
     * 자세한 검사 결과를 반환하는 메서드
     */
    public static ValidationResult validateBrackets(String expression) {
        GenericLinkedStack<BracketInfo> stack = new GenericLinkedStack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (isOpenBracket(ch)) {
                stack.push(new BracketInfo(ch, i));
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty()) {
                    return new ValidationResult(false,
                            "위치 " + i + "에서 닫는 괄호 '" + ch + "'에 대응하는 여는 괄호가 없습니다.");
                }

                BracketInfo openInfo = stack.pop();
                if (!isMatchingPair(openInfo.bracket, ch)) {
                    return new ValidationResult(false,
                            "위치 " + openInfo.position + "의 '" + openInfo.bracket + "'와 " +
                                    "위치 " + i + "의 '" + ch + "'가 매칭되지 않습니다.");
                }
            }
        }

        if (!stack.isEmpty()) {
            BracketInfo unclosed = stack.peek();
            return new ValidationResult(false,
                    "위치 " + unclosed.position + "의 '" + unclosed.bracket + "'가 닫히지 않았습니다.");
        }

        return new ValidationResult(true, "모든 괄호가 올바르게 매칭됩니다.");
    }

    private static boolean isOpenBracket(char ch) {
        // TODO: ch가 여는 괄호 '(', '{', '[' 중 하나인지 확인
        return ch == '(' || ch == '{' || ch == '[';
    }

    private static boolean isCloseBracket(char ch) {
        // TODO: ch가 닫는 괄호 ')', '}', ']' 중 하나인지 확인
        return ch == ')' || ch == '}' || ch == ']';
    }

    private static boolean isMatchingPair(char open, char close) {
        // TODO: BRACKET_PAIRS 맵을 사용하여 open과 close가 매칭되는 쌍인지 확인
        // 힌트: BRACKET_PAIRS.get(close)가 open과 같은지 확인
        return BRACKET_PAIRS.containsKey(close) && BRACKET_PAIRS.get(close) == open;
    }

    // 괄호 정보를 저장하는 내부 클래스
    private static class BracketInfo {
        char bracket;
        int position;

        BracketInfo(char bracket, int position) {
            this.bracket = bracket;
            this.position = position;
        }
    }

    // 검증 결과를 저장하는 클래스
    static class ValidationResult {
        boolean isValid;
        String message;

        ValidationResult(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 괄호 매칭 검사 ===");

        String[] testCases = {
                "((()))",
                "(()())",
                "({[]})",
                "((())",
                "())",
                "({[}])",
                "public void method() { if (x > 0) { System.out.println(\"Hello\"); } }"
        };

        for (String test : testCases) {
            System.out.println("\n테스트: " + test);
            System.out.println("간단한 검사: " + (isBalanced(test) ? "유효" : "무효"));

            ValidationResult result = validateBrackets(test);
            System.out.println("상세 검사: " + result.message);
        }
    }
}