package ch02.ex3;

public class EnumApplication {
    enum TrafficLight { RED, YELLOW, GREEN }

    enum CoffeeSize { SMALL, MEDIUM, LARGE }

    public static void main(String[] args) {
        // TODO: 신호등 시뮬레이션을 구현하세요
        // 힌트:
        TrafficLight light = TrafficLight.RED;
        System.out.println("현재 신호: " + light);
        // 3. switch문으로 신호에 따른 메시지 출력:
        switch(light){
            case RED:
                System.out.println("정지하세요!");
                break;
            case YELLOW:
                System.out.println("주의하세요!");
                break;
            case GREEN:
                System.out.println("진행하세요!");
                break;
        }

        // TODO: 커피 주문 시스템을 구현하세요
        CoffeeSize myOrder = CoffeeSize.MEDIUM;
        int price = 0;
        switch (myOrder){
            case SMALL:
                price += 3000;
                break;
            case MEDIUM:
                price += 4000;
                break;
            case LARGE:
                price += 5000;
                break;

        }
        System.out.println("\n커피 주문: " + myOrder);
        System.out.println("가격: " + price + "원");

        // TODO: 열거형 비교를 구현하세요
        CoffeeSize yourOrder = CoffeeSize.MEDIUM;
        if (myOrder == yourOrder){
            System.out.println("같은 사이즈를 주문했습니다!");
        }
    }
}