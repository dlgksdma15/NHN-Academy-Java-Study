package ch10.ex3;

import java.util.*;

public class CustomKeyExample {

    // 잘못된 예 - equals/hashCode 재정의 안 함
    static class BadKey {
        String name;
        int id;

        BadKey(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }

    // 올바른 예 - equals/hashCode 재정의
    static class GoodKey {
        String name;
        int id;

        GoodKey(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof GoodKey)) return false;
            GoodKey other = (GoodKey) obj;
            return id == other.id &&
                    Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }

    public static void main(String[] args) {
        // BadKey 사용 - 문제 발생
        System.out.println("=== BadKey 사용 ===");
        Map<BadKey, String> badMap = new HashMap<>();

        BadKey bad1 = new BadKey("Alice", 1);
        BadKey bad2 = new BadKey("Alice", 1);  // 같은 내용

        badMap.put(bad1, "첫 번째");
        System.out.println("bad1으로 조회: " + badMap.get(bad1));
        System.out.println("bad2으로 조회: " + badMap.get(bad2));  // null!
        System.out.println("bad1 == bad2? " + (bad1 == bad2));
        System.out.println("bad1.equals(bad2)? " + bad1.equals(bad2));

        // GoodKey 사용 - 정상 작동
        System.out.println("\n=== GoodKey 사용 ===");
        Map<GoodKey, String> goodMap = new HashMap<>();

        GoodKey good1 = new GoodKey("Alice", 1);
        GoodKey good2 = new GoodKey("Alice", 1);  // 같은 내용

        goodMap.put(good1, "첫 번째");
        System.out.println("good1으로 조회: " + goodMap.get(good1));
        System.out.println("good2으로 조회: " + goodMap.get(good2));  // 정상!
        System.out.println("good1 == good2? " + (good1 == good2));
        System.out.println("good1.equals(good2)? " + good1.equals(good2));
        System.out.println("good1.hashCode() == good2.hashCode()? " +
                (good1.hashCode() == good2.hashCode()));
    }
}