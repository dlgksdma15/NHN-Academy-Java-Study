package ch10.ex5;

import java.util.*;
import java.util.function.Predicate;

public class GenericArrayUtils {

    // 배열에서 특정 요소 찾기
    public static <T> int indexOf(T[] array, T target) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], target)) {
                return i;
            }
        }
        return -1;
    }

    // 배열에서 특정 요소의 개수 세기
    public static <T> int countOccurrences(T[] array, T target) {
        if (array == null) {
            return 0;
        }

        int count = 0;
        for (T item : array) {
            if (Objects.equals(item, target)) {
                count++;
            }
        }
        return count;
    }

    // 배열 뒤집기
    public static <T> void reverse(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // TODO 24: 왼쪽과 오른쪽 인덱스 초기화
        int left = 0;
        int right = array.length - 1;

        // TODO 25: left < right인 동안 반복
        while (left < right) {
            // - 왼쪽과 오른쪽 요소를 교환
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            // - left 증가, right 감소
            left++;
            right--;
        }
    }

    // 배열에서 조건에 맞는 첫 번째 요소 찾기
    public static <T> T findFirst(T[] array, Predicate<T> predicate) {
        if (array == null || predicate == null) {
            return null;
        }

        for (T item : array) {
            if (predicate.test(item)) {
                return item;
            }
        }
        return null;
    }

    // 배열에서 조건에 맞는 모든 요소 필터링
    public static <T> List<T> filter(T[] array, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        if (array == null || predicate == null) {
            return result;
        }

        // TODO 26: 배열의 각 요소에 대해
        for (T item : array) {
            // - predicate.test()가 true인 경우만
            if (predicate.test(item)) {
                // - result 리스트에 추가
                result.add(item);
            }
        }

        return result;
    }

    // 두 배열 합치기
    @SafeVarargs
    public static <T> List<T> concat(T[]... arrays) {
        List<T> result = new ArrayList<>();

        for (T[] array : arrays) {
            if (array != null) {
                Collections.addAll(result, array);
            }
        }
        return result;
    }

    // 배열을 문자열로 변환 (구분자 사용)
    public static <T> String join(T[] array, String delimiter) {
        if (array == null || array.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            sb.append(delimiter).append(array[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // String 배열 테스트
        String[] words = {"apple", "banana", "cherry", "banana", "date"};

        System.out.println("원본 배열: " + Arrays.toString(words));
        System.out.println("'banana' 인덱스: " + indexOf(words, "banana"));
        System.out.println("'banana' 개수: " + countOccurrences(words, "banana"));

        // 배열 뒤집기
        String[] wordsCopy = words.clone();
        reverse(wordsCopy);
        System.out.println("뒤집힌 배열: " + Arrays.toString(wordsCopy));

        // 조건 검색
        String longWord = findFirst(words, word -> word.length() > 5);
        System.out.println("6글자 이상 첫 단어: " + longWord);

        // 필터링
        List<String> shortWords = filter(words, word -> word.length() <= 5);
        System.out.println("5글자 이하 단어들: " + shortWords);

        // 배열 합치기
        String[] fruits = {"apple", "banana"};
        String[] vegetables = {"carrot", "broccoli"};
        List<String> combined = concat(fruits, vegetables);
        System.out.println("합친 결과: " + combined);

        // 문자열 연결
        String joined = join(words, ", ");
        System.out.println("연결된 문자열: " + joined);

        // Integer 배열 테스트
        Integer[] numbers = {1, 2, 3, 2, 4, 5, 2};
        System.out.println("\n숫자 배열: " + Arrays.toString(numbers));
        System.out.println("2의 개수: " + countOccurrences(numbers, 2));

        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("짝수들: " + evenNumbers);
    }
}