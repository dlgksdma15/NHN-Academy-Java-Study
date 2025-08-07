package ch09.ex2;

public class LinkedQueue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T data) {
        // TODO: 큐의 뒤쪽에 요소 추가
        Node<T> newNode = new Node<>(data);

        // 큐가 비어있는 경우
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // 큐가 비어있지 않은 경우
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        // TODO: 큐의 앞쪽에서 요소 제거 및 반환
        // 힌트: front 포인터 활용, 빈 큐 처리
        if (isEmpty()) {
            return null; // 또는 throw new NoSuchElementException();
        }

        T data = front.data;
        front = front.next;
        size--;

        // 큐의 마지막 요소가 제거되었을 경우 rear도 null로 설정
        if (front == null) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("enqueue: 10, 20, 30");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("큐 크기: " + queue.size());

        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());

        System.out.println("enqueue: 40");
        queue.enqueue(40);

        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());

        System.out.println("빈 큐? " + queue.isEmpty());
    }
}