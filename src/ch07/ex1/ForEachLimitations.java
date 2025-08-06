package ch07.ex1;

public class ForEachLimitations {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        // 1. 배열 수정 시도 (실패)
        System.out.println("=== 배열 수정 시도 ===");
        System.out.println("수정 전: ");
        printArray(values);

        // TODO: for-each 루프를 사용하여 각 요소에 10을 곱해보세요
        // 주의: 이 방법으로는 배열이 변경되지 않습니다!


        System.out.println("for-each 후: ");
        printArray(values);  // 변경되지 않음

        // TODO: 올바른 방법으로 배열의 각 요소에 10을 곱하세요
        // 힌트: 인덱스를 사용한 일반 for 루프 사용


        System.out.println("인덱스 사용 후: ");
        printArray(values);  // 변경됨

        // 2. 인덱스가 필요한 경우
        String[] items = {"첫째", "둘째", "셋째", "넷째"};

        System.out.println("\n=== 인덱스가 필요한 경우 ===");
        // TODO: 인덱스를 사용하여 "번호번: 항목" 형식으로 출력하세요
        // 예: "1번: 첫째"


        // 3. 역순 처리
        System.out.println("\n=== 역순 처리 ===");
        // TODO: 배열을 역순으로 출력하세요

    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}