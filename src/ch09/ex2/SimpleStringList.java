package ch09.ex2;

public class SimpleStringList {

    private Node head; // newNode

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 맨 앞에 추가
     */
    public void addFirst(String data) {
        // TODO: 새 노드를 리스트의 맨 앞에 추가
        // 힌트: 새 노드의 next를 현재 head로 설정
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * 맨 뒤에 추가
     */
    public void addLast(String data) {
        // TODO: 새 노드를 리스트의 맨 뒤에 추가
        // 힌트: 빈 리스트와 그렇지 않은 경우를 구분
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;

    }

    /**
     * 특정 항목 검색
     */
    /**
     * 특정 항목 검색
     */
    public boolean contains(String data) {
        // 리스트를 순회하기 위한 러너(runner) 변수
        Node current = head;

        // 러너가 null이 될 때까지 반복
        while (current != null) {
            // 현재 노드의 데이터가 찾고 있는 데이터와 일치하는지 확인
            if (current.data.equals(data)) {
                return true; // 일치하는 데이터를 찾았으므로 true 반환
            }
            // 다음 노드로 이동
            current = current.next;
        }

        // 루프가 끝났는데도 데이터를 찾지 못했으므로 false 반환
        return false;
    }

    /**
     * 첫 번째 항목 제거
     */
    /**
     * 첫 번째 항목 제거
     */
    public String removeFirst() {
        // 1. 리스트가 비어있는 경우
        if (head == null) {
            return null;
        }

        // 2. 제거할 첫 번째 노드의 데이터를 임시 저장
        String removedData = head.data;

        // 3. head를 다음 노드로 이동시켜 첫 번째 노드 제거
        head = head.next;

        // 4. 제거된 노드의 데이터 반환
        return removedData;
    }

    /**
     * 리스트 출력
     */
    /**
     * 리스트 출력
     */
    @Override
    public String toString() {
        // TODO: 리스트를 문자열로 변환 [A, B, C] 형식
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
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
        SimpleStringList list = new SimpleStringList();

        // 실행 결과:
        // 초기 리스트: []
        // A, B 추가 후: [A, B]
        // C를 앞에 추가 후: [C, A, B]
        // D를 뒤에 추가 후: [C, A, B, D]
        // 'B' 포함? true
        // 'Z' 포함? false
        // 첫 번째 제거: C
        // 최종 리스트: [A, B, D]
        System.out.println(list);
        list.addLast("A");
        list.addLast("B");
        System.out.println("A, B 추가 후: " + list);
        list.addFirst("C");
        System.out.println("C를 앞에 추가 후: " + list);
        list.addLast("D");
        System.out.println("D를 뒤에 추가 후: " + list);
        System.out.println("'B'를 포함? " + list.contains("B"));
        System.out.println("'B'를 포함? " + list.contains("Z"));
        System.out.println("첫 번째 제거: " + list.removeFirst());
        System.out.println("최종 리스트: " + list);


    }
}
