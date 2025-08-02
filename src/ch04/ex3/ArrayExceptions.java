package ch04.ex3;

public class ArrayExceptions {
    public static void main(String[] args) {
        System.out.println("=== 배열 예외 처리 ===\n");

        // TODO 71: 정상적인 배열 처리하기
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("평균:" + calculateAverage(numbers));

        // TODO 72: 빈 배열 처리하기
        int[] empty = {};
        try {
            System.out.println("평균(빈 배열): " + calculateAverage(empty));
        } catch (IllegalArgumentException e) {
            System.out.println("빈 배열 오류: " + e.getMessage());
        }

        // TODO 73: null 배열 처리하기
        try {
            System.out.println("평균(null): " + calculateAverage(null));
        } catch (IllegalArgumentException e) {
            System.out.println("null 배열 오류: " + e.getMessage());
        }

        // TODO 74: 인덱스 범위 검사하기
        System.out.println("\n=== 인덱스 검사 ===");
        try {
            System.out.println("인덱스 2의 값: " + getElement(numbers,2));
            System.out.println("인덱스 10의 값: " + getElement(numbers,10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 오류: " + e.getMessage());
        }

        // TODO 75: 배열 나누기 처리하기
        System.out.println("\n=== 배열 분할 ===");
        try {
            int[] result = divideArray(numbers, 2);
            printArray(result);

            int[] ints = divideArray(numbers, 0);
            printArray(result);

        } catch (ArithmeticException e) {
            System.out.println("나누기 오류: " + e.getMessage());
        }
    }

    // TODO 76: 안전한 평균 계산 메서드 구현하기
    static double calculateAverage(int[] array) {
        if(array == null){
            throw new IllegalArgumentException("배열이 null입니다.");
        }if(array.length == 0){
            throw new IllegalArgumentException("배열은 비워있을 수 없습니다.");
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (double) sum / array.length;

    }

    // TODO 77: 안전한 요소 접근 메서드 구현하기
    static int getElement(int[] array, int index) {
        if(array == null){
            throw new IllegalArgumentException("배열이 null 입니다.");
        }
        if(index < 0 || index >= array.length){
            throw new IndexOutOfBoundsException("인덱스 " + index + "는 범위를 벗어났습니다.");
        }
        return array[index];
    }

    // TODO 78: 안전한 배열 나누기 메서드 구현하기
    static int[] divideArray(int[] array, int divisor) {
        if(array == null){
            throw new IllegalArgumentException("배열이 null입니다.");
        }
        if(divisor == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        for(int i = 0; i < array.length;i++){
            array[i] = array[i] / divisor;
        }
        System.out.print(divisor + "로 나눈 결과: ");
        return array;
    }

    // TODO 79: 배열 출력 메서드 구현하기
    static void printArray(int[] array) {
        if(array == null){
            throw new IllegalArgumentException("배열이 null 입니다.");
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}