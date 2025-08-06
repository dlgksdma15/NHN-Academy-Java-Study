package ch07.ex6;

public class JaggedArrayExample {
    public static void main(String[] args) {
        // 삼각형 모양의 배열 생성
        int[][] triangle = new int[5][];  // 5개의 행만 생성

        // 각 행을 다른 길이로 생성
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];  // i+1개의 요소
        }

        // 값 초기화
        int value = 1;
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = value++;
            }
        }

        System.out.println("삼각형 배열:");
        printJaggedArray(triangle);

        // 파스칼의 삼각형 만들기
        int[][] pascal = createPascalTriangle(6);
        System.out.println("\n파스칼의 삼각형:");
        printJaggedArray(pascal);
    }

    public static void printJaggedArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%3d", element);
            }
            System.out.println();
        }
    }

    // 파스칼의 삼각형 생성
    public static int[][] createPascalTriangle(int rows) {
        int[][] pascal = new int[rows][];

        for (int i = 0; i < rows; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }

        return pascal;
    }
}
