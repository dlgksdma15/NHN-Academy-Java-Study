package ch09.ex2;

public class SortedStringList {

    private Node head;

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    /**
     * 정렬된 순서로 삽입
     */
    public void insert(String data) {
        Node newNode = new Node(data);

        // 1. 빈 리스트이거나 새 노드가 head보다 앞에 와야 하는 경우
        if (head == null || data.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // 2. 중간이나 끝에 삽입하는 경우
        Node current = head;
        while (current.next != null && data.compareTo(current.next.data) > 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    /**
     * 정렬된 리스트에서 효율적 검색
     */
    public boolean containsOptimized(String data) {
        Node current = head;
        while (current != null) {
            int comparison = data.compareTo(current.data);

            // 찾는 값과 동일한 경우
            if (comparison == 0) {
                return true;
            }

            // 찾는 값이 현재 값보다 작으면 더 이상 뒤에 있을 수 없으므로 조기 종료
            if (comparison < 0) {
                return false;
            }

            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node runner = head;

        while (runner != null) {
            sb.append(runner.data);
            if (runner.next != null) {
                sb.append(", ");
            }
            runner = runner.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SortedStringList list = new SortedStringList();

        // 무작위 순서로 삽입
        list.insert("Dog");
        list.insert("Cat");
        list.insert("Elephant");
        list.insert("Bird");
        list.insert("Ant");

        // 실행 결과:
        // 정렬된 리스트: [Ant, Bird, Cat, Dog, Elephant]
        // 'Cat' 검색: true
        // 'Fish' 검색: false

        System.out.println("정렬된 리스트: " + list.toString());
        System.out.println("'Cat' 검색: " + list.containsOptimized("Cat"));
        System.out.println("'Fish' 검색: " + list.containsOptimized("Fish"));
    }
}
