package ch03.ex1;

public class MultiplicationTable {
    public static void main(String[] args) {
        int table = 7;  // 7단
        int multiplier = 1;

        System.out.println("=== " + table + "단 ===");

        // TODO: 구구단 출력 루프
        // 힌트:
        // 1. multiplier가 9 이하인 동안 반복
        // 2. result = table * multiplier
        // 3. 결과 출력 (형식: "7 × 3 = 21")
        // 4. multiplier를 1 증가

        // 여기에 코드를 작성하세요
        while(multiplier <= 9){
            int result = table * multiplier;
            System.out.printf("%d x %d = %d\n", table,multiplier,result);
            multiplier++;
        }
    }
}