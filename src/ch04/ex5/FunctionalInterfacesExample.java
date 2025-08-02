package ch04.ex5;

// 함수형 인터페이스들 (이미 구현됨)
interface Function<T, R> {
    R apply(T t);
    // Integer apply(Integer t);
    // Integer apply(String s);
}

interface Consumer<T> {
    void accept(T t);
}

interface Supplier<T> {
    T get();
}

interface Predicate<T> {
    boolean test(T t);
}

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        System.out.println("=== 함수형 인터페이스 예제 ===\n");

        // TODO 10: Function 예제 구현하기
        Function<Integer, Integer> square = x -> x * x;
        Function<String, Integer> length = s -> s.length();
        System.out.println("5의 제곱: " + square.apply(5));
        System.out.println("\"Hello \"의 길이: " + length.apply("Hello"));

        // TODO 11: Consumer 예제 구현하기
        Consumer<String> printer = s -> System.out.println("출력: " + s);
        Consumer<Integer> doubler = n -> System.out.println(n + "의 2배는 " + n * 2);
        printer.accept("Hello Lambda!");
        doubler.accept(7);

        // TODO 12: Supplier 예제 구현하기
        Supplier<Double> random = () -> Math.random();
        Supplier<String> greeting = () -> "안녕하세요!";
        System.out.println("난수: " + random.get());
        System.out.println("인사: " + greeting.get());

        // TODO 13: Predicate 예제 구현하기
        Predicate<Integer> isPositive = n -> n > 0 ? true : false;
        Predicate<String> isEmpty = n -> n.isEmpty();
        System.out.println("10은 양수인가? " + isPositive.test(10));
        System.out.println("\"\"은 비어있는가? " + isEmpty.test(""));
    }
}
