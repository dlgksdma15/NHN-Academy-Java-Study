package ch02.ex2;

public class IntegerLiterals {
    public static void main(String[] args) {
        int decimal = 255;
        int binary = 0b11111111;
        int octal = 0377;
        int hexadecimal = 0xFF;

        System.out.println("10진수: " + decimal);
        System.out.println("2진수: " + binary);
        System.out.println("8진수: " + octal);
        System.out.println("16진수: " + hexadecimal);

        boolean allEqual = (decimal == binary) && (binary == octal) && (octal == hexadecimal);
        System.out.println("모든 값이 같은가? " + allEqual);

        long creditCardNumber = 1234_5678_9012_3456L;
        int rgbColor = 0xFF_FF_FF;
        long worldPopulation = 7_900_000_000L;

        System.out.println("\n가독성 향상 예제:");
        System.out.println("신용카드 번호: " + creditCardNumber);
        System.out.println("RGB 색상: " + rgbColor);
        System.out.println("세계 인구: " + worldPopulation);
    }
}
