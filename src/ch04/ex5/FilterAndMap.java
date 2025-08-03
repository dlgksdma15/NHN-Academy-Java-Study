package ch04.ex5;

import java.util.*;

interface Filter<T> {
    boolean accept(T item);
}

interface Mapper<T, R> {
    R map(T item);
}

public class FilterAndMap {
    public static void main(String[] args) {
        System.out.println("=== 필터링과 변환 예제 ===\n");

        // 정수 리스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO 52: 짝수 필터링하기
        List<Integer> evens = filter(numbers, n -> n % 2 ==0);
        System.out.println("짝수: " + evens);

        // TODO 53: 5보다 큰 수 필터링하기
        List<Integer> greaterThan5 = filter(numbers, n -> n > 5);
        System.out.println("5보다 큰 수: " + greaterThan5);

        // TODO 54: 제곱 변환하기
        List<Integer> squares = map(numbers, n -> n * n);
        System.out.println("제곱: " + squares);

        // 문자열 리스트
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        // TODO 55: 길이가 5 이상인 단어 필터링하기
        List<String> longWords = filter(words, s -> s.length() >= 5);
        System.out.println("긴 단어: " + longWords);

        // TODO 56: 대문자로 변환하기
        List<String> upperWords = map(words, String::toUpperCase);
        System.out.println("대문자: " + upperWords);
    }

    // TODO 57: filter 메서드 구현하기
    static <T> List<T> filter(List<T> list, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item: list) {
            if(filter.accept(item)){
                result.add(item);
            }
        }
        return result;
    }

    // TODO 58: map 메서드 구현하기
    static <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.map(item));
        }
        return result;
    }
}