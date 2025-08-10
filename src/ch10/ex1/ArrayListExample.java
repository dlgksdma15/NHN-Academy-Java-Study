package ch10.ex1;

import java.util.*;

public class ArrayListExample {

    public static void main(String[] args) {
        // 문자열 리스트
        ArrayList<String> fruits = new ArrayList<>();

        // TODO: 과일 추가 - "사과", "바나나", "오렌지"
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        // TODO: 인덱스 1에 "딸기" 추가
        System.out.println(fruits);
        fruits.add(1,"딸기");
        System.out.println(fruits);
        // TODO: 첫 번째 과일 가져오기
        String first = fruits.get(0);
        System.out.println(first);
        // TODO: 인덱스 2의 과일을 "키위"로 변경
        fruits.set(2,"키위");
        System.out.println(fruits);
        // TODO: "딸기" 삭제
        fruits.remove("딸기");
        System.out.println(fruits);
        // TODO: 인덱스 0의 과일 삭제
        fruits.remove(0);
        System.out.println(fruits);
        // TODO: "오렌지"가 있는지 확인
        boolean orange = fruits.contains("오렌지");
        System.out.println(orange);
        // TODO: "키위"의 인덱스 찾기
        int kiwi = fruits.indexOf("키위");
        System.out.println(kiwi);
        // TODO: fruits 리스트 정렬
        fruits.sort(Comparator.naturalOrder());
        System.out.println(fruits);
        /*fruits.sort(Comparator.reverseOrder());
        System.out.println(fruits);*/
        System.out.println(fruits.size());
        fruits.clear();
        System.out.println(fruits.isEmpty());
        // 실행 결과:
        // 과일 목록: [사과, 딸기, 바나나, 오렌지]
        // 첫 번째 과일: 사과
        // 수정 후: [사과, 딸기, 키위, 오렌지]
        // 삭제 후: [키위, 오렌지]
        // 오렌지 있음? true
        // 키위의 위치: 0
        // 정렬 후: [오렌지, 키위]
        // 크기: 2
        // 비운 후 비어있음? true

    }
}