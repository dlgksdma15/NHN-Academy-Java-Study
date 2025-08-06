package ch07.ex3;
import java.util.ArrayList;

public class Dynamic2DArray {
    public static void main(String[] args) {
        // 가변 크기 2차원 ArrayList 생성
        ArrayList<ArrayList<Integer>> dynamicArray = new ArrayList<>();

        // 첫 번째 행 추가
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        dynamicArray.add(row1);

        // 두 번째 행 추가
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        dynamicArray.add(row2);

        // 세 번째 행 추가
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(7);
        row3.add(8);
        row3.add(9);
        dynamicArray.add(row3);

        // 2차원 ArrayList 출력
        System.out.println("동적 2차원 배열:");
        for (ArrayList<Integer> row : dynamicArray) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // 특정 요소에 접근
        System.out.println("(1, 2) 위치의 요소: " + dynamicArray.get(1).get(1));

        // 요소 수정
        dynamicArray.get(0).set(0, 100);
        System.out.println("수정 후 (0, 0) 위치의 요소: " + dynamicArray.get(0).get(0));

        // 행에 요소 추가
        dynamicArray.get(1).add(10);
        System.out.println("두 번째 행에 10 추가 후:");
        for (int element : dynamicArray.get(1)) {
            System.out.print(element + " ");
        }
        System.out.println();

        // 행 삭제
        dynamicArray.remove(0);
        System.out.println("첫 번째 행 삭제 후:");
        for (ArrayList<Integer> row : dynamicArray) {
            System.out.println(row);
        }
    }
}