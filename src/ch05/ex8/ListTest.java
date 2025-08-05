package ch05.ex8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 간단한 연결 리스트 구현
 */
class SimpleLinkedList<T> {
    private Node head;
    private int size;

    // 노드를 나타내는 내부 클래스
    private class Node {
        T data;
        Node next;

        Node(T data) {
            // TODO 36: data 초기화하고 next를 null로 설정하기
            this.data = data;
            next = null;
        }
    }

    // 반복자를 구현하는 내부 클래스
    public class ListIterator implements Iterator<T> {
        private Node current; // 현재
        private Node previous; // 이전

        public ListIterator() {
            // TODO 37: current를 head로, previous를 null로 초기화하기
            current = head;
            previous = null;
        }

        @Override
        public boolean hasNext() {
            // TODO 38: 다음 요소가 있는지 확인하기
            return false;
        }

        @Override
        public T next() {
            // TODO 39: 다음 요소 반환하기
            // hasNext()가 false면 NoSuchElementException 던지기
            // current의 데이터 저장, previous와 current 업데이트
            if(!hasNext()){
                throw new NoSuchElementException();

            }
            T data = current.data;
            previous = current;
            current = current.next;
            return data;
        }

        // 현재 요소 삭제
        public void remove() {
            // TODO 40
            if (previous == null) {
                // 첫 요소 삭제
                if (head != null) {
                    head = head.next;
                    current = head;
                }
            } else {
                // previous 앞 노드 찾기
                Node temp = head;
                Node prevPrev = null;
                while (temp != null && temp != previous) {
                    prevPrev = temp;
                    temp = temp.next;
                }
                if (prevPrev == null) {
                    head = current; // 두번째 노드부터 시작
                } else {
                    prevPrev.next = current;
                }
            }
            size--;
        }

        // 현재 위치에 삽입
        public void insert(T data) {
            // TODO 41
            Node newNode = new Node(data);
            if (previous == null) {
                // 맨 앞에 삽입
                newNode.next = head;
                head = newNode;
                previous = newNode;
            } else {
                newNode.next = current;
                previous.next = newNode;
                previous = newNode;
            }
            size++;
        }
    }

    public void add(T data) {
        // TODO 42: 리스트 끝에 요소 추가하기
        // 새 노드 생성
        // head가 null이면 head로 설정
        // 아니면 마지막 노드 찾아서 연결
        // size 증가
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while( temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public ListIterator iterator() {
        // TODO 43: 새로운 ListIterator 반환하기
        return new ListIterator();
    }

    public int size() {
        // TODO 44: 리스트 크기 반환하기
        return size;
    }

    @Override
    public String toString() {
        // TODO 45: 리스트를 "[item1, item2, ...]" 형식으로 반환하기
        // StringBuilder 사용
        // 모든 노드 순회하며 데이터 추가
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while(temp != null){
            sb.append(temp.data);
            if(temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();

    }
}

// 테스트
public class ListTest {
    public static void main(String[] args) {
        // TODO 46
        SimpleLinkedList<Object> linkedList = new SimpleLinkedList<>();
        linkedList.add("첫번째");
        linkedList.add("두번째");
        linkedList.add("세번째");

        // TODO 47: 초기 리스트 출력하기
        System.out.println("초기 리스트: " + linkedList);

        // TODO 48: 반복자로 순회하며 "두번째" 뒤에 "새로운" 삽입하기
        SimpleLinkedList<Object>.ListIterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object value = it.next();
            if ("두번째".equals(value)) {
                it.insert("새로운");
            }
        }

        // TODO 49: 수정된 리스트 출력하기
        System.out.println("수정된 리스트: " + linkedList);
    }
}