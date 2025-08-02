package ch04.ex4;

public class ThreeNPlusOneFunctions {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 시퀀스 함수 ===\n");

        int start = 27;
        System.out.println("시작값: " + start);
        System.out.println("다음 항: " + nextN(start));
        System.out.println("시퀀스 길이: " + sequenceLength(start));
        System.out.println("최대값: " + maxInSequence(start));

        System.out.print("\n시퀀스: ");
        printSequence(start);
    }

    static int nextN(int n) {
        return (n % 2 == 0) ? n / 2 : 3 * n + 1;
    }

    static int sequenceLength(int start) {
        int count = 1;
        int n = start;
        while (n != 1) {
            n = nextN(n);
            count++;
        }
        return count;
    }

    static int maxInSequence(int start) {
        int max = start;
        int n = start;
        while (n != 1) {
            n = nextN(n);
            if (n > max) max = n;
        }
        return max;
    }

    static void printSequence(int start) {
        int n = start;
        while (n != 1) {
            System.out.print(n + " → ");
            n = nextN(n);
        }
        System.out.println("1");
    }
}
