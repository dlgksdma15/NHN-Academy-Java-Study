package ch07.ex1;

public class ConditionalProcessing {
    public static void main(String[] args) {
        int[] scores = {65, 78, 92, 55, 88, 73, 95, 81, 68, 87};

        // TODO: 합격자 수와 합격자 점수 총합을 계산하세요 (70점 이상)
        int passCount = 0;
        int totalPass = 0;

        System.out.println("=== 시험 결과 ===");
        // TODO: for-each 루프를 사용하여 각 점수에 대해 합격/불합격을 출력하세요
        // 70점 이상이면 "점수점: 합격", 미만이면 "점수점: 불합격"
        // 합격인 경우 passCount와 totalPass 업데이트
        for (int score : scores) {
            if (score >= 70) {
                System.out.println(score + "점: 합격");
                passCount++;
                totalPass += score;
            } else {
                System.out.println(score + "점: 불합격");
            }
        }


        System.out.println("\n=== 결과 요약 ===");
        System.out.println("전체 응시자: " + scores.length + "명");
        System.out.println("합격자: " + passCount + "명");
        System.out.println("불합격자: " + (scores.length - passCount) + "명");
        if (passCount > 0) {
            System.out.printf("합격자 평균: %.1f점\n",
                    (double)totalPass / passCount);
        }
    }
}