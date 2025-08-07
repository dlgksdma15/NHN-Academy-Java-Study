package ch09.ex2;

public class MergeLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 두 정렬된 리스트 병합
     */
    public static Node mergeSortedLists(Node head1, Node head2) {
        // 1. 더미 노드를 사용하여 새로운 리스트의 시작점을 쉽게 관리
        Node dummyHead = new Node(0);
        Node current = dummyHead;

        Node p1 = head1;
        Node p2 = head2;

        // 2. 두 리스트를 동시에 순회하며 작은 값을 선택
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        // 3. 남은 노드들을 모두 연결
        if (p1 != null) {
            current.next = p1;
        } else if (p2 != null) {
            current.next = p2;
        }

        return dummyHead.next;
    }

    public static void printList(String label, Node head) {
        System.out.print(label + ": ");
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
        // 리스트1: 1 → 3 → 5 → 7
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(7);

        // 리스트2: 2 → 4 → 6 → 8
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(8);

        System.out.print("리스트1");
        printList("리스트1", list1);
        System.out.print("리스트2");
        printList("리스트2", list2);

        Node mergedList = mergeSortedLists(list1, list2);
        System.out.print("병합 결과");
        printList("병합 결과", mergedList);
    }
}