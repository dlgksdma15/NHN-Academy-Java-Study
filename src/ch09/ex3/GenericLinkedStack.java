package ch09.ex3;

public class GenericLinkedStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    private int size;

    public GenericLinkedStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * 스택의 맨 위에 요소 추가
     */
    public void push(T item) {
        // TODO: 새 노드를 생성하고 스택의 맨 위에 추가
        // 힌트:
        // 1. 새 노드를 생성
        // 2. 새 노드의 next를 현재 top으로 설정
        // 3. top을 새 노드로 변경
        // 4. size 증가
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * 스택의 맨 위 요소 제거 및 반환
     */
    public T pop() {
        // TODO: 스택의 맨 위 요소를 제거하고 반환
        // 힌트:
        // 1. 비어있는지 확인 (isEmpty() 사용)
        // 2. top의 데이터 저장
        // 3. top을 다음 노드로 이동
        // 4. size 감소
        // 5. 저장한 데이터 반환

        return null; // 임시 반환값
    }

    /**
     * 스택의 맨 위 요소 확인 (제거하지 않음)
     */
    public T peek() {
        // TODO: 스택의 맨 위 요소를 제거하지 않고 반환
        // 힌트: 비어있는지 확인 후 top.data 반환

        return null; // 임시 반환값
    }

    /**
     * 스택이 비어있는지 확인
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 스택의 크기 반환
     */
    public int size() {
        return size;
    }

    /**
     * 스택의 모든 요소 제거
     */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * 스택의 내용을 문자열로 반환
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;

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
        System.out.println("=== 제네릭 연결 스택 테스트 ===");

        // 정수 스택
        GenericLinkedStack<Integer> intStack = new GenericLinkedStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println(intStack);

        System.out.println("정수 스택: " + intStack);
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Peek: " + intStack.peek());
        System.out.println("크기: " + intStack.size());

        // 문자열 스택
        GenericLinkedStack<String> stringStack = new GenericLinkedStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");

        System.out.println("\n문자열 스택: " + stringStack);

        while (!stringStack.isEmpty()) {
            System.out.println("Pop: " + stringStack.pop());
        }
    }
}