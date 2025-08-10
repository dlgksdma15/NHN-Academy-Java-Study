package ch10.ex2;

import java.util.*;

public class PriorityQueueBasic {

    public static void main(String[] args) {
        // 1. 기본 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] values = {5, 2, 8, 1, 9, 3, 7};

        for (int val : values) {
            minHeap.offer(val);
        }

        System.out.println("최소 힙 (작은 값 우선):");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // 2. 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : values) {
            maxHeap.offer(val);
        }

        System.out.println("\n최대 힙 (큰 값 우선):");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();

        // 3. 문자열 우선순위
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.addAll(Arrays.asList("Charlie", "Alice", "Bob", "David"));

        System.out.println("\n문자열 (사전순):");
        while (!stringQueue.isEmpty()) {
            System.out.print(stringQueue.poll() + " ");
        }
        System.out.println();
    }
}