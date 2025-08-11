package ch10.ex5;

import java.util.*;

public class Pair<T, S> {
    private T first;
    private S second;

    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    // Getter와 Setter
    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    // 값 교환
    public Pair<S, T> swap() {
        // TODO 12: 순서가 바뀐 새 Pair 객체 생성하여 반환
        // 힌트: 제네릭 타입도 바뀌어야 함 (T, S) -> (S, T)
        return new Pair<>(second, first);
    }

    // 첫 번째와 두 번째가 같은지 비교
    public boolean isEqual() {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        return first.equals(second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // 정적 팩토리 메서드
    public static <T, S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }

    public static void main(String[] args) {
        // 다양한 타입 조합
        Pair<String, Integer> nameAge = new Pair<>("김철수", 25);
        Pair<Double, Double> coordinates = new Pair<>(3.14, 2.71);
        Pair<String, String> keyValue = new Pair<>("name", "홍길동");

        System.out.println("이름-나이: " + nameAge);
        System.out.println("좌표: " + coordinates);
        System.out.println("키-값: " + keyValue);

        // 값 교환
        Pair<Integer, String> swapped = nameAge.swap();
        System.out.println("교환된 값: " + swapped);

        // 같은 값인지 확인
        System.out.println("keyValue 같은 값? " + keyValue.isEqual());

        Pair<String, String> same = new Pair<>("test", "test");
        System.out.println("same 같은 값? " + same.isEqual());

        // 정적 메서드 사용
        Pair<Integer, Boolean> numFlag = Pair.of(42, true);
        System.out.println("정적 생성: " + numFlag);

        // 컬렉션에서 사용
        List<Pair<String, Integer>> scores = Arrays.asList(
                Pair.of("Alice", 95),
                Pair.of("Bob", 87),
                Pair.of("Charlie", 92)
        );

        System.out.println("\n점수 목록:");
        for (Pair<String, Integer> score : scores) {
            System.out.println(score.getFirst() + ": " + score.getSecond() + "점");
        }
    }
}