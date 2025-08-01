package ch03.ex4;

public class MultiVariableFor {
    public static void main(String[] args) {
        // TODO: 두 변수 동시 사용
        // 힌트:
        // 1. "두 변수 동시 변화:" 출력
        // 2. for 루프에서 i=0, j=10으로 시작
        // 3. i < 10 && j > 0 조건
        // 4. i++, j-- 로 변경
        // 5. printf로 i, j, i+j 출력

        // 여기에 코드를 작성하세요
        System.out.println("두 변수 동시 변화:");
        int j = 10;
        for(int i = 0; i < 10; i++){
            System.out.printf("i = %d, j = %2d, 합 = %2d\n", i, j, i + j);
            j--;
        }

        // TODO: 서로 다른 증가율
        // 힌트:
        // 1. "\n서로 다른 증가율:" 출력
        // 2. for 루프에서 x=1, y=1로 시작
        // 3. x <= 10 조건
        // 4. x++, y *= 2 로 변경
        // 5. printf로 x, y 출력 (형식: "x = %2d, y = %4d%n")

        // 여기에 코드를 작성하세요
        System.out.println("\n서로 다른 증가율:");
        int y = 1;
        for(int x = 1; x <= 10; x++){
            System.out.printf("x = %2d, y = %4d%n",x,y);
            y *= 2;
        }

        // TODO: 조건부 증가
        // 힌트:
        // 1. "\n조건부 증가:" 출력
        // 2. for 루프에서 a=0, b=0으로 시작
        // 3. a < 20 조건
        // 4. a += (b % 2 == 0 ? 2 : 1), b++
        // 5. printf로 a, b 출력

        // 여기에 코드를 작성하세요
        System.out.println("\n조건부 증가:");
        int a, b = 0;
        for(a = 0; a < 20; ){
            System.out.printf("a = %2d, b = %2d",a , b);
            System.out.println();
            a += (b % 2 == 0 ? 2 : 1);
            b++;

        }
    }
}
