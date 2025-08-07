package ch09.ex2;

public class LinkedListTraversalExample {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    /**
     * while 루프를 사용한 순회
     */
    public static void traverseWithWhile(Node head) {
        Node runner = head;
        int position = 0;
        while (runner != null) {
            System.out.println("[" + position + "] " + runner.data);
            runner = runner.next;
            position++;
        }
    }

    /**
     * 재귀를 사용한 순회
     */
    public static void traverseRecursive(Node head, int position) {
        // 기저 사례: head가 null이면 재귀를 멈춤
        if (head == null) {
            return;
        }

        System.out.println("[" + position + "] " + head.data);

        // 재귀 호출: 다음 노드로 이동하고 position을 1 증가시킴
        traverseRecursive(head.next, position + 1);
    }

    /**
     * 역순 출력 (재귀)
     */
    public static void printReversed(Node head) {
        // 기저 사례: head가 null이면 재귀를 멈춤
        if (head == null) {
            return;
        }

        // 재귀 호출을 먼저 해서 리스트의 끝까지 이동
        printReversed(head.next);

        // 마지막 노드부터 거꾸로 출력
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        // 연결 리스트 생성
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");

        System.out.println("=== While 루프 순회 ===");
        traverseWithWhile(head);

        System.out.println("\n=== 재귀 순회 ===");
        traverseRecursive(head, 0);

        System.out.println("\n=== 역순 출력 ===");
        printReversed(head);
    }
}
