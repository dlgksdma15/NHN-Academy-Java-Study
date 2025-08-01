package ch03.ex5;

import textio.TextIO;

import java.util.Arrays;

public class SortThreeNumbers {
    public static void main(String[] args) {
        System.out.println("세 개의 숫자를 입력하면 오름차순으로 정렬합니다.");

        System.out.print("첫 번째 숫자: ");
        int x = TextIO.getlnInt();
        System.out.print("두 번째 숫자: ");
        int y = TextIO.getlnInt();
        System.out.print("세 번째 숫자: ");
        int z = TextIO.getlnInt();

        System.out.print("\n정렬 결과: ");

        int[] arr = new int[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;

        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n최솟값: " + arr[0]);
        System.out.println("최댓값: " + arr[2]);
        int result = arr[2] - arr[0];
        System.out.println("범위: " + result);
    }
}