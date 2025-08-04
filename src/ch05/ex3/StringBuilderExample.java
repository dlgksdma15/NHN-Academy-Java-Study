package ch05.ex3;

import java.util.Random;

/**
 * StringBuilder를 활용한 효율적인 문자열 처리 예제
 */
public class StringBuilderExample {

    // TODO 1: 비효율적인 방법 - String 연결 메서드 구현하기
    public static String createStringInefficient(int count) {
        // String result = ""로 시작
        // 반복문으로 i + " "를 result에 추가 (+ 연산자 사용)
        // result 반환
        String result = "";
        for(int i = 0; i < count; i++){
            result += i + " ";
        }
        return result;
    }

    // TODO 2: 효율적인 방법 - StringBuilder 사용 메서드 구현하기
    public static String createStringEfficient(int count) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < count; i++){
            builder.append(i).append(" ");
        }
        String string = builder.toString();
        // 반복문으로 builder.append(i).append(" ") 호출
        // builder.toString() 반환

        return string;
    }

    // TODO 3: HTML 테이블 생성 메서드 구현하기
    public static String createHtmlTable(String[][] data) {
        // StringBuilder html 생성
        StringBuilder builder = new StringBuilder();
        System.out.println("=== 생성된 HTML 테이블 ===");
        System.out.println("<table border='1'>");
        for(int i = 0; i < data.length;i++){
            System.out.println("\t<tr>");

            for(int j = 0; j < data[0].length; j++){
                System.out.printf("\t\t<td>%s<td>\n",data[i][j]);
            }
            System.out.println("\t<\\tr>");

        }
        System.out.println("<\\table>");

        return "";
    }

    // 성능 비교 테스트
    public static void performanceTest() {
        int count = 10000;

        long start1 = System.currentTimeMillis();
        createStringInefficient(count);
        long end1 = System.currentTimeMillis();
        long inefficientTime = end1 - start1;

        long start2 = System.currentTimeMillis();
        createStringEfficient(count);
        long end2 = System.currentTimeMillis();
        long efficientTime = end2 - start2;

        System.out.println("\n=== 성능 비교 (반복 " + count + "회) ===");
        System.out.println("String 연결: " + inefficientTime + "ms");
        System.out.println("StringBuilder: " + efficientTime + "ms");
        if (efficientTime > 0) {
            System.out.println("성능 향상: " + (inefficientTime / efficientTime) + "배");
        } else {
            System.out.println("성능 향상: 매우 빠름 (0ms)");
        }
    }


    // TODO 5: 사용 예제 완성하기
    public static void main(String[] args) {
        System.out.println("=== StringBuilder 사용 예제 ===\n");

        // TODO 6: StringBuilder 기본 사용법 테스트하기
        // StringBuilder로 "Hello" 생성
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" ").append("World").append("!");
        System.out.println(sb);
        // " ", "World", "!" 순서대로 append
        // 결과 출력

        // TODO 7: HTML 테이블 생성 테스트하기
        // tableData 배열 선언 (이름, 나이, 직업 데이터)
        String[][] tableDate = {{"이름", "나이", "직업"}
                ,{"김철수","25","프로그래머"}
                ,{"박민수","23","기획자"}};
        createHtmlTable(tableDate);
        // createHtmlTable() 호출하고 결과 출력

        // TODO 8: 성능 테스트 실행하기
        // performanceTest() 호출
        performanceTest();
    }
}