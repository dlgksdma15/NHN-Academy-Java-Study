package ch03.ex3;

public class CounterLoop {
    public static void main(String[] args) {
        // 1부터 10까지 출력
        System.out.println("=== 1부터 10까지 출력 ===");

        // TODO: 1부터 10까지 출력하기
        // 힌트:
        // 1. count 변수를 1로 초기화
        // 2. count가 10 이하인 동안 반복
        // 3. count를 출력하고 1씩 증가

        // 여기에 코드를 작성하세요
        int count = 1;
        while(count <= 10){
            System.out.print(count + " ");
            count++;
        }

        // 10부터 1까지 역순 출력
        System.out.println("\n=== 10부터 1까지 출력 ===");

        // TODO: 10부터 1까지 역순으로 출력
        // 힌트:
        // 1. count를 10으로 초기화
        // 2. count가 1 이상인 동안 반복
        // 3. count를 출력하고 1씩 감소

        // 여기에 코드를 작성하세요
        count = 10;
        while(count > 0){
            System.out.print(count + " ");
            count--;
        }
        System.out.println();
    }
}