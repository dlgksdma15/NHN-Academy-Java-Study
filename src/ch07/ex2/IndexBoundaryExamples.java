package ch07.ex2;

public class IndexBoundaryExamples {
    public static void main(String[] args) {
        // 예제 배열
        String[] words = {"apple", "banana", "banana", "cherry", "cherry", "cherry"};

        // ❌ 잘못된 방법: 예외 발생 확인
        try {
            for (int i = 0; i < words.length; i++) {  // 의도적으로 오류 발생
                if (words[i].equals(words[i + 1])) {  // 마지막에서 i+1 접근 시 예외
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }

        // ✅ 올바른 방법: 중복 찾기
        boolean hasDuplicate = false;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(words[i + 1])) {
                hasDuplicate = true;
                System.out.println("중복 발견: " + words[i] + " (인덱스 " + i + ", " + (i + 1) + ")");
            }
        }

        if (!hasDuplicate) {
            System.out.println("연속된 중복이 없습니다.");
        }
    }
}
