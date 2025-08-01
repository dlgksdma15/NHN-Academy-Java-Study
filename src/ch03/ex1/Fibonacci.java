package ch03.ex1;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;  // 처음 10개 항
        int first = 0;
        int second = 1;
        int count = 0;

        System.out.println("피보나치 수열의 처음 " + n + "개 항:");

        while (count < n) {
            if (count == 0) {
                System.out.print(first);
            } else if (count == 1) {
                System.out.print(", " + second);
            } else {
                int next = first + second;
                System.out.print(", " + next);
                first = second;
                second = next;
            }
            count = count + 1;
        }
        System.out.println();
    }
}