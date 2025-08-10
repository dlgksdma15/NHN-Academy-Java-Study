package ch10.ex2;

import java.util.*;

public class TreeSetExample {

    public static void main(String[] args) {
        // 1. 자동 정렬
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.addAll(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));

        System.out.println("TreeSet (자동 정렬): " + numbers);

        // 2. NavigableSet 메서드
        System.out.println("\n=== NavigableSet 메서드 ===");
        System.out.println("첫 번째: " + numbers.first());
        System.out.println("마지막: " + numbers.last());
        System.out.println("5보다 작은 가장 큰 수: " + numbers.lower(5));
        System.out.println("5 이하 가장 큰 수: " + numbers.floor(5));
        System.out.println("5보다 큰 가장 작은 수: " + numbers.higher(5));
        System.out.println("5 이상 가장 작은 수: " + numbers.ceiling(5));

        // 3. 부분 집합
        System.out.println("\n=== 부분 집합 ===");
        SortedSet<Integer> subset = numbers.subSet(3, 7);  // 3 이상, 7 미만
        System.out.println("subSet(3, 7): " + subset);

        SortedSet<Integer> headSet = numbers.headSet(5);  // 5 미만
        System.out.println("headSet(5): " + headSet);

        SortedSet<Integer> tailSet = numbers.tailSet(5);  // 5 이상
        System.out.println("tailSet(5): " + tailSet);

        // 4. 역순 뷰
        NavigableSet<Integer> descending = numbers.descendingSet();
        System.out.println("역순: " + descending);

        // 5. 커스텀 정렬
        TreeSet<String> words = new TreeSet<>(Comparator.reverseOrder());
        words.addAll(Arrays.asList("apple", "banana", "cherry", "date"));
        System.out.println("\n역순 정렬된 단어: " + words);

        // 6. 커스텀 객체
        TreeSet<Person> people = new TreeSet<>((p1, p2) -> {
            int ageCompare = Integer.compare(p1.age, p2.age);
            if (ageCompare != 0) return ageCompare;
            return p1.name.compareTo(p2.name);
        });

        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 25));
        people.add(new Person("David", 20));

        System.out.println("\n나이순 정렬:");
        for (Person p : people) {
            System.out.println(p);
        }
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}