package ch05.ex7;

/**
 * 읽기 가능한 소스를 나타내는 인터페이스
 */
interface Readable {
    // 추상 메서드 - 구현 필수
    char readChar();

    // 기본 메서드 - 한 줄 읽기
    default String readLine() {
        StringBuilder line = new StringBuilder();
        try {
            char ch = readChar();
            while (ch != '\n' && ch != '\0') {
                line.append(ch);
                ch = readChar();
            }
        } catch (Exception e) {
            // 읽기 종료
        }
        return line.toString();
    }

    // 기본 메서드 - 단어 읽기
    default String readWord() {
        StringBuilder word = new StringBuilder();
        try {
            char ch = readChar();

            // 공백 건너뛰기
            while (Character.isWhitespace(ch)) {
                ch = readChar();
            }

            // 단어 읽기
            while (!Character.isWhitespace(ch) && ch != '\0') {
                word.append(ch);
                ch = readChar();
            }
        } catch (Exception e) {
            // 읽기 종료
        }
        return word.toString();
    }

    // 기본 메서드 - 모든 내용 읽기
    default String readAll() {
        StringBuilder all = new StringBuilder();
        try {
            String line;
            while (!(line = readLine()).isEmpty()) {
                all.append(line).append('\n');
            }
        } catch (Exception e) {
            // 읽기 종료
        }
        return all.toString();
    }
}

// 구현 예제 1: 문자열에서 읽기
class StringReader implements Readable {
    private String content;
    private int position;

    public StringReader(String content) {
        // TODO 33: content와 position 초기화하기
        this.content = content;
        position = 0;
    }

    @Override
    public char readChar() {
        // TODO 34: 문자 하나 읽기
        // position >= content.length()이면 '\0' 반환
        // 아니면 content.charAt(position) 반환하고 position 증가
        if(position >= content.length()){
            return '\0';
        }else{
            return content.charAt(position++);
        }
    }
}

// 구현 예제 2: 별 패턴 생성기
class StarPattern implements Readable {
    private int currentLine = 0;
    private int currentPos = 0;
    private final int maxLines = 5;

    @Override
    public char readChar() {
        // TODO 35: 별 패턴 문자 생성하기
        if (currentLine >= maxLines) {
            return '\0';
        }
        if (currentPos <= currentLine) {
            currentPos++;
            return '*';
        } else {
            currentPos = 0;
            currentLine++;
            return '\n';
        }
    }
}

// 테스트 클래스
public class ReadableTest {
    public static void main(String[] args) {
        // TODO 36: StringReader 테스트하기
        // "Hello World\nJava Programming" 문자열로 생성
        // readLine()으로 첫 줄 읽고 출력
        // readWord()로 다음 단어 읽고 출력
        StringReader reader = new StringReader("Hello World\nJava Programming");

        System.out.println(reader.readLine()); // "Hello World"
        System.out.println(reader.readWord()); // "Java"

        // TODO 37: StarPattern 테스트하기
        Readable star = new StarPattern();
        System.out.println(star.readAll());
    }
}