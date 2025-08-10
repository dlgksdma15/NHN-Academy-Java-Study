package ch10.ex1;

import java.util.*;

public class HashSetExample {

    public static void main(String[] args) {
        // 중복 제거를 위한 Set
        HashSet<String> uniqueWords = new HashSet<>();

        String text = "the quick brown fox jumps over the lazy dog the fox";
        String[] words = text.split(" ");

        // TODO: words 배열의 각 단어를 uniqueWords에 추가
        for(int i = 0; i < words.length; i++){
            uniqueWords.add(words[i]);
        }
        // 집합 연산
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println("고유한 단어들: " + uniqueWords);
        System.out.println("고유한 단어 수 :" + uniqueWords.size());

        // TODO: set1과 set2의 합집합 구하기
        set1.addAll(set2);
        System.out.println("합집합: " + set1);

        // TODO: set1과 set2의 교집합 구하기
        set1.contains(set2);
        set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        set1.retainAll(set2);
        System.out.println("교집합: " + set1);

        // TODO: set1 - set2 차집합 구하기
        set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        set1.removeAll(set2);
        System.out.println("차집합 (set1 - set2): " + set1);


        // 실행 결과:
        // 고유한 단어들: [over, lazy, the, brown, quick, jumps, dog, fox]
        // 고유한 단어 수: 8
        // 합집합: [1, 2, 3, 4, 5, 6, 7, 8]
        // 교집합: [4, 5]
        // 차집합 (set1 - set2): [1, 2, 3]
    }
}