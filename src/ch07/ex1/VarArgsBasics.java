package ch07.ex1;

public class VarArgsBasics {
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static int max(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty.");
        }
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    public static double average(double... values) {
        if (values.length == 0) {
            return 0.0;
        }
        double total = 0;
        for (double val : values) {
            total += val;
        }
        return total / values.length;
    }


    public static void main(String[] args) {
        // 다양한 개수의 인수로 호출
        System.out.println("sum() = " + sum());  // 0
        System.out.println("sum(5) = " + sum(5));  // 5
        System.out.println("sum(1,2,3) = " + sum(1, 2, 3));  // 6
        System.out.println("sum(1,2,3,4,5) = " + sum(1, 2, 3, 4, 5));  // 15

        System.out.println("\nmax(10,5,8) = " + max(10, 5, 8));  // 10
        System.out.println("max(3,7,2,9,5) = " + max(3, 7, 2, 9, 5));  // 9

        System.out.printf("\naverage(85.5, 90.0, 78.5) = %.2f\n",
                average(85.5, 90.0, 78.5));

        // 배열을 가변 인수로 전달
        int[] array = {10, 20, 30, 40, 50};
        System.out.println("\n배열 전달: sum(array) = " + sum(array));
    }
}