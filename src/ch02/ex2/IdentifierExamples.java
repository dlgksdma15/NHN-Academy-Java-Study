package ch02.ex2;

public class IdentifierExamples {
    public static void main(String[] args) {
        // TODO: 유효한 식별자 예제를 작성하세요
        int age = 25;
        double _temperature = 36.5;
        String firstName = "John";
        boolean isStudent = true;
        char $currency = '$';

        // 힌트:
        int count = 10;
        int Count = 20;
        int COUNT = 30;
        // 4. 세 변수를 모두 출력하여 차이를 보여주세요
        System.out.println("count = " + count);
        System.out.println("Count = " + Count);
        System.out.println("COUNT = " + COUNT);

        // 주의: 아래는 무효한 식별자 예제입니다 (주석 처리됨)
        // int 3rdPlace = 3;        // 오류: 숫자로 시작
        // double my-score = 95.5;  // 오류: 하이픈 사용
        // String first name = "";  // 오류: 공백 포함
        // boolean class = true;    // 오류: 예약어 사용
    }
}