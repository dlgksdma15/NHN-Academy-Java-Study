package ch10.ex5;

import java.util.*;

public class GenericQueue<T> {
    private LinkedList<T> items;

    public GenericQueue() {
        items = new LinkedList<>();
    }

    // 큐에 요소 추가 (enqueue)
    public void enqueue(T item) {
        // TODO 1: items 리스트의 마지막에 item 추가

    }

    // 큐에서 요소 제거 (dequeue)
    public T dequeue() {
        // TODO 2: 큐가 비어있으면 NoSuchElementException 던지기
        // TODO 3: items 리스트의 첫 번째 요소를 제거하고 반환

        return null; // 임시 반환값
    }

    // 큐의 첫 번째 요소 확인 (peek)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("큐가 비어있습니다");
        }
        return items.getFirst();
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 큐의 크기
    public int size() {
        return items.size();
    }

    // 모든 요소를 다른 컬렉션에 추가
    public void addAll(Collection<? extends T> collection) {
        // TODO 4: collection의 모든 요소를 순회하며 enqueue 호출

    }

    // 큐의 모든 요소를 다른 컬렉션으로 이동
    public void drainTo(Collection<? super T> collection) {
        // TODO 5: 큐가 비어있지 않은 동안 반복
        // TODO 6: dequeue()로 요소를 제거하고 collection에 추가

    }

    @Override
    public String toString() {
        return "Queue" + items.toString();
    }

    public static void main(String[] args) {
        // String 큐 테스트
        GenericQueue<String> stringQueue = new GenericQueue<>();
        stringQueue.enqueue("첫 번째");
        stringQueue.enqueue("두 번째");
        stringQueue.enqueue("세 번째");

        System.out.println("String 큐: " + stringQueue);
        System.out.println("Dequeue: " + stringQueue.dequeue());
        System.out.println("Peek: " + stringQueue.peek());

        // Integer 큐 테스트
        GenericQueue<Integer> intQueue = new GenericQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        System.out.println("\nInteger 큐: " + intQueue);
        System.out.println("크기: " + intQueue.size());

        // 컬렉션 추가 테스트
        List<Integer> numbers = Arrays.asList(40, 50, 60);
        intQueue.addAll(numbers);
        System.out.println("addAll 후: " + intQueue);

        // 다른 컬렉션으로 이동
        List<Integer> result = new ArrayList<>();
        intQueue.drainTo(result);
        System.out.println("drainTo 결과: " + result);
        System.out.println("큐 상태: " + intQueue);
    }
}