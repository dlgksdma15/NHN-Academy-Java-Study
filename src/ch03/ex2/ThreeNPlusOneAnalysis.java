package ch03.ex2;

import textio.TextIO;

public class ThreeNPlusOneAnalysis {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 수열 분석기 ===");
        System.out.println("1부터 지정한 숫자까지 모든 수의 수열 길이를 분석\n");

        System.out.print("분석할 최대 숫자: ");
        int maxNumber = TextIO.getlnInt();

        int longestLength = 0;
        int numberWithLongest = 0;

        // 각 숫자에 대해 수열 계산
        int startNumber = 1;
        while (startNumber <= maxNumber) {
            int N = startNumber;
            int length = 1;

            // TODO: 해당 숫자의 수열 길이 계산
            // 힌트: 앞의 3N+1 예제와 동일한 로직
            // 단, 수열을 출력하지 않고 길이만 계산

            // 여기에 코드를 작성하세요
            while (N != 1) {
                if (N % 2 == 0) {
                    N = N / 2;
                } else {
                    N = 3 * N + 1;
                }
                length++;
            }


            // 최대 길이 갱신
            if (length > longestLength) {
                longestLength = length;
                numberWithLongest = startNumber;
            }

            // 진행 상황 출력 (10의 배수마다)
            if (startNumber % 10 == 0) {
                System.out.println(startNumber + "까지 완료...");
            }

            startNumber = startNumber + 1;
        }

        // 결과 출력
        System.out.println("\n=== 분석 결과 ===");
        System.out.println("가장 긴 수열을 가진 숫자: " + numberWithLongest);
        System.out.println("수열의 길이: " + longestLength);
    }
}