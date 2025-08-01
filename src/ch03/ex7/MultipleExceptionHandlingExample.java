package ch03.ex7;

import textio.TextIO;

public class MultipleExceptionHandlingExample {
    public static void main(String[] args) {
        System.out.println("=== 다중 예외 처리 예제 ===");

        while (true) {
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 배열 접근 테스트");
            System.out.println("2. 숫자 변환 테스트");
            System.out.println("3. 나눗셈 테스트");
            System.out.println("4. 복합 계산 테스트");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            try {
                int choice = Integer.parseInt(TextIO.getln());

                switch (choice) {
                    case 1 -> testArrayAccess();
                    case 2 -> testNumberParsing();
                    case 3 -> testDivision();
                    case 4 -> testComplexCalculation();
                    case 0 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("❌ 올바른 메뉴를 선택하세요.");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println("❌ 예상치 못한 오류: " + e.getMessage());
            }
        }
    }

    public static void testArrayAccess() {
        System.out.println("\n🔍 배열 접근 테스트");

        // TODO: 배열 접근 예외 처리
        // 힌트: 다중 catch 블록 사용
        int[] arr = {10,20,30,40,50};

        // 여기에 코드를 작성하세요
        try {
            System.out.println("인덱스를 입력하세요 (0~4):");
            int index = Integer.parseInt(TextIO.getln());

            int value = arr[index];
            System.out.printf("arr[%d] = %d",index,value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ 인덱스 범위를 벗어났습니다: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ 숫자 형식이 잘못되었습니다.");
        }
    }

    public static void testNumberParsing() {
        System.out.println("\n🔢 숫자 변환 테스트");

        System.out.print("변환할 문자열을 입력하세요: ");
        String input = TextIO.getln();

        // TODO: 여러 형태로 변환 시도
        // 힌트: 각각 독립된 try-catch 블록
        try{
            int intValue = Integer.parseInt(input);
            System.out.println("✔️ 정수 변환 성공: " + intValue);
        }catch (NumberFormatException e){
            System.out.println("❌ 정수 변환 실패: " + e.getMessage());
        }

        try{
            double doubleValue = Double.parseDouble(input);
            System.out.println("✔️ 실수 변환 성공: " + doubleValue);
        }catch (NumberFormatException e){
            System.out.println("❌ 실수 변환 실패: " + e.getMessage());
        }

        try{
            long longValue = Long.parseLong(input);
            System.out.println("✔️ Long 변환 성공: " + longValue);
        }catch (NumberFormatException e){
            System.out.println("❌ Long 변환 실패: " + e.getMessage());
        }

    }

    public static void testDivision() {
        System.out.println("\n➗ 나눗셈 테스트");

        try {
            System.out.print("피제수 (나눠지는 수): ");
            double dividend = Double.parseDouble(TextIO.getln());

            System.out.print("제수 (나누는 수): ");
            double divisor = Double.parseDouble(TextIO.getln());

            // TODO: 나눗셈 수행 및 결과 분석
            // 힌트: 0으로 나누기 검사

            // 여기에 코드를 작성하세요
            if(divisor == 0){
                throw new ArithmeticException("0으로 나누면 안됩니다.");
            }
            double result = dividend / divisor;
            System.out.printf("✅ 결과: %.2f ÷ %.2f = %.2f", dividend, divisor, result);

        } catch (NumberFormatException e) {
            System.out.println("❌ 숫자 형식 오류: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("❌ 산술 오류: " + e.getMessage());
        }
    }

    public static void testComplexCalculation() {
        System.out.println("\n🧮 복합 계산 테스트");

        try {
            System.out.print("배열 크기를 입력하세요: ");
            int size = Integer.parseInt(TextIO.getln());

            if (size <= 0) {
                throw new IllegalArgumentException("배열 크기는 1 이상이어야 합니다.");
            }

            double[] numbers = new double[size];
            double sum = 0;

            // 값 입력
            for (int i = 0; i < size; i++) {
                System.out.print("숫자 " + (i + 1) + " 입력: ");
                numbers[i] = Double.parseDouble(TextIO.getln());
                sum += numbers[i];
            }

            // 평균 계산
            double average = sum / size;

            // 표준편차 계산
            double varianceSum = 0;
            for (double num : numbers) {
                varianceSum += Math.pow(num - average, 2);
            }
            double stddev = Math.sqrt(varianceSum / size);

            // 결과 출력
            System.out.printf("📊 평균: %.2f%n", average);
            System.out.printf("📉 표준편차: %.2f%n", stddev);

        } catch (NumberFormatException e) {
            System.out.println("❌ 숫자 형식 오류: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 잘못된 인수: " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("❌ 배열 크기 오류: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("❌ 메모리 부족: 배열 크기를 줄이세요");
        } catch (Exception e) {
            System.out.println("❌ 예상치 못한 오류: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

}