package ch04.ex6;

// TODO 19: System.out과 System.err 정적 import하기
import static java.lang.System.out;
import static java.lang.System.err;

public class StaticImportSystem {
    public static void main(String[] args) {
        // TODO 20: System. 없이 출력하기
        out.println("일반 메시지");
        out.print("연속 ");
        out.println("출력");

        // TODO 21: 에러 스트림 사용하기
        err.println("에러 메시지!");

        // TODO 22: printf 사용하기
        out.printf("포맷된 출력: %d + %d = %d%n", 3, 4, 3 + 4);
    }
}
