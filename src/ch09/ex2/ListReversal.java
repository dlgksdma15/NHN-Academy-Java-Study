package ch09.ex2;

public class ListReversal {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    /**
     * 리스트 뒤집기 (반복)
     */
    public static Node reverseIterative(Node head) {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;       // 1. 다음 노드를 미리 저장
            current.next = previous;   // 2. 현재 노드의 next를 이전 노드로 변경 (뒤집기)
            previous = current;        // 3. previous를 한 칸 앞으로 이동
            current = next;            // 4. current를 한 칸 앞으로 이동
        }

        return previous; // 뒤집힌 리스트의 새로운 head인 previous를 반환
    }

    /**
     * 리스트 뒤집기 (재귀)
     */
    public static Node reverseRecursive(Node head) {
        // 1. 기저 사례: 리스트가 비었거나 노드가 하나일 경우
        if (head == null || head.next == null) {
            return head;
        }

        // 2. 재귀 사례: 나머지 리스트를 먼저 뒤집음
        Node newHead = reverseRecursive(head.next);

        // 3. 현재 노드를 뒤집힌 리스트의 끝에 연결
        head.next.next = head;
        head.next = null;

        return newHead; // 새로운 head를 반환
    }

    // 유틸리티 메서드
    public static void printList(String label, Node head) {
        System.out.print(label + ": ");
        Node runner = head;

        while (runner != null) {
            System.out.print(runner.data);
            if (runner.next != null) {
                System.out.print(" → ");
            }
            runner = runner.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 리스트 생성: A → B → C → D
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");

        printList("원본", head);

        // 반복문으로 뒤집기
        Node reversedIterative = reverseIterative(head);
        printList("반복 뒤집기", reversedIterative);

        // 재귀로 뒤집기 (원본 리스트는 이미 뒤집혔으므로, 다시 원본을 만들어야 함)
        head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");
        Node reversedRecursive = reverseRecursive(head);
        printList("재귀 뒤집기", reversedRecursive);
    }
}
