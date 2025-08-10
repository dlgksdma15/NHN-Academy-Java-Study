package ch10.ex2;

import java.util.*;

public class CollectionsUtilExample {

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + "(" + score + ")";
        }
    }

    public static void main(String[] args) {
        // 1. 기본 정렬
        List<String> fruits = new ArrayList<>(
                Arrays.asList("banana", "apple", "cherry", "date", "elderberry")
        );

        System.out.println("원본: " + fruits);
        Collections.sort(fruits);
        System.out.println("정렬: " + fruits);

        // 2. 역순 정렬
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("역순: " + fruits);

        // 3. 커스텀 정렬
        List<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 85));
        students.add(new Student("이영희", 92));
        students.add(new Student("박민수", 85));
        students.add(new Student("정지원", 88));

        // 점수순 정렬 (높은 점수 우선)
        Collections.sort(students, (s1, s2) -> s2.score - s1.score);
        System.out.println("\n점수순: " + students);

        // 점수 같으면 이름순
        Collections.sort(students, (s1, s2) -> {
            int scoreCompare = Integer.compare(s2.score, s1.score);
            if (scoreCompare != 0) return scoreCompare;
            return s1.name.compareTo(s2.name);
        });
        System.out.println("점수순, 이름순: " + students);

        // 4. 이진 검색 (정렬된 리스트에서)
        Collections.sort(fruits);
        System.out.println("\n정렬된 과일: " + fruits);

        int index = Collections.binarySearch(fruits, "cherry");
        System.out.println("cherry의 위치: " + index);

        // 없는 항목 검색
        index = Collections.binarySearch(fruits, "grape");
        System.out.println("grape의 위치: " + index);
        if (index < 0) {
            int insertPoint = -index - 1;
            System.out.println("grape 삽입 위치: " + insertPoint);
        }
    }
}