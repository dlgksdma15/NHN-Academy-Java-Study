package ch09.ex5;

class NumberParser extends BasicParser {

    // <integer> ::= <digit> | <digit> <integer>
    public int parseInteger() throws ParseError {
        skipWhitespace();

        // 정수가 숫자로 시작하지 않으면 예외 발생
        if (!Character.isDigit(peek())) {
            throw new ParseError("정수는 숫자로 시작해야 합니다.");
        }

        int result = 0;
        while (Character.isDigit(peek())) {
            // 현재 문자를 숫자로 변환하여 결과에 누적
            result = result * 10 + (next() - '0');
        }

        return result;
    }

    // <signed-integer> ::= [ "+" | "-" ] <integer>
    public int parseSignedInteger() throws ParseError {
        skipWhitespace();

        boolean isNegative = false;

        // 부호 처리
        if (peek() == '+') {
            next();
        } else if (peek() == '-') {
            isNegative = true;
            next();
        }

        // 정수 부분 파싱
        int integerPart = parseInteger();

        // 부호에 따라 최종 값 반환
        return isNegative ? -integerPart : integerPart;
    }

    // <real-number> ::= <signed-integer> [ "." <integer> ]
    public double parseRealNumber() throws ParseError {
        // 정수 부분 파싱 (부호 포함)
        double result = parseSignedInteger();

        // 소수점이 있는지 확인
        if (peek() == '.') {
            next(); // 소수점('.') 소비

            // 소수점 뒤에 숫자가 오지 않으면 예외 발생
            if (!Character.isDigit(peek())) {
                throw new ParseError("소수점 뒤에는 숫자가 와야 합니다.");
            }

            double fraction = 0.0;
            double divisor = 10.0;
            while (Character.isDigit(peek())) {
                // 소수점 이하 값 누적
                fraction += (next() - '0') / divisor;
                divisor *= 10.0;
            }

            // 최종 결과에 소수 부분 더하기
            result += (result >= 0) ? fraction : -fraction;
        }

        return result;
    }

    public static void main(String[] args) {
        NumberParser parser = new NumberParser();

        try {
            parser.input = "123";
            parser.position = 0;
            System.out.println("정수: " + parser.parseInteger()); // 출력: 123

            parser.input = "-456";
            parser.position = 0;
            System.out.println("부호 있는 정수: " + parser.parseSignedInteger()); // 출력: -456

            parser.input = "3.14159";
            parser.position = 0;
            System.out.println("실수: " + parser.parseRealNumber()); // 출력: 3.14159

            parser.input = "  -789.01  ";
            parser.position = 0;
            System.out.println("공백 포함 실수: " + parser.parseRealNumber()); // 출력: -789.01

        } catch (ParseError e) {
            System.err.println("파싱 오류: " + e.getMessage());
        }
    }
}