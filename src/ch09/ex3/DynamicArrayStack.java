package ch09.ex3;

import java.util.Arrays;

public class DynamicArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int top;

    @SuppressWarnings("unchecked")
    public DynamicArrayStack() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    @SuppressWarnings("unchecked")
    public DynamicArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("초기 용량은 양수여야 합니다");
        }
        items = (T[]) new Object[initialCapacity];
        top = 0;
    }

    /**
     * 스택에 요소 추가
     */
    public void push(T item) {
        if (top == items.length) {
            resize();
        }
        items[top++] = item;
    }

    /**
     * 스택에서 요소 제거 및 반환
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다");
        }

        T item = items[--top];
        items[top] = null;  // 가비지 컬렉션을 위해

        // 배열이 1/4만 사용되면 크기를 반으로 줄임
        if (top > 0 && top == items.length / 4) {
            shrink();
        }

        return item;
    }

    /**
     * 스택의 맨 위 요소 확인
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다");
        }
        return items[top - 1];
    }

    /**
     * 스택이 비어있는지 확인
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 스택의 크기 반환
     */
    public int size() {
        return top;
    }

    /**
     * 배열 크기를 두 배로 증가
     */
    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
        System.out.println("배열 크기 증가: " + items.length);
    }

    /**
     * 배열 크기를 반으로 감소
     */
    private void shrink() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length / 2];
        System.arraycopy(items, 0, newItems, 0, top);
        items = newItems;
        System.out.println("배열 크기 감소: " + items.length);
    }

    /**
     * 현재 용량 반환
     */
    public int capacity() {
        return items.length;
    }

    /**
     * 스택의 모든 요소를 배열로 반환
     */
    public Object[] toArray() {
        return Arrays.copyOf(items, top);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(items[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== 동적 배열 스택 테스트 ===");

        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>(2);

        // 크기 증가 테스트
        System.out.println("초기 용량: " + stack.capacity());

        for (int i = 1; i <= 5; i++) {
            stack.push(i * 10);
            System.out.println("Push " + (i * 10) + " - 크기: " + stack.size() +
                    ", 용량: " + stack.capacity());
        }

        System.out.println("\n스택: " + stack);

        // 크기 감소 테스트
        while (!stack.isEmpty()) {
            System.out.println("Pop " + stack.pop() + " - 크기: " + stack.size() +
                    ", 용량: " + stack.capacity());
        }
    }
}