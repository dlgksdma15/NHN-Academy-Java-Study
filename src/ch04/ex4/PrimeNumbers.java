package ch04.ex4;

public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println("=== 소수 관련 함수 ===\n");

        System.out.println("1~20까지의 소수:");
        for (int i = 1; i <= 20; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        System.out.println("처음 10개의 소수:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(nthPrime(i) + " ");
        }
        System.out.println("\n");

        int limit = 100;
        System.out.println("1~" + limit + " 사이의 소수 개수: " + countPrimes(limit));

        System.out.println("\n100 이하의 쌍둥이 소수:");
        findTwinPrimes(100);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static int nthPrime(int n) {
        int count = 0;
        int num = 1;
        while (count < n) {
            num++;
            if (isPrime(num)) count++;
        }
        return num;
    }

    static int countPrimes(int limit) {
        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    static void findTwinPrimes(int limit) {
        for (int i = 2; i <= limit - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }
}
