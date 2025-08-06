package ch07.ex2;

import java.util.Arrays;

public class GenericDynamicArray<T> {
    private Object[] items;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public GenericDynamicArray() {
        items = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // 요소 추가
    public void add(T item) {
        ensureCapacity();
        items[size++] = item;
    }

    // 특정 위치 삽입
    public void insert(int index, T item) {
        checkIndexForInsert(index);
        ensureCapacity();

        // 뒤로 이동
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
    }

    // 요소 가져오기
    public T get(int index) {
        checkIndex(index);
        return (T) items[index];
    }

    // 요소 설정
    public void set(int index, T item) {
        checkIndex(index);
        items[index] = item;
    }

    // 요소 제거
    public T remove(int index) {
        checkIndex(index);
        T removed = (T) items[index];

        // 앞으로 이동
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[--size] = null; // 마지막 요소 null 처리

        // 1/4 미만이면 배열 축소
        if (size > 0 && size < items.length / 4) {
            resize(items.length / 2);
        }

        return removed;
    }

    // 크기 반환
    public int size() {
        return size;
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 모든 요소 제거
    public void clear() {
        Arrays.fill(items, 0, size, null);
        size = 0;
    }

    // 용량 확보
    public void ensureCapacity() {
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    // 크기 조정
    public void resize(int newCapacity) {
        items = Arrays.copyOf(items, newCapacity);
        System.out.println("배열 크기 조정: " + newCapacity);
    }

    // 인덱스 검사 (조회/수정/삭제용)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과: " + index);
        }
    }

    // 인덱스 검사 (삽입용)
    private void checkIndexForInsert(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("삽입 인덱스 범위 초과: " + index);
        }
    }

    // toString
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // 테스트
    public static void main(String[] args) {
        // 문자열 동적 배열
        GenericDynamicArray<String> strings = new GenericDynamicArray<>();

        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        System.out.println("문자열 배열: " + strings);

        strings.insert(1, "Beautiful");
        System.out.println("삽입 후: " + strings);

        strings.remove(2);
        System.out.println("제거 후: " + strings);

        // 정수 동적 배열
        GenericDynamicArray<Integer> numbers = new GenericDynamicArray<>();

        for (int i = 1; i <= 15; i++) {
            numbers.add(i * i);  // 제곱수 추가
        }
        System.out.println("\n정수 배열: " + numbers);

        System.out.println("5번째 요소: " + numbers.get(4));
        numbers.set(4, 999);
        System.out.println("수정 후: " + numbers);
    }
}
