package ch03.ex5;

public class BasicIfExample {
    public static void main(String[] args) {
        int age = 20;
        double temperature = 36.5;
        boolean isRaining = false;

        // 1. 나이가 19세 이상이면 성인입니다 출력
        if (age >= 19) {
            System.out.println("성인입니다.");
        }

        // 2. 체온이 정상 범위(36.1 ~ 37.2)면 "정상 체온입니다" 출력
        if (temperature >= 36.1 && temperature <= 37.2) {
            System.out.println("정상 체온입니다.");
        }

        // 3. 비가 오면 "우산을 챙기세요" 출력
        if (isRaining) {
            System.out.println("우산을 챙기세요.");
        } else {
            System.out.println("날씨가 맑습니다.");
        }
    }
}
