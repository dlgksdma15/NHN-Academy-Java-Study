package ch03.ex1;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int factorial = 1;
        int counter = 1;

        System.out.print(n + "! = ");

        while (counter <= n) {
            factorial *= counter;
            System.out.print(counter);
            if (counter < n) {
                System.out.print(" × ");
            }
            counter++;
        }

        System.out.println(" = " + factorial);
    }
}
