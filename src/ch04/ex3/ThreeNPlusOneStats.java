package ch04.ex3;

public class ThreeNPlusOneStats {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 통계 분석 ===\n");

        // 범위 분석
        analyzeRange(1, 10);

        // 가장 긴 시퀀스 찾기
        findLongestSequence(1, 20);
    }

    // 25: 범위 내 모든 수의 시퀀스 분석
    static void analyzeRange(int start, int end) {
        System.out.printf("[%d ~ %d] 범위 분석:\n", start, end);

        for (int i = start; i <= end; i++) {
            int length = getSequenceLength(i);
            int max = getMaxValue(i);
            System.out.printf("시작 값: %d  길이: %d, 최대값: %d\n", i, length, max);
        }
        System.out.println();
    }

    // 26: 가장 긴 시퀀스 찾기
    static void findLongestSequence(int start, int end) {
        int maxLength = 0;
        int numberWithMaxLength = start;

        for (int i = start; i <= end; i++) {
            int length = getSequenceLength(i);
            if (length > maxLength) {
                maxLength = length;
                numberWithMaxLength = i;
            }
        }

        System.out.printf("[%d ~ %d] 범위에서 가장 긴 시퀀스:\n", start, end);
        System.out.printf("시작 값: %d (길이: %d)\n\n", numberWithMaxLength, maxLength);
    }

    // 27: 시퀀스 길이 계산
    static int getSequenceLength(int startingValue) {
        int count = 1; // 시작값 포함
        int n = startingValue;

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
        }
        return count;
    }

    // 28: 최대값 계산
    static int getMaxValue(int startingValue) {
        int n = startingValue;
        int max = n;

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
