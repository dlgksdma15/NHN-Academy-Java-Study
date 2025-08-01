package ch03.ex3;

import textio.TextIO;

public class MenuSystem {
    public static void main(String[] args) {
        int choice;

        System.out.println("=== 간단한 계산기 ===");

        do {
            // 메뉴 표시
            System.out.println("\n메뉴:");
            System.out.println("1. 두 수의 합");
            System.out.println("2. 두 수의 차");
            System.out.println("3. 두 수의 곱");
            System.out.println("4. 두 수의 몫");
            System.out.println("0. 종료");

            System.out.print("\n선택: ");
            choice = TextIO.getlnInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("첫 번째 숫자: ");
                double num1 = TextIO.getlnDouble();
                System.out.print("두 번째 숫자: ");
                double num2 = TextIO.getlnDouble();

                double result = 0;
                String operation = "";

                // TODO: choice에 따른 계산 수행
                // 힌트:
                switch (choice){
                    case 1: result = num1 + num2; break;
                    case 2: result = num1 - num2; break;
                    case 3: result = num1 * num2; break;
                    case 4:
                        if(num2 != 0){
                            result = num1 / num2; break;
                        }else{
                            System.out.println("두번째 숫자에 0이 오면 안됩니다");
                            continue;
                        }


                }


                System.out.printf("%.2f %s %.2f = %.2f%n",
                        num1, operation, num2, result);
            } else if (choice != 0) {
                System.out.println("잘못된 선택입니다!");
            }

        } while (choice != 0);

        System.out.println("\n프로그램을 종료합니다.");
    }
}