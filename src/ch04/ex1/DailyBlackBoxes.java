package ch04.ex1;

public class DailyBlackBoxes {
    public static void main(String[] args) {
        System.out.println("=== 일상생활의 블랙박스 예제 ===");

        // TODO 1: TV 블랙박스 사용하기
        System.out.println("1. TV 사용하기:");
        // TV 객체를 생성하고 켜기, 채널 변경, 볼륨 조절, 끄기를 해보세요
        TV tv = new TV();
        tv.turnOn();
        tv.changeChannel(7);
        tv.adjustVolume(15);
        tv.turnOff();
        // TODO 2: 전자레인지 블랙박스 사용하기
        System.out.println("\n2. 전자레인지 사용하기:");
        // 전자레인지 객체를 생성하고 시간 설정, 출력 설정, 시작을 해보세요
        Microwave microwave = new Microwave();
        microwave.setTime(2,30);
        microwave.setPower(70);
        microwave.start();

        // TODO 3: 계산기 블랙박스 사용하기
        System.out.println("\n3. 계산기 사용하기:");
        // 계산기의 add, multiply, squareRoot 메서드를 사용해보세요
        Calculator.add(3,5);
        Calculator.divide(10,20);
        Calculator.multiply(5,8);
        Calculator.squareRoot(64);
    }
}

// TODO 4: TV 블랙박스 클래스 완성하기
class TV {
    private boolean isOn = false;
    private int channel = 1;
    private int volume = 10;

    public void turnOn() {
        // TODO: TV를 켜는 기능을 구현하세요
        // isOn을 true로 설정하고 "TV가 켜졌습니다." 출력
        isOn = true;
        System.out.println("TV가 켜졌습니다.");
    }

    public void turnOff() {
        // TODO: TV를 끄는 기능을 구현하세요
        isOn = false;
        System.out.println("TV가 꺼졌습니다.");
    }

    public void changeChannel(int newChannel) {
        // TODO: 채널을 변경하는 기능을 구현하세요
        // TV가 켜져있을 때만 작동해야 함
        if(isOn){
            System.out.printf("채널 %d번으로 조정했습니다.\n",newChannel);
        }else{
            System.out.println("TV가 켜져있을때만 채널을 변경할 수 있습니다.");
        }
    }

    public void adjustVolume(int newVolume) {
        // TODO: 볼륨을 조절하는 기능을 구현하세요
        if(isOn){
            System.out.printf("볼륨을 %d으로 조정했습니다.\n",newVolume);
        }else{
            System.out.println("TV가 켜져있을때만 볼륨을 조절할 수 있습니다.");
        }
    }
}

// TODO 5: 전자레인지 블랙박스 클래스 완성하기
class Microwave {
    private int minutes = 0;
    private int seconds = 0;
    private int powerLevel = 100;

    public void setTime(int min, int sec) {
        // TODO: 시간을 설정하는 기능을 구현하세요
        this.minutes = min;
        this.seconds = sec;
        if(min <= 60 && min >= 0){
            System.out.printf("시간 설정: %d분 %d초\n",minutes,seconds);
        }else{
            System.out.println("시간을 제대로 설정하십시오.");
        }
    }

    public void setPower(int power) {
        // TODO: 출력을 설정하는 기능을 구현하세요

        if(power <= 100 && power > 0){
            this.powerLevel = power;
            System.out.println("출력 설정: " + power + "%");
        }
    }

    public void start() {
        // TODO: 조리를 시작하는 기능을 구현하세요
    }
}

// TODO 6: 계산기 블랙박스 클래스 완성하기
class Calculator {
    public static double add(double a, double b) {
        // TODO: 두 수를 더하는 기능을 구현하세요
        System.out.printf("%d + %d = %.1f\n",(int)a,(int)b, a + b);
        return a + b;
    }

    public static double multiply(double a, double b) {
        // TODO: 두 수를 곱하는 기능을 구현하세요
        System.out.printf("%d x %d = %.1f\n",(int)a, (int)b, a*b);
        return a * b;
    }

    public static double squareRoot(double number) {
        // TODO: 제곱근을 계산하는 기능을 구현하세요 (Math.sqrt 사용)
        System.out.printf("√%d = %.1f\n",(int)number, Math.sqrt(number));
        return Math.sqrt(number);
    }

    // TODO 7: 추가 기능 구현하기
    // subtract (빼기), divide (나누기) 메서드를 추가로 구현해보세요
    public static void subtract(double a, double b){
        System.out.printf("%d - %d = %d\n", (int)a, (int)b, (int) (a - b));
    }
    public static void divide(double a, double b){
        System.out.printf("%d ÷ %d = %.1f\n",(int)a, (int)b, a/b);
    }
}
