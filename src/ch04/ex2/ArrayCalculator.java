package ch04.ex2;

public class ArrayCalculator {
    public static void main(String[] args) {
        System.out.println("=== 배열 계산기 ===\n");

        int[] numbers = {10, 25, 30, 15, 20};

        // TODO 25: 배열 출력하고 통계 계산하기
        System.out.println("배열: ");
        printArray(numbers);

        System.out.println("\n통계:");
        System.out.println("합계: " + sum(numbers));
        System.out.println("평균: " + average(numbers));
        System.out.println("최대값: " + findMax(numbers));
        System.out.println("최소값: " + findMin(numbers));
        System.out.println("범위: " + range(numbers));
    }

    // TODO 26: 배열 출력 메서드 구현하기
    public static void printArray(int[] arr) {
        // 배열의 모든 요소를 공백으로 구분하여 출력
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // TODO 27: 합계 계산 메서드 구현하기
    public static int sum(int[] arr) {
        // 배열의 모든 요소 합계 반환
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    // TODO 28: 평균 계산 메서드 구현하기
    public static double average(int[] arr) {
        // 배열이 비어있으면 0 반환, 아니면 평균 반환
        // sum 메서드 활용하기
        double average;
        if(arr == null || arr.length == 0){
            return 0;
        }else{
            int sum = sum(arr);
            average = sum / arr.length;
        }
        return average;
    }

    // TODO 29: 최대값 찾기 메서드 구현하기
    public static int findMax(int[] arr) {
        // 배열이 비어있으면 Integer.MIN_VALUE 반환
        // 첫 번째 요소부터 시작해서 최대값 찾기
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    // TODO 30: 최소값 찾기 메서드 구현하기
    public static int findMin(int[] arr) {
        // 배열이 비어있으면 Integer.MAX_VALUE 반환
        if(arr == null || arr.length == 0){
            return Integer.MAX_VALUE;
        }
        int min = arr[0];
        for (int i : arr) {
            min = Math.min(min, i);
        }
        return min;

    }

    // TODO 31: 범위 계산 메서드 구현하기
    public static int range(int[] arr) {
        // 범위 = 최대값 - 최소값
        // findMax와 findMin 메서드 활용하기
        int result = findMax(arr) - findMin(arr);
        return result;

    }
}