package ch09.ex3;

public class CircularArrayQueue<T> {

    private T[] items;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("용량은 양수여야 합니다");
        }
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * 큐에 요소 추가
     */
    public void enqueue(T item) {
        if (size == items.length) {
            throw new IllegalStateException("큐가 가득 찼습니다");
        }

        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }

    /**
     * 큐에서 요소 제거 및 반환
     */
    public T dequeue() {
        // TODO 1: 큐가 비어있는지 확인하고 예외 처리
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다");
        }

        // TODO 2: front 위치의 요소를 임시 변수에 저장
        T data = items[front];

        // TODO 3: front 위치를 null로 설정 (가비지 컬렉션을 위해)
        items[front] = null;

        // TODO 4: front를 원형 배열 방식으로 증가시키기
        // 힌트: (front + 1) % items.length
        front = (front + 1) % items.length;

        // TODO 5: size 감소
        size--;

        // TODO 6: 저장한 요소 반환
        return data;
    }

    /**
     * 큐의 앞쪽 요소 확인
     */
    public T peek() {
        // TODO 1: 큐가 비어있는지 확인하고 예외 처리
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다");
        }

        // TODO 2: front 위치의 요소 반환
        return items[front];
    }

    /**
     * 큐가 비어있는지 확인
     */
    public boolean isEmpty() {
        // TODO: size가 0인지 확인
        return size == 0;
    }

    /**
     * 큐가 가득 찼는지 확인
     */
    public boolean isFull() {
        // TODO: size가 배열의 길이와 같은지 확인
        return size == items.length;
    }

    /**
     * 큐의 크기 반환
     */
    public int size() {
        return size;
    }

    /**
     * 큐의 용량 반환
     */
    public int capacity() {
        return items.length;
    }

    /**
     * 큐의 상태를 시각적으로 표시
     */
    public void displayStatus() {
        System.out.println("\n=== 큐 상태 ===");
        System.out.print("배열: [");

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i]);
            } else {
                System.out.print("_");
            }

            if (i == front && i == rear) {
                System.out.print("(F,R)");
            } else if (i == front) {
                System.out.print("(F)");
            } else if (i == rear) {
                System.out.print("(R)");
            }

            if (i < items.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        System.out.println("Front: " + front + ", Rear: " + rear + ", Size: " + size);
    }

    public static void main(String[] args) {
        System.out.println("=== 원형 배열 큐 테스트 ===");

        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(5);

        // 큐 연산 테스트
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.displayStatus();

        System.out.println("\nDequeue: " + queue.dequeue());
        queue.displayStatus();

        queue.enqueue(4);
        queue.enqueue(5);
        queue.displayStatus();

        // 원형 특성 테스트
        queue.enqueue(6);
        queue.displayStatus();

        System.out.println("\nDequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.displayStatus();

        queue.enqueue(7);
        queue.enqueue(8);
        queue.displayStatus();
    }
}