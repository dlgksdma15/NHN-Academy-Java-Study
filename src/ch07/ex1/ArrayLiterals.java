package ch07.ex1;

public class ArrayLiterals {
    public static void main(String[] args) {
        // TODO: 배열 리터럴을 사용하여 소수 배열을 생성하세요
        int[] primes = {2,3,5,7,11,13,17,19};

        // TODO: new 연산자와 함께 배열 리터럴을 사용하여 짝수 배열을 생성하세요
        int[] evens = {2,4,6,8,10};

        // TODO: 변수에 나중에 배열 리터럴을 할당하세요 (피보나치 수열)
        int[] fibonacci;
        fibonacci = new int[] {1,1,2,3,5,8,13,21};

        // TODO: 조건에 따른 배열 생성 (삼항 연산자 사용)
        boolean useSmallSet = true;
        int[] dataset = useSmallSet ? new int[] {1,2,3}
            : new int[] {4,5,6,7,8};

        // 5. 메서드 호출 시 직접 생성
        printArray("소수", primes);
        printArray("짝수", new int[] {2, 4, 6, 8, 10});
        printArray("피보나치",fibonacci);
        printArray("작은 세트",dataset);

        // TODO: 다차원 배열 리터럴을 생성하세요 (3x3 행렬)
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("\n3x3 행렬:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(String label, int[] arr) {
        System.out.print(label + ": ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}