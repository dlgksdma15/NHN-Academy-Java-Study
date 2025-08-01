package ch03.ex1;

public class PrimeChecker {
    public static void main(String[] args) {
        int number = 17;
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            int divisor = 2;

            // TODO: 소수 판별 루프
            // 힌트:
            // 1. divisor가 number/2 이하인 동안 반복
            // 2. number가 divisor로 나누어 떨어지면:
            //    - isPrime을 false로 설정
            //    - break로 루프 종료
            // 3. divisor를 1 증가

            // 여기에 코드를 작성하세요
            while(divisor <= number/2){
                if (number % divisor == 0){
                    isPrime = false;
                    break;
                }
                else {
                    divisor ++;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + "은(는) 소수입니다.");
        } else {
            System.out.println(number + "은(는) 소수가 아닙니다.");
        }
    }
}