package ch04.ex1;

public class ChunkingExample {
    public static void main(String[] args) {
        System.out.println("=== 청킹을 통한 복잡성 관리 ===\n");

        // 학생 성적 처리 기능 사용하기
        int[] scores = {85, 92, 78, 96, 88, 91, 83, 87};
        processStudentGrades(scores);

        // 보고서 생성 기능 사용하기
        generateMonthlyReport("2024년 1월");

        // 이메일 발송 기능 사용하기
        sendWelcomeEmail("user@example.com", "홍길동");
    }

    // 학생 성적 처리 메서드
    public static void processStudentGrades(int[] scores) {
        System.out.println("학생 성적 처리:");

        // 1. 평균 계산
        double average = calculateAverage(scores);

        // 2. 최고 점수 찾기
        int highest = findHighestScore(scores);

        // 3. 최저 점수 찾기
        int lowest = findLowestScore(scores);

        // 4. 학점 결정
        String grade = determineGrade(average);

        // 5. 결과 출력
        System.out.printf("평균 점수: %.2f점\n", average);
        System.out.println("최고 점수: " + highest + "점");
        System.out.println("최저 점수: " + lowest + "점");
        System.out.println("학점: " + grade);
        System.out.println();
    }

    // 평균 계산 메서드
    private static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // 최고 점수 찾기 메서드
    private static int findHighestScore(int[] scores) {
        int highest = scores[0];
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    // 최저 점수 찾기 메서드
    private static int findLowestScore(int[] scores) {
        int lowest = scores[0];
        for (int score : scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }

    // 학점 결정 메서드
    private static String determineGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    // 월간 보고서 생성 메서드
    public static void generateMonthlyReport(String month) {
        System.out.println("[" + month + " 보고서 생성]");
        System.out.println("1단계: 데이터 수집 중...");
        System.out.println("2단계: 데이터 분석 중...");
        System.out.println("3단계: 보고서 작성 중...");
        System.out.println("4단계: 보고서 완성!");
        System.out.println();
    }

    // 이메일 발송 메서드
    public static void sendWelcomeEmail(String email, String name) {
        System.out.println("환영 이메일 발송:");
        System.out.println("수신자: " + name + " (" + email + ")");
        System.out.println("제목: 회원가입을 환영합니다!");
        System.out.println("본문: " + name + "님, 가입해주셔서 감사합니다!");
        System.out.println();
    }
}
