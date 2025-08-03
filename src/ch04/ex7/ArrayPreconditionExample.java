package ch04.ex7;

import java.util.Arrays;

public class ArrayPreconditionExample {
    public static void main(String[] args) {
        System.out.println("=== 배열 사전/사후 조건 예제 ===\n");

        // TODO 4: 배열 메서드들 테스트하기
        int[] numbers = {3, 7, 2, 9, 1, 5};

        System.out.println("원본 배열: " + Arrays.toString(numbers));
        System.out.println("최대값: " + findMax(numbers));

        reverseArray(numbers);
        System.out.println("뒤집은 배열: " + Arrays.toString(numbers));
    }

    // TODO 5: findMax 메서드 구현하기
    /**
     * 배열에서 최대값을 찾습니다.
     *
     * 사전 조건:
     *   - array != null
     *   - array.length > 0
     * 사후 조건:
     *   - 반환값 >= array[i] (모든 i에 대해)
     *   - 반환값은 배열의 원소 중 하나
     *
     * @param array 검색할 배열
     * @return 배열의 최대값
     * @throws IllegalArgumentException 배열이 null이거나 비어있을 때
     */
    public static int findMax(int[] array) {
        // 사전 조건 검사
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("배열이 null이거나 비어있습니다.");
        }
        // 최대값 찾기
        int max = array[0];
        for (int value : array) {
            if(max < value){
                max = value;
            }
        }
        return max;

    }

    // TODO 6: reverseArray 메서드 구현하기
    /**
     * 배열을 뒤집습니다.
     *
     * 사전 조건: array != null
     * 사후 조건: array[i] = 원래 array[n-1-i] (모든 i에 대해, n은 배열 길이)
     *
     * @param array 뒤집을 배열
     */
    public static void reverseArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("배열이 null입니다.");
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}