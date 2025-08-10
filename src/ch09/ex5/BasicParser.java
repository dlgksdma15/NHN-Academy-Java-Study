package ch09.ex5;
public class BasicParser {
    public String input;
    public int position;

    // 파싱 예외
    static class ParseError extends Exception {
        public ParseError(String message) {
            super(message);
        }
    }

    // 기본 유틸리티 메서드
    public char peek() {
        if (position < input.length()) {
            return input.charAt(position);
        }
        return '\0';  // 입력 끝
    }

    public char next() {
        char ch = peek();
        position++;
        return ch;
    }

    public void skipWhitespace() {
        while (position < input.length() &&
                Character.isWhitespace(input.charAt(position))) {
            position++;
        }
    }

    public boolean isAtEnd() {
        skipWhitespace();
        return position >= input.length();
    }

    // 특정 문자 기대
    public void expect(char expected) throws ParseError {
        skipWhitespace();
        if (peek() != expected) {
            throw new ParseError("'" + expected + "'가 필요하지만 '" +
                    peek() + "'를 발견했습니다.");
        }
        next();
    }

    // 문자열 매칭
    public boolean match(String str) {
        skipWhitespace();
        int savedPos = position;

        for (char ch : str.toCharArray()) {
            if (next() != ch) {
                position = savedPos;
                return false;
            }
        }

        return true;
    }
}