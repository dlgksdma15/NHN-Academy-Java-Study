package ch02.ex4;

public class StringFormatting {
    public static void main(String[] args) {
        // TODO: 문자열 서식을 사용하여 테이블 형태로 출력하세요
        String[] names = {"김철수", "이영희", "박민수", "최서연"};
        int[] ages = {25, 30, 28, 22};
        double[] scores = {85.5, 92.3, 78.9, 95.7};

        // 헤더 출력
        System.out.println("=== 학생 명단 ===");
        System.out.printf("%-10s %-5s %-5s\n", "이름", "나이", "점수");

        // 구분선
        System.out.println("-".repeat(28));

        // 반복문으로 학생 정보 출력
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-10s %-5d %-5.1f\n", names[i], ages[i], scores[i]);
        }

        // 문자열 정렬 예제
        System.out.println("\n=== 정렬 예제 ===");
        System.out.println("기본: 'Java Programming'");
        System.out.printf("20자 오른쪽 정렬: '%20s'\n", "Java Programming");
        System.out.printf("20자 왼쪽 정렬:   '%-20s'\n", "Java Programming");
    }
}
