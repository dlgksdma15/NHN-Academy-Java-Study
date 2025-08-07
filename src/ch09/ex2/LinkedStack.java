package ch09.ex2;

public class LinkedStack<T> {

    private Node<T> top;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        // TODO: 스택의 맨 위에 요소 추가
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        // TODO: 스택의 맨 위 요소 제거 및 반환
        // 힌트: 빈 스택 처리
        if (isEmpty()) {
            return null; // 또는 throw new EmptyStackException();
        }

        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        // TODO: 스택의 맨 위 요소 확인 (제거하지 않음)
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();

        System.out.println("push: 첫번째, 두번째, 세번째");
        stack.push("첫번째");
        stack.push("두번째");
        stack.push("세번째");

        System.out.println("스택 크기: " + stack.size());
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("빈 스택? " + stack.isEmpty());
    }
}