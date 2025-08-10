package ch10.ex1;

import java.util.*;

import java.util.*;

public class IteratorExample {

    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("C++");

        // 방법 1: 기본 Iterator
        System.out.println("=== Iterator 사용 ===");
        Iterator<String> iter = languages.iterator();

        // TODO: Iterator를 사용하여 모든 언어 출력
        // TODO: "J"로 시작하는 언어는 삭제
        while (iter.hasNext()) {
            String lang = iter.next();
            System.out.println(lang);
            if (lang.startsWith("J")) {
                iter.remove(); // Iterator의 remove()를 사용하여 안전하게 삭제
            }
        }
        System.out.println("J로 시작하는 언어 삭제 후: " + languages);

        // 방법 2: ListIterator (양방향)
        System.out.println("\n=== ListIterator 사용 ===");
        ListIterator<String> listIter = languages.listIterator();

        // TODO: 앞으로 이동하며 출력
        while (listIter.hasNext()) {
            System.out.println("→ " + listIter.next());
        }

        // TODO: 뒤로 이동하며 출력
        while (listIter.hasPrevious()) {
            System.out.println("← " + listIter.previous());
        }
    }
}