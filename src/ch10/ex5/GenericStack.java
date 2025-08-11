package ch10.ex5;

import java.util.*;

public class GenericStack<T> {
    private ArrayList<T> items;

    public GenericStack() {
        items = new ArrayList<>();
    }

    public GenericStack(int initialCapacity) {
        items = new ArrayList<>(initialCapacity);
    }

    // 스택에 요소 추가 (push)
    public void push(T item) {
        items.add(item);
    }

    // 스택에서 요소 제거 (pop)
    public T pop() {
        // TODO 7: 스택이 비어있으면 EmptyStackException 던지기
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // TODO 8: items 리스트의 마지막 요소를 제거하고 반환
        // 힌트: items.size() - 1이 마지막 인덱스
        return items.remove(items.size() - 1);
    }

    // 스택의 최상위 요소 확인 (peek)
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 스택의 크기
    public int size() {
        return items.size();
    }

    // 특정 요소 검색 (인덱스 반환)
    public int search(T item) {
        // TODO 9: item이 null인 경우 처리
        // - 스택 끝에서부터 시작하여 null을 찾으면 1-based 인덱스 반환
        if (item == null) {
            for (int i = items.size() - 1; i >= 0; i--) {
                if (items.get(i) == null) {
                    return items.size() - i;
                }
            }
        } else {
            // TODO 10: item이 null이 아닌 경우 처리
            // - 스택 끝에서부터 시작하여 equals로 비교
            // - 찾으면 1-based 인덱스 반환 (items.size() - i)
            for (int i = items.size() - 1; i >= 0; i--) {
                if (item.equals(items.get(i))) {
                    return items.size() - i;
                }
            }
        }

        // TODO 11: 찾지 못하면 -1 반환
        return -1;
    }

    // 스택 복사
    public GenericStack<T> copy() {
        GenericStack<T> newStack = new GenericStack<>();
        newStack.items = new ArrayList<>(this.items);
        return newStack;
    }

    @Override
    public String toString() {
        return "Stack" + items.toString();
    }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();

        // 요소 추가
        stack.push("bottom");
        stack.push("middle");
        stack.push("top");

        System.out.println("스택: " + stack);
        System.out.println("크기: " + stack.size());

        // peek과 pop
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("스택: " + stack);

        // 검색
        System.out.println("'middle' 위치: " + stack.search("middle"));
        System.out.println("'bottom' 위치: " + stack.search("bottom"));
        System.out.println("'없음' 위치: " + stack.search("없음"));

        // 스택 복사
        GenericStack<String> copied = stack.copy();
        System.out.println("복사된 스택: " + copied);
    }
}