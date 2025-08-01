package ch03.ex7;

import textio.TextIO;

public class GradeManagementExample {
    public static void main(String[] args) {
        System.out.println("=== 성적 관리 시스템 ===");

        try {
            int studentCount = getStudentCount();
            processStudentGrades(studentCount);

        } catch (Exception e) {
            System.out.println("❌ 시스템 오류: " + e.getMessage());
        }
    }

    public static int getStudentCount() {
        while (true) {
            try {
                System.out.print("학생 수를 입력하세요 (1-50): ");
                String input = TextIO.getln();
                int count = Integer.parseInt(input);

                // TODO: 학생 수 검증
                // 힌트: 범위 검사
                if(count > 0 && count <= 50){
                    return count;
                }else{
                    throw new IllegalArgumentException();
                }

                // 여기에 코드를 작성하세요

            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    public static void processStudentGrades(int studentCount) {
        String[] studentNames = new String[studentCount];
        double[] scores = new double[studentCount];
        String[] grades = new String[studentCount];

        // 학생 정보 입력
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n--- 학생 " + (i + 1) + " ---");

            studentNames[i] = getStudentName(i + 1);
            scores[i] = getValidScore(studentNames[i]);
            grades[i] = calculateGrade(scores[i]);
        }

        // 결과 출력
        displayResults(studentNames, scores, grades);

        // 통계 계산
        calculateStatistics(scores);
    }

    public static String getStudentName(int studentNumber) {
        while (true) {
            try {
                System.out.print("학생 이름: ");
                String name = TextIO.getln().trim();

                // TODO: 이름 유효성 검증
                // 힌트: 비어있는지, 길이, 숫자만 있는지 검사
                if(name.equals("")) {
                    throw new IllegalArgumentException("이름은 비어 있을 수 있습니다.");
                }else if(name.length() < 2 || name.length() > 20){
                    throw new IllegalArgumentException("이름의 길이는 2글자 이상 20글자 이하입니다");
                }else if(name.matches("[0-9]+")){
                    throw new IllegalArgumentException("이름에 숫자만 포함될 수 없습니다.");
                }

                // 여기에 코드를 작성하세요
                return name; // 임시 반환값

            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    public static double getValidScore(String studentName) {
        while (true) {
            try {
                System.out.print(studentName + " 학생의 점수 (0-100): ");
                String input = TextIO.getln();
                double score = Double.parseDouble(input);

                // TODO: 점수 유효성 검증
                // 힌트: 범위 검사
                if(score < 0 || score > 100){
                    throw new IllegalArgumentException("점수는 1~100 사이이여야 합니다.");
                }
                // 여기에 코드를 작성하세요
                return score; // 임시 반환값

            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    public static String calculateGrade(double score) {
        // TODO: 세분화된 등급 계산
        // 힌트: if-else if 체인
        String grade;
        if(score >= 90){
            grade = "A";
        }else if(score >= 80){
            grade = "B";
        }else if(score >= 70){
            grade = "C";
        }else if(score >= 60){
            grade = "D";
        }else{
            grade = "F";
        }
        // 여기에 코드를 작성하세요
        return grade; // 임시 반환값
    }

    public static void displayResults(String[] names, double[] scores, String[] grades) {
        // TODO: 성적 결과 출력
        // 힌트: printf로 테이블 형태 출력
        System.out.println("==================================================\n" +
                "\uD83D\uDCCA 성적 결과\n" +
                "==================================================\n" +
                "이름              점수   등급\n" +
                "--------------------------------------------------");
        int count = 0;
        // 여기에 코드를 작성하세요
        for (int i = 0; i < names.length; i++){
            System.out.printf("%-15s %6.1f   %s%n", names[i], scores[i], grades[i]);
        }
        System.out.println("--------------------------------------------------");
    }

    public static void calculateStatistics(double[] scores) {
        try {
            double sum = 0;
            double max = scores[0];
            double min = scores[0];

            for (double score : scores) {
                sum += score;
                if (score > max) max = score;
                if (score < min) min = score;
            }

            double average = sum / scores.length;

            // TODO: 등급별 통계 계산
            // 힌트: 점수 범위로 등급 구분
            int[] gradeCount = new int[5];
            

            // 여기에 코드를 작성하세요

            for (double score : scores) {
                if (score >= 90) gradeCount[0]++;
                else if (score >= 80) gradeCount[1]++;
                else if (score >= 70) gradeCount[2]++;
                else if (score >= 60) gradeCount[3]++;
                else gradeCount[4]++;
            }

            System.out.println("\n📈 통계 정보:");
            System.out.printf("• 평균: %.2f점%n", average);
            System.out.printf("• 최고점: %.1f점%n", max);
            System.out.printf("• 최저점: %.1f점%n", min);
            System.out.printf("• 점수 범위: %.1f점%n", max - min);

            System.out.println("\n📊 등급별 분포:");
            String[] gradeNames = {"A (90-100)", "B (80-89)", "C (70-79)", "D (60-69)", "F (0-59)"};
            for (int i = 0; i < gradeNames.length; i++) {
                double percentage = (gradeCount[i] * 100.0) / scores.length;
                System.out.printf("• %s: %d명 (%.1f%%)%n", gradeNames[i], gradeCount[i], percentage);
            }

        } catch (Exception e) {
            System.out.println("❌ 통계 계산 중 오류: " + e.getMessage());
        }
    }
}