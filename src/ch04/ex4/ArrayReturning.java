package ch04.ex4;

public class ArrayReturning {
    public static void main(String[] args) {
        System.out.println("=== 배열 반환 함수 ===\n");

        int[] range = createRange(5, 10);
        System.out.print("createRange(5, 10): ");
        printArray(range);

        int[] fib = fibonacciArray(10);
        System.out.print("피보나치 수열 (10개): ");
        printArray(fib);

        int[] primes = firstNPrimes(10);
        System.out.print("처음 10개의 소수: ");
        printArray(primes);

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = filterEven(numbers);
        System.out.print("짝수만: ");
        printArray(evens);
    }

    static int[] createRange(int start, int end) {
        int size = end - start + 1;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = start + i;
        }
        return result;
    }

    static int[] fibonacciArray(int n) {
        if (n <= 0) return new int[0];
        int[] fib = new int[n];
        if (n >= 1) fib[0] = 1;
        if (n >= 2) fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    static int[] firstNPrimes(int n) {
        int[] primes = new int[n];
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                primes[count++] = num;
            }
            num++;
        }
        return primes;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static int[] filterEven(int[] array) {
        int count = 0;
        for (int num : array) if (num % 2 == 0) count++;
        int[] result = new int[count];
        int idx = 0;
        for (int num : array) if (num % 2 == 0) result[idx++] = num;
        return result;
    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

