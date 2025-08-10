package ch10.ex2;

import java.util.*;

public class HashSetExample {

    public static void main(String[] args) {
        // 1. 중복 제거
        List<String> listWithDuplicates = Arrays.asList(
                "apple", "banana", "apple", "cherry", "banana", "date"
        );

        // TODO: listWithDuplicates에서 중복을 제거하여 HashSet 생성
        Set<String> uniqueItems = new HashSet<>(listWithDuplicates);

        System.out.println("원본 리스트: " + listWithDuplicates);
        System.out.println("중복 제거: " + uniqueItems);

        // 2. 집합 연산
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // 합집합
        Set<Integer> union = new HashSet<>(setA);
        // TODO: setB의 모든 요소를 union에 추가 (addAll 사용)
        union.addAll(setB);

        System.out.println("\nA ∪ B = " + union);

        // 교집합
        Set<Integer> intersection = new HashSet<>(setA);
        // TODO: setA와 setB의 교집합 구하기 (retainAll 사용)
        intersection.retainAll(setB);

        System.out.println("A ∩ B = " + intersection);

        // 차집합
        Set<Integer> difference = new HashSet<>(setA);
        // TODO: setA에서 setB의 요소들을 제거 (removeAll 사용)
        difference.removeAll(setB);

        System.out.println("A - B = " + difference);

        // 대칭 차집합 (A ∪ B) - (A ∩ B)
        Set<Integer> symmetricDiff = new HashSet<>(setA);
        // TODO: 대칭 차집합 구하기
        // 힌트:
        // 1. symmetricDiff에 setB 추가 (addAll)
        // 2. temp에 setA와 setB의 교집합 저장
        // 3. symmetricDiff에서 temp 제거 (removeAll)
        symmetricDiff.addAll(setB);
        Set<Integer> temp = new HashSet<>(setA);
        temp.retainAll(setB);
        symmetricDiff.removeAll(temp);

        System.out.println("A △ B = " + symmetricDiff);

        // 3. 포함 관계 확인
        Set<String> fruits = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        Set<String> subset = new HashSet<>(Arrays.asList("apple", "cherry"));

        System.out.println("\nfruits: " + fruits);
        System.out.println("subset: " + subset);
        // TODO: subset이 fruits의 부분집합인지 확인 (containsAll 사용)
        boolean isSubsetOf = fruits.containsAll(subset);
        System.out.println("subset ⊆ fruits? " + isSubsetOf);

        // TODO: fruits가 subset의 부분집합인지 확인
        boolean isSupersetOf = subset.containsAll(fruits);
        System.out.println("fruits ⊆ subset? " + isSupersetOf);
    }
}