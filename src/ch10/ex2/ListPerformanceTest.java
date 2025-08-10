package ch10.ex2;

import java.util.*;

public class ListPerformanceTest {

    public static void main(String[] args) {
        int size = 100000;

        // ArrayList 테스트
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("=== 성능 비교 (요소 수: " + size + ") ===\n");

        // 1. 끝에 추가
        System.out.println("1. 끝에 추가:");
        long startTime = System.nanoTime();
        // TODO: ArrayList에 0부터 size-1까지 추가

        long arrayAddEnd = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        // TODO: LinkedList에 0부터 size-1까지 추가

        long linkedAddEnd = System.nanoTime() - startTime;

        System.out.printf("ArrayList: %.2f ms%n", arrayAddEnd / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedAddEnd / 1_000_000.0);

        // 2. 처음에 추가
        System.out.println("\n2. 처음에 추가 (1000개):");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();

        startTime = System.nanoTime();
        // TODO: ArrayList의 맨 앞(인덱스 0)에 1000개 요소 추가

        long arrayAddFirst = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        // TODO: LinkedList의 맨 앞에 1000개 요소 추가 (addFirst 사용)

        long linkedAddFirst = System.nanoTime() - startTime;

        System.out.printf("ArrayList: %.2f ms%n", arrayAddFirst / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedAddFirst / 1_000_000.0);

        // 3. 임의 접근
        System.out.println("\n3. 임의 접근 (10000번):");
        Random rand = new Random();

        startTime = System.nanoTime();
        // TODO: ArrayList에서 무작위 인덱스로 10000번 접근

        long arrayGet = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        // TODO: LinkedList에서 무작위 인덱스로 10000번 접근

        long linkedGet = System.nanoTime() - startTime;

        System.out.printf("ArrayList: %.2f ms%n", arrayGet / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedGet / 1_000_000.0);

        // 4. 중간 삭제
        System.out.println("\n4. 중간 삭제 (100개):");
        ArrayList<Integer> arrayList3 = new ArrayList<>(arrayList);
        LinkedList<Integer> linkedList3 = new LinkedList<>(linkedList);

        startTime = System.nanoTime();
        // TODO: ArrayList의 중간 요소 100개 삭제

        long arrayRemoveMid = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        ListIterator<Integer> iter = linkedList3.listIterator(linkedList3.size() / 2);
        // TODO: LinkedList에서 Iterator를 사용하여 100개 요소 삭제

        long linkedRemoveMid = System.nanoTime() - startTime;

        System.out.printf("ArrayList: %.2f ms%n", arrayRemoveMid / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedRemoveMid / 1_000_000.0);

        // 실행 결과:
        // === 성능 비교 (요소 수: 100000) ===
        //
        // 1. 끝에 추가:
        // ArrayList: XX.XX ms
        // LinkedList: XX.XX ms
        //
        // 2. 처음에 추가 (1000개):
        // ArrayList: XX.XX ms (느림)
        // LinkedList: X.XX ms (빠름)
        //
        // 3. 임의 접근 (10000번):
        // ArrayList: X.XX ms (빠름)
        // LinkedList: XXX.XX ms (느림)
        //
        // 4. 중간 삭제 (100개):
        // ArrayList: XX.XX ms
        // LinkedList: X.XX ms
    }
}
