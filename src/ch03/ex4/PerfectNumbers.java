package ch03.ex4;


public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println("1부터 10000까지의 완전수:");
        System.out.println("(완전수: 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수)");

        for (int n = 1; n <= 10000; n++) {
            int sumOfDivisors = 0;

            // 진약수(자기 자신 제외) 합 구하기
            for (int d = 1; d < n; d++) {
                if (n % d == 0) {
                    sumOfDivisors += d;  // 약수를 누적
                }
            }

            // 완전수라면 출력
            if (sumOfDivisors == n) {
                System.out.print("\n" + n + " = ");

                boolean first = true;
                for (int d = 1; d < n; d++) {
                    if (n % d == 0) {
                        if (first) {
                            System.out.print(d);
                            first = false;
                        } else {
                            System.out.print(" + " + d);
                        }
                    }
                }
            }
        }

        System.out.println();
    }
}
