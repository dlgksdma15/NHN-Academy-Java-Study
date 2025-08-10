package ch10.ex2;

import java.util.*;

public class ListManipulationExample {

    public static void main(String[] args) {
        // 1. 섞기 (Shuffle)
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("원본: " + numbers);
        Collections.shuffle(numbers);
        System.out.println("섞기 후: " + numbers);

        // 시드를 사용한 섞기 (재현 가능)
        Collections.shuffle(numbers, new Random(42));
        System.out.println("시드 섞기: " + numbers);

        // 2. 뒤집기 (Reverse)
        Collections.reverse(numbers);
        System.out.println("뒤집기: " + numbers);

        // 3. 회전 (Rotate)
        Collections.rotate(numbers, 3);  // 오른쪽으로 3칸
        System.out.println("회전 +3: " + numbers);

        Collections.rotate(numbers, -2);  // 왼쪽으로 2칸
        System.out.println("회전 -2: " + numbers);

        // 4. 채우기 (Fill)
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Collections.fill(list, "X");
        System.out.println("\n채우기: " + list);

        // 5. 교체 (Replace)
        list = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "A", "D"));
        Collections.replaceAll(list, "A", "Z");
        System.out.println("교체: " + list);

        // 6. 최대/최소값
        List<Integer> scores = Arrays.asList(85, 92, 78, 95, 88, 91);
        System.out.println("\n점수: " + scores);
        System.out.println("최고점: " + Collections.max(scores));
        System.out.println("최저점: " + Collections.min(scores));

        // 7. 빈도수
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "apple", "banana", "date");
        System.out.println("\n단어 목록: " + words);
        System.out.println("apple 개수: " + Collections.frequency(words, "apple"));

        // 8. 부분 리스트 위치 찾기
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 5, 6);
        List<Integer> target = Arrays.asList(3, 4, 5);

        int firstIndex = Collections.indexOfSubList(source, target);
        int lastIndex = Collections.lastIndexOfSubList(source, target);

        System.out.println("\n원본: " + source);
        System.out.println("찾을 패턴: " + target);
        System.out.println("첫 번째 위치: " + firstIndex);
        System.out.println("마지막 위치: " + lastIndex);
    }
}