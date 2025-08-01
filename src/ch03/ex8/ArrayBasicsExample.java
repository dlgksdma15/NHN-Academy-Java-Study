package ch03.ex8;

public class ArrayBasicsExample {
    public static void main(String[] args) {
        System.out.println("=== 배열 기본 예제 ===");

        // TODO: 배열 선언과 생성
        // 힌트: 배열 생성 문법

        // 여기에 코드를 작성하세요
        int[] numbers1 = new int[5];
        int[] numbers2 = new int[10];
        int[] numbers3 = new int[5];
        String[] names = new String[10];
        double[] prices = new double[5];
        boolean[] flags = new boolean[5];
        // 2. 기본값 확인
        System.out.println("=== 자동 초기화된 값 ===");
        System.out.println("int 배열: " + numbers1[0]);      // 0
        System.out.println("String 배열: " + names[0]);      // null
        System.out.println("double 배열: " + prices[0]);     // 0.0
        System.out.println("boolean 배열: " + flags[0]);     // false

        // 3. 배열 길이 확인
        System.out.println("\n=== 배열 길이 ===");
        System.out.println("numbers1 길이: " + numbers1.length);
        System.out.println("numbers2 길이: " + numbers2.length);
        System.out.println("numbers3 길이: " + numbers3.length);

        // TODO: 배열 값 설정과 읽기
        // 힌트: 인덱스 사용
        System.out.println("\n=== 배열 요소 접근 ===");

        // 여기에 코드를 작성하세요
        numbers1[0] = 100;
        numbers1[1] = 50;
        System.out.println("첫 번째 요소: " + numbers1[0]);
        System.out.println("두 번째 요소: " + numbers1[1]);
    }
}