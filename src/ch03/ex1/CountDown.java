package ch03.ex1;

public class CountDown {
    public static void main(String[] args) {
        int count = 10;

        System.out.println("카운트다운 시작!");

        // TODO: 카운트다운 루프
        // 힌트:
        // 1. count가 0보다 큰 동안 반복
        // 2. count 값 출력 ("..." 포함)
        // 3. count를 1씩 감소
        // 4. Thread.sleep(1000)으로 1초 대기

        // 여기에 코드를 작성하세요
        while(count > 0){
            System.out.printf("%d...\n",count);
            count--;
        }

        System.out.println("발사! 🚀");
    }
}