package ch09.ex2;

public class RemoveDuplicates {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 정렬된 리스트에서 중복 제거
     */
    public static void removeDuplicatesSorted(Node head) {
        // 리스트가 비어있거나 노드가 하나일 경우 중복이 없으므로 종료
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        while (current.next != null) {
            // 현재 노드와 다음 노드의 데이터가 같으면
            if (current.data == current.next.data) {
                // 다음 노드를 건너뛰어 중복된 노드 제거
                current.next = current.next.next;
            } else {
                // 데이터가 다르면 다음 노드로 이동
                current = current.next;
            }
        }
    }

    /**
     * 정렬되지 않은 리스트에서 중복 제거
     */
    public static void removeDuplicatesUnsorted(Node head) {
        // 리스트가 비어있거나 노드가 하나일 경우 중복이 없으므로 종료
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node runner = current;
            // current 노드 이후의 모든 노드를 순회하며 중복 검사
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    // 중복된 노드를 발견하면 건너뛰어 제거
                    runner.next = runner.next.next;
                } else {
                    // 중복이 아니면 다음 노드로 이동
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 정렬된 리스트: 1 → 1 → 2 → 3 → 3 → 3 → 4
        Node sorted = new Node(1);
        sorted.next = new Node(1);
        sorted.next.next = new Node(2);
        sorted.next.next.next = new Node(3);
        sorted.next.next.next.next = new Node(3);
        sorted.next.next.next.next.next = new Node(3);
        sorted.next.next.next.next.next.next = new Node(4);

        System.out.print("정렬된 리스트 원본: ");
        printList(sorted);
        removeDuplicatesSorted(sorted);
        System.out.print("중복 제거 후: ");
        printList(sorted);

        System.out.println();

        // 정렬되지 않은 리스트: 3 → 1 → 4 → 1 → 3 → 2
        Node unsorted = new Node(3);
        unsorted.next = new Node(1);
        unsorted.next.next = new Node(4);
        unsorted.next.next.next = new Node(1);
        unsorted.next.next.next.next = new Node(3);
        unsorted.next.next.next.next.next = new Node(2);

        System.out.print("정렬되지 않은 리스트 원본: ");
        printList(unsorted);
        removeDuplicatesUnsorted(unsorted);
        System.out.print("중복 제거 후: ");
        printList(unsorted);
    }
}