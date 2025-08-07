package ch09.ex1;

public class QuickSortExample {

    /**
     * 기본 퀵정렬
     */
    public static void quickSort(int[] arr, int low, int high) {
        // TODO 1: 재귀 조건 확인
        // 힌트: low < high인 경우에만 진행
        if(low < high){
            int pivotIndex = partition(arr,low,high);

            quickSort(arr, low, pivotIndex - 1);

            quickSort(arr,pivotIndex + 1, high);
        }
        // TODO 2: 분할(partition) 수행
        // int pivotIndex = partition(arr, low, high);

        // TODO 3: 피벗 기준으로 양쪽 재귀 호출

    }

    /**
     * 분할 함수 (Lomuto partition)
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        // TODO: 분할 로직 구현
        // 힌트: pivot보다 작은 요소는 왼쪽으로
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i + 1, high);
        return i + 1;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr){
        quickSort(arr,0,arr.length - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== 퀵정렬 예제 ===");

        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        System.out.println("정렬 전: " + java.util.Arrays.toString(arr));
        sort(arr);
        System.out.println("정렬 후: " + java.util.Arrays.toString(arr));
        // 실행 결과:
        // 원본: [64, 34, 25, 12, 22, 11, 90]
        // 정렬: [11, 12, 22, 25, 34, 64, 90]
    }
}