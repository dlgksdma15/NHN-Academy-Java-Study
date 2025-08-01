package ch02.ex3;

public class RandomNumbers {
    public static void main(String[] args) {
        // TODO: 난수 생성 예제 시작 메시지를 출력하세요
        // 힌트: "=== 난수 생성 예제 ==="

        // TODO: 기본 난수 5개를 생성하고 출력하세요
        // 힌트:
        // 1. "기본 난수 5개:" 출력
        // 2. for 루프로 5번 반복하여 Math.random() 결과 출력

        // TODO: 1부터 10까지의 난수 정수 10개를 생성하세요
        // 힌트:
        // 1. "\n1-10 사이의 정수:" 출력
        // 2. for 루프 10번 반복
        // 3. int num = (int)(Math.random() * 10) + 1; 사용
        // 4. 공백으로 구분하여 출력

        // TODO: 주사위 시뮬레이션 (1-6) 10번 수행하세요
        // 힌트:
        // 1. "\n\n주사위 10번 굴리기:" 출력
        // 2. int dice = (int)(Math.random() * 6) + 1; 사용
        // 3. 공백으로 구분하여 출력

        // TODO: 동전 던지기 시뮬레이션 20번 수행하세요
        // 힌트:
        // 1. "\n\n동전 던지기 20번:" 출력
        // 2. boolean heads = Math.random() < 0.5; 사용
        // 3. 삼항 연산자로 heads ? "앞 " : "뒤 " 출력
        // 4. 마지막에 줄바꿈 출력

        // 여기에 코드를 작성하세요
        System.out.println("=== 난수 생성 예제 ===");
        System.out.println("기본 난수 5개");
        for(int i = 0; i < 5; i++){
            System.out.println(Math.random());
        }

        System.out.println("\n1-10 사아의 정수:");
        for(int i = 0; i < 10; i++){
            int num = (int)(Math.random() * 10) + 1;
            System.out.print(num + " ");
        }

        System.out.println("\n주사위 10번 굴리기:");
        for(int i = 0; i < 10; i++){
            int dice = (int)(Math.random() * 6) + 1;
            System.out.print(dice + " ");
        }

        System.out.println("\n동전 던지기 20번:\"");
        for(int i = 0; i < 20; i++){
            boolean heads = Math.random() < 0.5;
            System.out.print(heads ? "앞 " : "뒤 ");
        }
    }
}