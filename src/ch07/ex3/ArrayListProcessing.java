package ch07.ex3;

import java.util.ArrayList;

public class ArrayListProcessing {
    public static void main(String[] args) {
        // TODO: 1부터 20까지의 숫자로 ArrayList를 생성하세요
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 20; i++){
            numbers.add(i);
        }

        // TODO: 짝수만 필터링하여 새 ArrayList를 만드세요
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (Integer num : numbers) {
            if(num % 2 == 0){
                evenNumbers.add(num);
            }
        }
        System.out.println("짝수: " + evenNumbers);

        // TODO: 모든 숫자의 제곱수로 새 ArrayList를 만드세요
        ArrayList<Integer> squares = new ArrayList<>();
        for (Integer num : numbers) {
            squares.add(num * num);
        }

        System.out.println("제곱수: " + squares);

        // TODO: 숫자를 범주로 분류하여 새 ArrayList를 만드세요
        // 5 이하: "낮음", 15 이하: "중간", 그 외: "높음"
        ArrayList<String> categories = new ArrayList<>();
        for (Integer n : numbers) {
            if(n <= 5){
                categories.add("낮음");
            }else if(n <= 15) {
                categories.add("중간");
            }else{
                categories.add("높음");
            }

        }

        System.out.println("카테고리: " + categories);

        // TODO: 합계와 평균을 계산하세요
        int sum = 0;

        for (Integer n : numbers) {
            sum += n;
        }


        double average = (double) sum / numbers.size();
        System.out.println("합계: " + sum + ", 평균: " + average);
    }
}