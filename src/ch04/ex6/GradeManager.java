package ch04.ex6;

// TODO 35: import문 추가하기
import java.util.ArrayList;

/**
 * 학생의 점수를 관리하는 클래스
 * <p>
 * 기능:
 * <ul>
 *   <li>점수 추가</li>
 *   <li>평균 점수 계산</li>
 *   <li>학점 계산</li>
 * </ul>
 *
 * <p>사용 예제:</p>
 * <pre>
 * GradeManager gm = new GradeManager();
 * gm.addScore(90);
 * gm.addScore(80);
 * System.out.println(gm.getAverage()); // 85.0
 * </pre>
 *
 * @author 홍길동
 * @version 1.0
 * @see java.util.ArrayList
 */
public class GradeManager {
    private ArrayList<Integer> scores;

    /**
     * 기본 생성자
     */
    public GradeManager() {
        scores = new ArrayList<>();
    }

    /**
     * 점수를 추가합니다.
     *
     * @param score 추가할 점수 (0~100 사이)
     * @throws IllegalArgumentException 점수가 범위를 벗어난 경우
     */
    public void addScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0과 100 사이여야 합니다: " + score);
        }
        scores.add(score);
    }

    /**
     * 점수들의 평균을 계산합니다.
     *
     * @return 평균 점수 (없으면 0)
     */
    public double getAverage() {
        if (scores.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    /**
     * 평균 점수로 학점을 반환합니다.
     * <p>학점 기준:</p>
     * <ul>
     *   <li>90점 이상: A</li>
     *   <li>80점 이상: B</li>
     *   <li>70점 이상: C</li>
     *   <li>60점 이상: D</li>
     *   <li>60점 미만: F</li>
     * </ul>
     *
     * @return 학점 문자
     * @see #getAverage()
     */
    public char getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }
}
