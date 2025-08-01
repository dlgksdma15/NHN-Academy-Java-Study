package ch04.ex2;

public class SubroutineBasics {
    public static void main(String[] args) {
        System.out.println("=== 서브루틴 기본 예제 ===\n");

        // 1: 매개변수와 반환값이 없는 메서드 호출
        printWelcome();

        // 2: 매개변수가 있는 메서드 호출
        greetUser("홍길동");
        greetUser("김철수");

        // 3: 반환값이 있는 메서드 호출
        int sum = add(10, 20);
        System.out.println("10 + 20 = " + sum);

        // 4: 여러 매개변수와 반환값이 있는 메서드 호출
        double avg = calculateAverage(85, 92, 78);
        System.out.println("평균 점수: " + avg);

        // 5: 문자열을 반환하는 메서드 호출
        String message = createMessage("Java", "재미있다");
        System.out.println(message);
    }

    // 6: void 메서드 구현 (반환값 없음)
    public static void printWelcome() {
        System.out.println("프로그램에 오신 것을 환영합니다!");
        System.out.println("즐거운 시간 되세요.\n");
    }

    // 7: 매개변수가 있는 void 메서드
    public static void greetUser(String name) {
        System.out.println("안녕하세요, " + name + "님!");
    }

    // 8: int를 반환하는 메서드
    public static int add(int a, int b) {
        return a + b;
    }

    // 9: double을 반환하는 메서드
    public static double calculateAverage(int score1, int score2, int score3) {
        return (score1 + score2 + score3) / 3.0; // 정수 나눗셈 방지
    }

    // 10: String을 반환하는 메서드
    public static String createMessage(String subject, String description) {
        return subject + "은(는) " + description + "!";
    }
}
