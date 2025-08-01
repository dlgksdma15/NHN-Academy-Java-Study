package ch02.ex5;

public class TypeCasting {
    public static void main(String[] args) {
        System.out.println("=== 강제 타입 변환 ===");

        // 1. pi를 int로 캐스팅하여 소수 부분 버림
        double pi = 3.14159;
        int piInt = (int) pi;
        System.out.println("pi = " + pi);
        System.out.println("(int)pi = " + piInt);

        // 2. bigNumber를 byte로 캐스팅하여 오버플로우 확인
        int bigNumber = 130;
        byte byteNumber = (byte) bigNumber;
        System.out.println("\nbigNumber = " + bigNumber);
        System.out.println("(byte)bigNumber = " + byteNumber);

        // 3. 정수 나눗셈과 실수 나눗셈 비교
        int a = 7, b = 2;
        double intDiv = a / b; // 정수 나눗셈 결과를 double에 저장하면 소수점 이하 버려짐
        double doubleDiv = (double) a / b;
        System.out.println("\n정수 나눗셈:");
        System.out.println(a + " / " + b + " = " + intDiv);
        System.out.println("(double)" + a + " / " + b + " = " + doubleDiv);

        // 4. 문자 'Z'를 ASCII값으로 변환 후 +32 하여 소문자로 변환
        char letter = 'Z';
        int ascii = (int) letter;
        char lower = (char) (ascii + 32);
        System.out.println("\n문자 변환:");
        System.out.println("'" + letter + "' → " + ascii);
        System.out.println(ascii + " + 32 → '" + lower + "'");
    }
}
