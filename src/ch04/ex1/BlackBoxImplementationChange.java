package ch04.ex1;

public class BlackBoxImplementationChange {
    public static void main(String[] args) {
        System.out.println("=== 블랙박스 구현 변경 예제 ===\n");

        // TODO 8: 두 가지 정렬 방식 테스트하기
        System.out.println("버전 1 정렬:");
        int[] numbers1 = {5, 2, 8, 1, 9};
        SortingBlackBoxV1.sort(numbers1);
        printArray(numbers1);

        System.out.println("\n버전 2 정렬:");
        int[] numbers2 = {5, 2, 8, 1, 9};
        SortingBlackBoxV2.sort(numbers2);
        printArray(numbers2);
    }

    // TODO 9: 배열을 출력하는 메서드를 구현하세요
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

// 버블 정렬을 사용하는 블랙박스 (참고용 - 이미 구현됨)
class SortingBlackBoxV1 {
    public static void sort(int[] array) {
        System.out.println("(버블 정렬 사용 중...)");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

// TODO 10: 선택 정렬을 사용하는 블랙박스 완성하기
class SortingBlackBoxV2 {
    public static void sort(int[] array) {
        System.out.println("(선택 정렬 사용 중...)");
        // TODO: 선택 정렬 알고리즘을 구현하세요

        for(int i = 0; i < array.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;

                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}