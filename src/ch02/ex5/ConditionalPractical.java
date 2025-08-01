package ch02.ex5;

public class ConditionalPractical {
    public static void main(String[] args) {
        // 할인 계산
        System.out.println("=== 할인 계산 ===");
        double price = 50000;
        boolean isVIP = true;
        double discount = isVIP ? 0.2 : 0.1;  // VIP는 20%, 일반은 10%
        double finalPrice = price * (1 - discount);

        System.out.printf("정가: %.0f원%n", price);
        System.out.printf("VIP 여부: %s%n", isVIP ? "예" : "아니오");
        System.out.printf("할인율: %.0f%%%n", discount * 100);
        System.out.printf("최종 가격: %.0f원%n", finalPrice);

        // 요일 표시
        System.out.println("\n=== 요일 표시 ===");
        int dayNumber = 5;  // 1=월, 2=화, ..., 7=일
        String dayName = (dayNumber == 1) ? "월요일" :
                (dayNumber == 2) ? "화요일" :
                        (dayNumber == 3) ? "수요일" :
                                (dayNumber == 4) ? "목요일" :
                                        (dayNumber == 5) ? "금요일" :
                                                (dayNumber == 6) ? "토요일" :
                                                        (dayNumber == 7) ? "일요일" : "잘못된 날짜";
        System.out.println("오늘은 " + dayName);

        // 영업 시간 확인
        int hour = 15;  // 15시 (오후 3시)
        String status = (hour >= 9 && hour < 18) ? "영업중" : "영업종료";
        System.out.println("\n현재 " + hour + "시: " + status);

        // 온도에 따른 메시지
        int temperature = 28;
        String message = (temperature > 30) ? "매우 더움" :
                (temperature > 20) ? "따뜻함" :
                        (temperature > 10) ? "선선함" :
                                (temperature > 0) ? "추움" : "매우 추움";
        System.out.println("\n온도 " + temperature + "°C: " + message);
    }
}