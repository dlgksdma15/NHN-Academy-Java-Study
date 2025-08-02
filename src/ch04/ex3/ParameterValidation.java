package ch04.ex3;

public class ParameterValidation {
    public static void main(String[] args) {
        System.out.println("=== 매개변수 검증 예제 ===\n");

        // 65: 정상적인 호출 테스트
        try {
            System.out.println("정상 나이: " + validateAge(25));
            System.out.println("정상 점수: " + validateScore(85));
            System.out.println("정상 이름: " + validateName("홍길동"));
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }

        System.out.println("\n=== 잘못된 매개변수 ===");

        // 66: 잘못된 호출들 테스트
        testInvalidAge(-5);
        testInvalidAge(200);

        testInvalidScore(-10);
        testInvalidScore(150);

        testInvalidName(null);
        testInvalidName("");
        testInvalidName("   ");
    }

    // 67: 나이 검증
    static int validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("나이는 0~150 사이여야 합니다.");
        }
        return age;
    }

    // 68: 점수 검증
    static int validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0~100 사이여야 합니다.");
        }
        return score;
    }

    // 69: 이름 검증
    static String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        return name;
    }

    // 70: 잘못된 값 테스트 헬퍼 메서드
    static void testInvalidAge(int age) {
        try {
            validateAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("나이 " + age + ": " + e.getMessage());
        }
    }

    static void testInvalidScore(int score) {
        try {
            validateScore(score);
        } catch (IllegalArgumentException e) {
            System.out.println("점수 " + score + ": " + e.getMessage());
        }
    }

    static void testInvalidName(String name) {
        try {
            validateName(name);
        } catch (IllegalArgumentException e) {
            System.out.println("이름 \"" + name + "\": " + e.getMessage());
        }
    }
}
