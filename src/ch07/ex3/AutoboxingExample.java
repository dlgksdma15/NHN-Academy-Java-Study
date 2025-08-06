package ch07.ex3;

import java.util.ArrayList;

public class AutoboxingExample {
    public static void main(String[] args) {
        // TODO: Integer ArrayList를 생성하세요
        ArrayList<Integer> scores = new ArrayList<>();

        // TODO: 기본형 int 값들을 추가하세요 (오토박싱)
        // 95, 87, 92를 추가
        scores.add(95);
        scores.add(87);
        scores.add(92);


        // TODO: 첫 번째 요소를 int 변수에 저장하세요 (언박싱)
        int firstScore = scores.get(0);
        System.out.println("첫 번째 점수: " + firstScore);

        // TODO: for-each 루프를 사용하여 총점을 계산하세요
        // 언박싱이 자동으로 일어남
        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }
        System.out.println("총점: " + sum);

        // TODO: null 값을 추가하세요
        scores.add(null);
        System.out.println("null 포함 리스트: " + scores);

        // TODO: null 체크를 포함한 안전한 순회를 구현하세요
        System.out.println("=== 안전한 처리 ===");
        for (Integer score : scores) {
            if(score == null){
                System.out.println("정수: 미입력");
                break;
            }
            System.out.println("정수: " +  score);
        }

    }
}