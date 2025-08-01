package ch03.ex4;

public class PrimeSieve {
    public static void main(String[] args) {
        int limit = 100;
        boolean[] isPrime = new boolean[limit + 1];

        // 모든 수를 소수로 가정
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // TODO: 에라토스테네스의 체 알고리즘
        // 힌트:
        // 1. i를 2부터 i*i <= limit까지 반복
        // 2. isPrime[i]가 true이면:
        //    - j를 i*i부터 limit까지 i씩 증가시키며
        //    - isPrime[j] = false 설정 (i의 배수 제거)

        // 여기에 코드를 작성하세요
        // === 에라토스테네스의 체 알고리즘 ===
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 출력
        System.out.println("2부터 " + limit + "까지의 소수:");
        int count = 0;

        // TODO: 소수 출력
        // 힌트:
        // 1. i를 2부터 limit까지 반복
        // 2. isPrime[i]가 true이면:
        //    - i를 형식 "%3d "로 출력
        //    - count 증가
        //    - count가 10의 배수면 줄바꿈

        // 여기에 코드를 작성하세요
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                System.out.printf("%3d ", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println(); // 10개 출력하면 줄바꿈
                }
            }
        }

        System.out.println("\n\n총 " + count + "개의 소수");
    }
}