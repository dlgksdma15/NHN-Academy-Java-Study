package ch03.ex8;

public class ArrayInitializationExample {
    public static void main(String[] args) {
        System.out.println("=== 배열 초기화 방법들 ===");

        // 방법 1: 초기값 리스트 사용
        int[] ages = {18, 21, 25, 30, 35};
        String[] cities = {"서울", "부산", "대구", "인천", "광주"};

        // 방법 2: new 연산자와 초기값 리스트
        int[] scores = new int[]{85, 92, 78, 96, 88};

        // TODO: 방법 3 - 반복문으로 초기화
        // 힌트: for 루프

        // 여기에 코드를 작성하세요
        // 방법 3: 반복문으로 초기화
        int[] multiples = new int[5];  // 크기 5짜리 배열 선언
        for (int i = 0; i < multiples.length; i++) {
            multiples[i] = (i + 1) * 10;  // 10, 20, 30, 40, 50
        }

        // 방법 4: Arrays.fill() 메서드 사용
        int[] sameValues = new int[8];
        java.util.Arrays.fill(sameValues, 99);  // 모든 요소를 99로 초기화

        // 결과 출력
        System.out.println("ages: " + java.util.Arrays.toString(ages));
        System.out.println("cities: " + java.util.Arrays.toString(cities));
        System.out.println("scores: " + java.util.Arrays.toString(scores));
        System.out.println("multiples: " + java.util.Arrays.toString(multiples));
        System.out.println("sameValues: " + java.util.Arrays.toString(sameValues));
    }
}