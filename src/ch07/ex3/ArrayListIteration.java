package ch07.ex3;

import java.util.ArrayList;

public class ArrayListIteration {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        // TODO: "사과", "바나나", "오렌지", "포도", "딸기"를 추가
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        fruits.add("포도");
        fruits.add("딸기");

        // TODO: 전통적인 for 루프로 인덱스와 함께 출력
        System.out.println("=== 전통적인 for 루프 ===");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(i + ": " + fruits.get(i));
        }

        // TODO: for-each 루프로 출력
        System.out.println("\n=== for-each 루프 ===");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // TODO: 역순으로 순회하여 출력
        System.out.println("\n=== 역순 순회 ===");
        for (int i = fruits.size() - 1; i >= 0; i--) {
            System.out.println(fruits.get(i));
        }

        // TODO: 3글자 이상인 과일만 출력
        System.out.println("\n=== 3글자 이상만 출력 ===");
        for (String fruit : fruits) {
            if (fruit.length() >= 3) {
                System.out.println(fruit);
            }
        }

        // TODO: 짝수 인덱스의 과일만 출력
        System.out.println("\n=== 짝수 인덱스만 ===");
        for (int i = 0; i < fruits.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(i + ": " + fruits.get(i));
            }
        }
    }
}
