package ch05.ex6;

class Vehicle {
    protected String model = "일반 차량";
    protected int maxSpeed = 100;

    public void displayInfo() {
        System.out.println("차량 모델: " + model);
        System.out.println("최고 속도: " + maxSpeed + "km/h");
    }

    public void honk() {
        System.out.println("빵빵!");
    }
}

class SportsCar extends Vehicle {
    protected String model = "스포츠카";
    private boolean turboMode = false;

    public SportsCar() {
        // 부모의 maxSpeed 값 변경
        super.maxSpeed = 250;
    }

    public void displayAllInfo() {
        System.out.println("=== 전체 정보 ===");
        System.out.println("this.model: " + this.model);
        System.out.println("super.model: " + super.model);
        System.out.println("최고 속도: " + super.maxSpeed);
        System.out.println("터보 모드: " + turboMode);
    }

    @Override
    public void honk() {
        super.honk();
        System.out.println("부웉!!");
    }
}

// 테스트
public class SuperAccessExample {
    public static void main(String[] args) {
        SportsCar car = new SportsCar();
        car.displayInfo();      // 부모 메서드 호출
        car.displayAllInfo();   // this와 super 비교
        car.honk();             // 오버라이드 후 super 호출
    }
}

