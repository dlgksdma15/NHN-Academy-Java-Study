package ch10.ex5;

import java.util.*;
import java.util.function.*;

public class GenericCollectionUtils {

    // 컬렉션에서 특정 요소 개수 세기
    public static <T> int countOccurrences(Collection<T> collection, T target) {
        if (collection == null) {
            return 0;
        }

        int count = 0;
        for (T item : collection) {
            if (Objects.equals(item, target)) {
                count++;
            }
        }
        return count;
    }

    // 두 컬렉션의 교집합
    public static <T> Set<T> intersection(Collection<T> col1, Collection<T> col2) {
        Set<T> result = new HashSet<>();

        if (col1 == null || col2 == null) {
            return result;
        }

        for (T item : col1) {
            if (col2.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 두 컬렉션의 합집합
    public static <T> Set<T> union(Collection<T> col1, Collection<T> col2) {
        Set<T> result = new HashSet<>();

        if (col1 != null) {
            result.addAll(col1);
        }
        if (col2 != null) {
            result.addAll(col2);
        }

        return result;
    }

    // 두 컬렉션의 차집합 (col1 - col2)
    public static <T> Set<T> difference(Collection<T> col1, Collection<T> col2) {
        Set<T> result = new HashSet<>();

        if (col1 == null) {
            return result;
        }

        for (T item : col1) {
            if (col2 == null || !col2.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 컬렉션 변환
    public static <T, R> List<R> map(Collection<T> collection, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();

        if (collection == null || mapper == null) {
            return result;
        }

        for (T item : collection) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    // 컬렉션 필터링
    public static <T> List<T> filter(Collection<T> collection, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        if (collection == null || predicate == null) {
            return result;
        }

        for (T item : collection) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 조건에 맞는 첫 번째 요소 찾기
    public static <T> Optional<T> findFirst(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null || predicate == null) {
            return Optional.empty();
        }

        for (T item : collection) {
            if (predicate.test(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    // 모든 요소가 조건을 만족하는지 확인
    public static <T> boolean allMatch(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null || predicate == null) {
            return false;
        }

        for (T item : collection) {
            if (!predicate.test(item)) {
                return false;
            }
        }
        return true;
    }

    // 하나라도 조건을 만족하는지 확인
    public static <T> boolean anyMatch(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null || predicate == null) {
            return false;
        }

        for (T item : collection) {
            if (predicate.test(item)) {
                return true;
            }
        }
        return false;
    }

    // 컬렉션을 그룹핑
    public static <T, K> Map<K, List<T>> groupBy(Collection<T> collection, Function<T, K> keyExtractor) {
        Map<K, List<T>> result = new HashMap<>();

        if (collection == null || keyExtractor == null) {
            return result;
        }

        for (T item : collection) {
            K key = keyExtractor.apply(item);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }

        return result;
    }

    public static void main(String[] args) {
        // 테스트 데이터
        List<String> list1 = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> list2 = Arrays.asList("banana", "cherry", "elderberry", "fig");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        // 집합 연산
        System.out.println("\n=== 집합 연산 ===");
        System.out.println("교집합: " + intersection(list1, list2));
        System.out.println("합집합: " + union(list1, list2));
        System.out.println("차집합 (list1 - list2): " + difference(list1, list2));

        // 변환과 필터링
        System.out.println("\n=== 변환과 필터링 ===");
        List<String> upperCase = map(list1, String::toUpperCase);
        System.out.println("대문자 변환: " + upperCase);

        List<String> longWords = filter(list1, word -> word.length() > 5);
        System.out.println("6글자 이상: " + longWords);

        // 검색
        Optional<String> firstLongWord = findFirst(list1, word -> word.length() > 5);
        System.out.println("첫 번째 긴 단어: " + firstLongWord.orElse("없음"));

        // 조건 확인
        System.out.println("\n=== 조건 확인 ===");
        boolean allLong = allMatch(list1, word -> word.length() > 3);
        System.out.println("모든 단어가 4글자 이상? " + allLong);

        boolean anyLong = anyMatch(list1, word -> word.length() > 6);
        System.out.println("7글자 이상 단어 있나? " + anyLong);

        // 그룹핑
        System.out.println("\n=== 그룹핑 ===");
        Map<Integer, List<String>> wordsByLength = groupBy(list1, String::length);
        System.out.println("길이별 그룹핑: " + wordsByLength);

        // 숫자 테스트
        System.out.println("\n=== 숫자 테스트 ===");
        System.out.println("숫자: " + numbers);

        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("짝수: " + evenNumbers);

        List<String> numberStrings = map(numbers, Object::toString);
        System.out.println("문자열로 변환: " + numberStrings);

        Map<Boolean, List<Integer>> evenOddGroups = groupBy(numbers, n -> n % 2 == 0);
        System.out.println("짝수/홀수 그룹: " + evenOddGroups);
    }
}