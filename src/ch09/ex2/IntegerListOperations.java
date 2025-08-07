package ch09.ex2;

public class IntegerListOperations {

    static class IntNode {
        int value;
        IntNode next;

        IntNode(int value) {
            this.value = value;
        }
    }

    /**
     * 리스트의 합계 계산
     */
    public static int sum(IntNode head) {
        // TODO: 리스트의 모든 값을 합산
        int total = 0;
        IntNode current = head;
        while(current != null){
            total += current.value;
            current = current.next;
        }

        return total; // 임시 반환값
    }

    /**
     * 최대값 찾기
     */
    public static int findMax(IntNode head) {
        // TODO: 리스트에서 최대값 찾기
        // 힌트: 빈 리스트 처리 주의
        int max = 0;
        IntNode currnet = head;
        while(currnet != null){
            if(currnet.value > max){
                max = currnet.value;
            }
            currnet = currnet.next;
        }
        return max; // 임시 반환값
    }

    /**
     * 짝수만 카운트
     */
    public static int countEvens(IntNode head) {
        // TODO: 짝수인 노드의 개수 카운트
        IntNode current = head;
        int count = 0;
        while(current != null){
            if(current.value % 2 == 0){
                count++;
            }
            current = current.next;
        }
        return count; // 임시 반환값
    }

    public static void main(String[] args) {
        // 정수 리스트 생성: 3 → 7 → 2 → 9 → 4 → 6
        IntNode head = new IntNode(3);
        head.next = new IntNode(7); // x001.next= x002;
        head.next.next = new IntNode(2);//x001.next.next = x003;
        head.next.next.next = new IntNode(9);
        head.next.next.next.next = new IntNode(4);
        head.next.next.next.next.next = new IntNode(6);
        // 실행 결과:
        // 리스트: 3 → 7 → 2 → 9 → 4 → 6
        // 합계: 31
        // 최대값: 9
        // 짝수 개수: 3
        System.out.println("실행 결과:");
        IntNode currnet = head;
        while(currnet != null){
            System.out.print(currnet.value);
            if(currnet.next != null){
                System.out.print("->");
            }
            currnet = currnet.next;

        }
        System.out.println();
        System.out.println("합계: " + sum(head));
        System.out.println("최댓값: " + findMax(head));
        System.out.println("짝수 개수: " + countEvens(head));


    }
}
