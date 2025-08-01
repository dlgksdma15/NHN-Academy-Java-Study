package ch02.ex2;

public class VariableBasics {
    public static void main(String[] args) {
        // TODO: 변수를 선언만 하세요 (초기화하지 않음)
        int count;
        double price;
        boolean isAvailable;

        // TODO: 위에서 선언한 변수에 값을 할당하세요
        count = 10;
        price = 29.99;
        isAvailable = true;

        // TODO: 선언과 동시에 초기화하세요
        // 힌트:
        int quantity = 5;
        double discount = 0.15;
        char grade = 'A';

        // TODO: 여러 변수를 동시에 선언하고 개별적으로 값을 할당하세요
        // 힌트:
        // 1. x, y, z를 int 타입으로 동시 선언
        int x = 1, y = 2, z = 3;

        // TODO: 여러 변수를 동시에 선언하면서 초기화하세요
        int width = 100, height = 200, depth = 50;

        // TODO: 결과를 출력하세요
        System.out.println("count = " + count);
        System.out.println("price = " + price);
        System.out.println("quantity x price = " + quantity * price);
    }
}