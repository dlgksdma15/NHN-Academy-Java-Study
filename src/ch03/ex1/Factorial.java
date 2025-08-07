package ch03.ex1;

public class Factorial {

    public static long factorialWithTrace(int n, String indent) {
        System.out.println(indent + "factorialWithTrace(" + n + ") called.");
        if (n < 0) {
            System.out.println(indent + "Factorial is not defined for negative numbers. Returning 1.");
            return 1; // Or throw an IllegalArgumentException
        }
        if (n == 0) {
            System.out.println(indent + "Base case: 0! = 1. Returning 1.");
            return 1;
        }

        long result = n * factorialWithTrace(n - 1, indent + "  ");
        System.out.println(indent + "Calculating " + n + " * factorialWithTrace(" + (n - 1) + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Calculating factorial of " + n + ":");
        long result = factorialWithTrace(n, "");
        System.out.println(n + "! = " + result);
        System.out.println();

        int m = 0;
        System.out.println("Calculating factorial of " + m + ":");
        result = factorialWithTrace(m, "");
        System.out.println(m + "! = " + result);
        System.out.println();

        int p = -3;
        System.out.println("Calculating factorial of " + p + ":");
        result = factorialWithTrace(p, "");
        System.out.println(p + "! = " + result);
    }
}
