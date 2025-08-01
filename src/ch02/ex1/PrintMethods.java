package ch02.ex1;

public class PrintMethods {
    public static void main(String[] args) {
        // TODO: print와 println의 차이를 보여주는 코드를 작성하세요
        // 힌트:
        // 1. println을 사용하여 세 줄을 각각 출력:
        //    - "첫 번째 줄"
        //    - "두 번째 줄"
        //    - "세 번째 줄"
        // 2. 빈 줄 출력 (println만 호출)
        // 3. print를 사용하여 한 줄에 출력:
        //    - "하나 ", "둘 ", "셋" (각각 print로)
        //    - 마지막에 println()으로 줄바꿈
        // 4. print와 println 혼합:
        //    - "이름: " (print)와 "홍길동" (println)
        //    - "나이: " (print)와 25 (println)

        // 여기에 코드를 작성하세요
        System.out.println("첫 번째 줄");
        System.out.println("두 번째 줄");
        System.out.println("세 번째 줄");
        System.out.println();
        System.out.print("하나");
        System.out.print(" 둘");
        System.out.println(" 셋");
        System.out.print("이름: ");
        System.out.println("홍길동");
        System.out.print("나이: ");
        System.out.println(25);
    }
}