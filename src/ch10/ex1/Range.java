package ch10.ex1;

import java.util.*;

/**
 * Iterator를 구현하는 커스텀 클래스
 */
public class Range implements Iterable<Integer> {
    private int start;
    private int end;
    private int step;

    public Range(int start, int end) {
        this(start, end, 1);
    }

    public Range(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO: RangeIterator 인스턴스 반환
        return new RangeIterator(); // 임시 반환값
    }

    private class RangeIterator implements Iterator<Integer> {
        private int current = start;

        @Override
        public boolean hasNext() {
            // TODO: 다음 요소가 있는지 확인
            // 힌트: step이 양수면 current < end, 음수면 current > end
            if(step > 0){
                return current < end;
            } else{
                return current > end;
            }
        }

        @Override
        public Integer next() {
            // TODO: 현재 값을 반환하고 current를 step만큼 증가
            // 힌트: hasNext()가 false면 NoSuchElementException 던지기
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int result = current;
            current += step;
            return result; // 임시 반환값
        }
    }

    public static void main(String[] args) {
        System.out.print("Range(0, 10): ");
        for (Integer i : new Range(0, 10)) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Range(10, 0, -1): ");
        for (Integer i : new Range(10, 0, -1)) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Range(0, 21, 2): ");
        for (Integer i : new Range(0, 21, 2)) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 실행 결과:
        // Range(0, 10): 0 1 2 3 4 5 6 7 8 9
        // Range(10, 0, -1): 10 9 8 7 6 5 4 3 2 1
        // Range(0, 21, 2): 0 2 4 6 8 10 12 14 16 18 20
    }
}