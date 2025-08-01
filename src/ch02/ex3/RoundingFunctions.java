package ch02.ex3;

public class RoundingFunctions {
    public static void main(String[] args) {
        double[] numbers = {3.14, 3.5, 3.8, -2.3, -2.7};

        System.out.println("숫자\tround\tfloor\tceil");
        System.out.println("----------------------------------------");

        for (double number : numbers) {
            System.out.printf("%.2f\t%d\t%.1f\t%.1f\n",
                    number,
                    Math.round(number),
                    Math.floor(number),
                    Math.ceil(number));
        }

        System.out.println("\n특별한 경우:");
        System.out.println(Math.floor(5.0));
        System.out.println(Math.ceil(5.0));
        System.out.println(Math.round(5.5));
    }
}