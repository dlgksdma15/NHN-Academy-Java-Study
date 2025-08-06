package ch07.ex7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueRandomGenerator {

    // 중복 없는 랜덤 수 생성 메서드
    public static ArrayList<Integer> generateUniqueRandoms(int count, int maxValue) {
        if (count > maxValue) {
            throw new IllegalArgumentException("count는 maxValue보다 클 수 없습니다.");
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= maxValue; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, count));
    }

    // ArrayList 출력 메서드
    public static void printList(ArrayList<Integer> list, String title) {
        System.out.println(title + ":");
        System.out.println(list);
        System.out.println("총 " + list.size() + "개의 숫자");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 중복 없는 랜덤 수 생성기 ===");

        try {
            System.out.print("생성할 랜덤 수의 개수: ");
            int count = scanner.nextInt();

            System.out.print("최대값 (1부터 이 값까지): ");
            int maxValue = scanner.nextInt();

            if (count <= 0 || maxValue <= 0) {
                System.out.println("양수를 입력해주세요.");
                return;
            }

            long startTime = System.nanoTime();
            ArrayList<Integer> randomNumbers = generateUniqueRandoms(count, maxValue);
            long endTime = System.nanoTime();

            printList(randomNumbers, "생성된 중복 없는 랜덤 수들");

            double executionTime = (endTime - startTime) / 1_000_000.0;
            System.out.printf("실행 시간: %.2f ms\n", executionTime);

            // 중복 검증
            boolean hasDuplicates = new HashSet<>(randomNumbers).size() != randomNumbers.size();

            System.out.println("중복 검증: " + (hasDuplicates ? "실패" : "성공"));

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("입력 오류: 정수를 입력해주세요.");
        }

        scanner.close();
    }
}
