package ch02.ex2;

public class CommonErrors {
    public static void main(String[] args) {
        // TODO: 오류 1 수정 - 변수를 초기화하고 출력하세요
        int count = 0;
        System.out.println(count);

        // TODO: 오류 2 수정 - 올바른 타입 사용
        double number = 3.14;
        int intNumber = (int) 3.14;

        // TODO: 오류 3 수정 - 적절한 타입 사용
        short bigShort = 200;
        byte smallByte = (byte) 200;

        // TODO: 오류 4 수정 - 문자와 문자열 구분
        char initial = 'A';
        String initialString = "A";

        // TODO: 오류 5 수정 - 예약어 피하기
        int classNumber = 10;

        // TODO: "모든 오류가 수정되었습니다!" 출력
        System.out.println("모든 오류가 수정되었습니다!");
    }
}
