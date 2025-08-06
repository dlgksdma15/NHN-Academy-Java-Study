package ch07.ex3;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentTypeArrayLists {
    public static void main(String[] args) {
        // TODO: 정수 ArrayList를 생성하고 10, 20, 30, 40, 50을 추가하세요
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,20,30,40,50));

        System.out.println("정수 리스트: " + numbers);

        // TODO: 실수 ArrayList를 생성하고 19.99, 35.50, 42.00을 추가하세요
        ArrayList<Double> prices = new ArrayList<>();
        prices.add(19.99);
        prices.add(35.50);
        prices.add(42.00);

        System.out.println("가격 리스트: " + prices);

        // TODO: 문자 ArrayList를 생성하고 'A', 'B', 'C'를 추가하세요
        ArrayList<Character> grades = new ArrayList<>();
        grades.add('A');
        grades.add('B');
        grades.add('C');
        System.out.println("등급 리스트: " + grades);

        // TODO: Boolean ArrayList를 생성하고 true, false, true를 추가하세요
        ArrayList<Boolean> answers = new ArrayList<>();
        answers.add(true);
        answers.add(false);
        answers.add(true);
        System.out.println("답안 리스트: " + answers);
    }
}