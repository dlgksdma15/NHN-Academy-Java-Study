package ch10.ex2;

import java.util.*;

public class TopKElements {

    // K개의 가장 큰 요소 찾기
    public static List<Integer> findTopK(int[] nums, int k) {
        // 최소 힙 사용 (크기 K 유지)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // TODO: 배열의 각 요소를 힙에 추가하고 크기 K 유지
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 결과를 리스트로 변환 (내림차순)
        List<Integer> result = new ArrayList<>(minHeap);
        // TODO: result를 내림차순으로 정렬
        Collections.sort(result, Collections.reverseOrder());

        return result;
    }

    // K번째로 큰 요소 찾기
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // TODO: 최소 힙을 사용하여 K번째로 큰 요소 찾기
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // 빈도수 기준 Top-K
    public static List<String> topKFrequent(String[] words, int k) {
        // 단어 빈도수 계산
        Map<String, Integer> count = new HashMap<>();
        // TODO: words 배열의 각 단어의 빈도수를 count Map에 저장
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // 최소 힙 (빈도수 기준, 같으면 사전순)
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            // TODO: 빈도수 기준 비교, 같으면 사전역순
            if (freq1 != freq2) {
                return freq1 - freq2; // 빈도수 오름차순
            }
            return w2.compareTo(w1); // 사전역순
        });

        // TODO: count의 모든 단어를 heap에 추가하고 크기 k 유지
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 결과 정렬
        List<String> result = new ArrayList<>(heap);
        // TODO: result를 빈도수 내림차순, 같으면 사전순으로 정렬
        result.sort((w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            if (freq1 != freq2) {
                return freq2 - freq1; // 빈도수 내림차순
            }
            return w1.compareTo(w2); // 사전순
        });

        return result;
    }

    public static void main(String[] args) {
        // Top-K 테스트
        int[] nums = {3, 2, 1, 5, 6, 4, 8, 7, 9};
        System.out.println("배열: " + Arrays.toString(nums));
        System.out.println("Top 3: " + findTopK(nums, 3));
        System.out.println("3번째로 큰 수: " + findKthLargest(nums, 3));

        // 빈도수 Top-K
        String[] words = {"apple", "banana", "apple", "cherry", "banana",
                "apple", "date", "banana", "cherry", "elderberry"};
        System.out.println("\n단어 배열: " + Arrays.toString(words));
        System.out.println("가장 빈번한 3개: " + topKFrequent(words, 3));
    }
}