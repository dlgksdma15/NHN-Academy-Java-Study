package ch09.ex6;

public class ListReversal {

    static class ListNode {
        int item;
        ListNode next;

        ListNode(int item) {
            this.item = item;
        }
    }

    /**
     * 리스트를 뒤집어서 복사 (재귀적 방법)
     */
    public static ListNode reverseRecursive(ListNode head) {
        // TODO 1: 기본 경우 - head가 null 또는 head.next가 null이면
        //         copyNode(head) 반환
        if (head == null || head.next == null) {
            return copyNode(head);
        }

        // TODO 2: head.next부터 뒤집기 (재귀 호출)
        ListNode reversedRest = reverseRecursive(head.next);

        // TODO 3: 현재 노드를 복사하여 뒤집힌 리스트의 끝에 추가
        appendToEnd(reversedRest, copyNode(head));

        // TODO 4: 뒤집힌 리스트 반환
        return reversedRest;
    }

    /**
     * 리스트를 뒤집어서 복사 (반복적 방법)
     */
    public static ListNode reverseIterative(ListNode head) {
        // TODO 1: reversed를 null로 초기화
        ListNode reversed = null;
        // TODO 2: current를 head로 초기화
        ListNode current = head;

        // TODO 3: current가 null이 아닌 동안 반복:
        while (current != null) {
            //   - 현재 노드의 값으로 새 노드 생성
            ListNode newNode = new ListNode(current.item);
            //   - 새 노드의 next를 reversed로 설정 (앞에 추가)
            newNode.next = reversed;
            //   - reversed를 새 노드로 업데이트
            reversed = newNode;
            //   - current를 다음 노드로 이동
            current = current.next;
        }

        // TODO 4: reversed 반환
        return reversed;
    }

    /**
     * 더 효율적인 재귀적 뒤집기
     */
    public static ListNode reverseEfficient(ListNode head) {
        return reverseHelper(head, null);
    }

    private static ListNode reverseHelper(ListNode current, ListNode reversed) {
        // TODO 1: 기본 경우 - current가 null이면 reversed 반환
        if (current == null) {
            return reversed;
        }

        // TODO 2: 현재 노드의 값으로 새 노드 생성
        ListNode newNode = new ListNode(current.item);
        // TODO 3: 새 노드의 next를 reversed로 설정
        newNode.next = reversed;

        // TODO 4: current.next와 새 노드로 재귀 호출
        return reverseHelper(current.next, newNode);
    }

    // 헬퍼 메서드들
    private static ListNode copyNode(ListNode node) {
        if (node == null) return null;
        return new ListNode(node.item);
    }

    private static void appendToEnd(ListNode head, ListNode node) {
        if (head == null) return;

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    /**
     * 리스트 생성
     */
    public static ListNode createList(int... values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * 리스트 출력
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.item);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 테스트 리스트 생성
        ListNode original = createList(1, 2, 3, 4, 5);

        System.out.println("원본 리스트:");
        printList(original);

        // 재귀적 뒤집기
        ListNode reversed1 = reverseRecursive(original);
        System.out.println("\n재귀적 뒤집기:");
        printList(reversed1);

        // 반복적 뒤집기
        ListNode reversed2 = reverseIterative(original);
        System.out.println("\n반복적 뒤집기:");
        printList(reversed2);

        // 효율적인 재귀적 뒤집기
        ListNode reversed3 = reverseEfficient(original);
        System.out.println("\n효율적인 재귀적 뒤집기:");
        printList(reversed3);

        // 원본이 변경되지 않았는지 확인
        System.out.println("\n원본 리스트 (변경되지 않음):");
        printList(original);
    }
}