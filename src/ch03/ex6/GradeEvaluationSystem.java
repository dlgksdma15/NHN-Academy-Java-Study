package ch03.ex6;

import textio.TextIO;

public class GradeEvaluationSystem {
    public static void main(String[] args) {
        System.out.print("점수를 입력하세요 (0-100): ");
        int score = TextIO.getlnInt();

        // TODO: switch 표현식으로 등급 결정
        // 힌트: score / 10 사용
        char grade = switch (score / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
                // TODO: switch 표현식으로 평가 메시지 생성
                // 힌트: yield 사용
        String evaluation = switch (grade) {
            case 'A' -> "탁월함";
            case 'B' -> "우수함";
            case 'C' -> "보통";
            case 'D' -> "미흡";
            case 'F' -> "재수강 필요";
            default -> throw new IllegalStateException("잘못된 등급입니다.");
        };
        // TODO: switch 표현식으로 학점 계산
        // 힌트: -> 연산자
        double gpa = switch (grade) {
            case 'A' -> 4.5;
            case 'B' -> 3.5;
            case 'C' -> 2.5;
            case 'D' -> 1.5;
            case 'F' -> 0.0;
            default -> -1.0;
        };


        // TODO: switch 표현식으로 조언 생성
        // 힌트: -> 연산자
        String advice = switch (grade) {
            case 'A', 'B' -> "잘하고 있어요! 계속 유지하세요.";
            case 'C' -> "좀 더 노력하면 더 좋아질 수 있어요.";
            case 'D', 'F' -> "복습과 추가 학습이 필요해요.";
            default -> "입력 오류";
        };

        System.out.println("\n=== 성적 결과 ===");
        System.out.printf("점수: %d점%n", score);
        System.out.printf("등급: %c (%s)%n", grade, evaluation);
        System.out.printf("학점: %.1f%n", gpa);
        System.out.println("조언: " + advice);

        // TODO: 장학금 자격 여부 판단
        // 힌트: switch 표현식
        boolean scholarship = switch (grade) {
            case 'A' -> true;
            case 'B' -> score >= 85;
            default -> false;
        };
        if (scholarship) {
            System.out.println("장학금 대상자입니다!");
        }
    }
}