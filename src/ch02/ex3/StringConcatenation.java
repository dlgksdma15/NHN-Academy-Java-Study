package ch02.ex3;

public class StringConcatenation {
    public static void main(String[] args) {
        // TODO: 기본 문자열 연결을 수행하세요
        // 힌트:
        // 1. firstName = "홍", lastName = "길동"
        // 2. fullName = firstName + lastName
        // 3. 전체 이름 출력

        // TODO: 다양한 타입과 문자열을 연결하세요
        // 힌트:
        // 1. age = 25, height = 175.5, isStudent = true
        // 2. info 문자열에 모든 정보를 연결하여 저장
        // 3. info 출력

        // TODO: 숫자 계산과 문자열 연산의 차이를 보여주세요
        // 힌트:
        // 1. "\n문자열과 숫자 연산:" 출력
        // 2. "10 + 20 = " + 10 + 20 출력 (결과: "10 + 20 = 1020")
        // 3. "10 + 20 = " + (10 + 20) 출력 (결과: "10 + 20 = 30")

        // TODO: StringBuilder를 사용하여 효율적인 문자열 연결을 수행하세요
        // 힌트:
        // 1. StringBuilder sb = new StringBuilder()
        // 2. append로 "오늘은 ", 2024, "년 ", 11, "월입니다." 추가
        // 3. sb.toString() 결과 출력

        // TODO: String.format을 사용하여 포맷팅된 문자열을 만드세요
        // 힌트:
        // String.format("이름: %s, 나이: %d, 키: %.1fcm", fullName, age, height)
        // 포맷팅 결과 출력

        // 여기에 코드를 작성하세요
        String firstName = "홍", lastName = "길동";
        String fullName = firstName + lastName;
        System.out.println(fullName);

        int age = 25;
        double height = 175.5;
        boolean isStudent = true;

        Object[] info = {age,height,isStudent};

        for (Object object : info) {
            System.out.println(object + " ");
        }

        System.out.println("\n문자열과 숫자 연산:");
        System.out.println("10 + 20 = " + 10 + 20);
        System.out.println("10 + 20 = " + (10 + 20));

        StringBuilder sb = new StringBuilder();
        sb.append("오늘은 ");
        sb.append(2024);
        sb.append("년 ");
        sb.append(11);
        sb.append("월입니다.");
        System.out.println(sb.toString());

        String format = String.format("이름: %s, 나이: %d, 키: %.1fcm", fullName, age, height);
        System.out.println(format);
    }
}