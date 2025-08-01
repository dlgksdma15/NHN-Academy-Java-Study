package ch03.ex3;

import textio.TextIO;

public class BreakExample {
    public static void main(String[] args) {
        // TODO: 무한 루프에서 break 사용하여 양수 입력받기
        // 힌트:
        // 1. while(true) 무한 루프
        // 2. 숫자 입력받기
        // 3. 양수이면 break로 루프 종료
        // 4. 양수가 아니면 오류 메시지 출력
        System.out.println("=== 양수 입력 받기 ===");

        while(true){
            System.out.print("양수를 입력하세요: ");
            int positiveNumber = TextIO.getlnInt();
            if(positiveNumber > 0){
                System.out.println("입력된 양수: " + positiveNumber);
                break;
            }else{
                System.out.println("양수가 아닙니다. 다시 입력해주세요!");
            }
        }

        // 여기에 코드를 작성하세요


        // 검색에서 break 사용
        System.out.println("\n=== 특정 수 찾기 ===");
        int target = 7;
        int found = -1;
        int i = 1;

        while (i <= 100) {
            if (i * i == 49) {  // 7의 제곱 찾기
                found = i;
                break;  // 찾으면 즉시 종료
            }
            i++;
        }

        if (found != -1) {
            System.out.println(found + "의 제곱은 49입니다.");
        }
    }
}