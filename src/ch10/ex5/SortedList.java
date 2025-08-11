package ch10.ex5;

import java.util.*;

public class SortedList<T extends Comparable<T>> {
    private List<T> items;

    public SortedList() {
        this.items = new ArrayList<>();
    }

    // 요소를 정렬된 위치에 삽입
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("null 값은 추가할 수 없습니다");
        }

        int insertIndex = findInsertionPoint(item);
        items.add(insertIndex, item);
    }

    // 이진 탐색으로 삽입 위치 찾기
    private int findInsertionPoint(T item) {
        int left = 0;
        int right = items.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (items.get(mid).compareTo(item) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // 여러 요소 추가
    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    // 특정 요소 제거
    public boolean remove(T item) {
        return items.remove(item);
    }

    // 인덱스로 요소 제거
    public T remove(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("인덱스: " + index);
        }
        return items.remove(index);
    }

    // 특정 요소 포함 여부 확인
    public boolean contains(T item) {
        return binarySearch(item) >= 0;
    }

    // 이진 탐색
    public int indexOf(T item) {
        int index = binarySearch(item);
        return index >= 0 ? index : -1;
    }

    private int binarySearch(T item) {
        int left = 0;
        int right = items.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = items.get(mid).compareTo(item);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // 특정 범위의 요소들 가져오기
    public List<T> subList(T fromElement, T toElement) {
        List<T> result = new ArrayList<>();

        for (T item : items) {
            if (item.compareTo(fromElement) >= 0 && item.compareTo(toElement) <= 0) {
                result.add(item);
            }
        }

        return result;
    }

    // 첫 번째와 마지막 요소
    public T first() {
        if (items.isEmpty()) {
            throw new NoSuchElementException("리스트가 비어있습니다");
        }
        return items.get(0);
    }

    public T last() {
        if (items.isEmpty()) {
            throw new NoSuchElementException("리스트가 비어있습니다");
        }
        return items.get(items.size() - 1);
    }

    // 크기와 빈 상태 확인
    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 모든 요소 제거
    public void clear() {
        items.clear();
    }

    // 복사본 만들기
    public SortedList<T> copy() {
        SortedList<T> newList = new SortedList<>();
        newList.items = new ArrayList<>(this.items);
        return newList;
    }

    // Iterator 제공
    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public String toString() {
        return items.toString();
    }

    public static void main(String[] args) {
        // String 테스트
        SortedList<String> words = new SortedList<>();
        words.add("banana");
        words.add("apple");
        words.add("cherry");
        words.add("date");

        System.out.println("문자열 리스트: " + words);
        System.out.println("'cherry' 인덱스: " + words.indexOf("cherry"));
        System.out.println("'apple' 포함? " + words.contains("apple"));

        // 범위 검색
        List<String> range = words.subList("banana", "date");
        System.out.println("'banana'~'date' 범위: " + range);

        // Integer 테스트
        SortedList<Integer> numbers = new SortedList<>();
        numbers.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));

        System.out.println("\n정수 리스트: " + numbers);
        System.out.println("첫 번째: " + numbers.first());
        System.out.println("마지막: " + numbers.last());

        // 범위 검색
        List<Integer> numberRange = numbers.subList(3, 8);
        System.out.println("3~8 범위: " + numberRange);

        // 제거 테스트
        numbers.remove(Integer.valueOf(5));
        System.out.println("5 제거 후: " + numbers);

        // 반복자 테스트
//        System.out.print("반복자로 출력: ");
//        for (Integer num : numbers) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

        // 복사 테스트
        SortedList<Integer> copied = numbers.copy();
        copied.add(10);
        System.out.println("원본: " + numbers);
        System.out.println("복사본: " + copied);
    }
}