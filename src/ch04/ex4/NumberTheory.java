package ch04.ex4;

public class NumberTheory {
    public static void main(String[] args) {
        System.out.println("=== 수론 함수 ===\n");

        int n = 24;
        System.out.println(n + "의 약수 개수: " + countDivisors(n));
        System.out.println(n + "의 약수 합: " + sumDivisors(n));
        System.out.print(n + "의 모든 약수: ");
        printDivisors(n);
        System.out.println("\n");

        System.out.println("1~30 사이의 완전수:");
        for (int i = 1; i <= 30; i++) {
            if (isPerfectNumber(i)) {
                System.out.println(i + " (약수: " + getDivisorList(i) + ")");
            }
        }
    }

    static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }

    static int sumDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum;
    }

    static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) System.out.print(i + " ");
        }
    }

    static boolean isPerfectNumber(int n) {
        return (sumDivisors(n) - n) == n;
    }

    static String getDivisorList(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                if (sb.length() > 0) sb.append("+");
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
