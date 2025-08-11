package ch09.ex3;

public class LinkedQueue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;  // 큐의 앞쪽
    private Node<T> rear;   // 큐의 뒤쪽
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * 큐의 뒤쪽에 요소 추가
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (rear == null) {
            // 큐가 비어있는 경우
            front = rear = newNode;
        } else {
            // 큐에 요소가 있는 경우
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    /**
     * 큐의 앞쪽에서 요소 제거 및 반환
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다");
        }

        T data = front.data;
        front = front.next;

        if (front == null) {
            // 큐가 비게 된 경우
            rear = null;
        }

        size--;
        return data;
    }

    /**
     * 큐의 앞쪽 요소 확인
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다");
        }
        return front.data;
    }

    /**
     * 큐가 비어있는지 확인
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * 큐의 크기 반환
     */
    public int size() {
        return size;
    }

    /**
     * 큐의 모든 요소 제거
     */
    public void clear() {
        front = rear = null;
        size = 0;
    }

    /**
     * 큐에 특정 요소가 있는지 확인
     */
    public boolean contains(T item) {
        Node<T> current = front;

        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== 연결 리스트 큐 테스트 ===");

        LinkedQueue<String> queue = new LinkedQueue<>();

        // 큐 연산 테스트
        queue.enqueue("첫번째");
        queue.enqueue("두번째");
        queue.enqueue("세번째");

        System.out.println("큐: " + queue);
        System.out.println("크기: " + queue.size());

        System.out.println("\nDequeue: " + queue.dequeue());
        System.out.println("큐: " + queue);

        queue.enqueue("네번째");
        System.out.println("\n네번째 추가 후: " + queue);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Contains '세번째': " + queue.contains("세번째"));

        // 모든 요소 제거
        System.out.println("\n모든 요소 제거:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}