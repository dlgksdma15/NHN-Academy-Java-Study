package ch05.ex7;

// 기본 동물 인터페이스
interface Animal {
    String getName();
    void eat(String food);
    void sleep();
}

// 이동 가능한 동물
interface Movable {
    void move(int distance);
    int getSpeed();
}

// 소리 낼 수 있는 동물
interface Audible {
    void makeSound();
    void setVolume(int level);
}

// 육상 동물 - 여러 인터페이스 확장
interface LandAnimal extends Animal, Movable, Audible {
    void run();
    void jump();
}

// 수중 동물
interface AquaticAnimal extends Animal, Movable {
    void swim();
    void dive(int depth);
}

// 날 수 있는 동물
interface FlyingAnimal extends Animal, Movable {
    void fly();
    void land();
    int getAltitude();
}

class Dog implements LandAnimal {
    private String name;
    private int speed = 30;  // km/h
    private int volume = 5;

    public Dog(String name) {
        // TODO 47: name 초기화
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO 48: name 반환
        return name;
    }

    @Override
    public void eat(String food) {
        // TODO 49
        System.out.println(name + "가 " + food + "를 먹습니다.");
    }

    @Override
    public void sleep() {
        // TODO 50
        System.out.println(name + "가 잠을 잡니다. Zzz...");
    }

    @Override
    public void move(int distance) {
        // TODO 51
        System.out.println(name + "가 " + distance + "m 이동합니다.");
    }

    @Override
    public int getSpeed() {
        // TODO 52
        return speed;
    }

    @Override
    public void makeSound() {
        // TODO 53
        System.out.println(name + "가 짖습니다: 멍멍! (볼륨: " + volume + ")");
    }

    @Override
    public void setVolume(int level) {
        // TODO 54
        this.volume = Math.max(0, Math.min(10, level));
    }

    @Override
    public void run() {
        // TODO 55
        System.out.println(name + "가 달립니다!");
        move(100);
    }

    @Override
    public void jump() {
        // TODO 56
        System.out.println(name + "가 점프합니다!");
    }
}

class Duck implements LandAnimal, AquaticAnimal, FlyingAnimal {
    private String name;
    private int landSpeed = 5;
    private int swimSpeed = 10;
    private int flySpeed = 40;
    private int currentSpeed;
    private int altitude = 0;
    private int volume = 3;

    public Duck(String name) {
        // TODO 57
        this.name = name;
        this.currentSpeed = landSpeed;
    }

    @Override
    public String getName() {
        // TODO 58
        return name;
    }

    @Override
    public void eat(String food) {
        // TODO 59
        System.out.println(name + "가 " + food + "를 먹습니다.");
    }

    @Override
    public void sleep() {
        // TODO 60
        System.out.println(name + "가 물 위에서 잠을 잡니다.");
    }

    @Override
    public void move(int distance) {
        // TODO 61
        System.out.println(name + "가 " + distance + "m 이동합니다. (속도: " + currentSpeed + "km/h)");
    }

    @Override
    public int getSpeed() {
        // TODO 62
        return currentSpeed;
    }

    @Override
    public void makeSound() {
        // TODO 63
        System.out.println(name + ": 꽥꽥! (볼륨: " + volume + ")");
    }

    @Override
    public void setVolume(int level) {
        // TODO 64
        this.volume = Math.max(0, Math.min(10, level));
    }

    @Override
    public void run() {
        // TODO 65
        this.currentSpeed = landSpeed;
        System.out.println(name + "가 뒤뚱뒤뚱 걷습니다.");
    }

    @Override
    public void jump() {
        // TODO 66
        System.out.println(name + "가 폴짝 뜁니다.");
    }

    @Override
    public void swim() {
        // TODO 67
        this.currentSpeed = swimSpeed;
        System.out.println(name + "가 우아하게 헤엄칩니다.");
    }

    @Override
    public void dive(int depth) {
        // TODO 68
        System.out.println(name + "가 " + depth + "m 깊이로 잠수합니다.");
    }

    @Override
    public void fly() {
        // TODO 69
        this.currentSpeed = flySpeed;
        this.altitude = 100;
        System.out.println(name + "가 날아오릅니다!");
    }

    @Override
    public void land() {
        // TODO 70
        this.altitude = 0;
        this.currentSpeed = landSpeed;
        System.out.println(name + "가 착륙합니다.");
    }

    @Override
    public int getAltitude() {
        // TODO 71
        return altitude;
    }
}

public class Zoo {
    public static void main(String[] args) {
        // TODO 72
        Dog dog = new Dog("바둑이");
        Duck duck = new Duck("도널드");

        // TODO 73
        LandAnimal[] animals = {dog, duck};
        for (LandAnimal animal : animals) {
            animal.run();
            animal.makeSound();
            animal.jump();
        }

        // TODO 74
        duck.swim();
        duck.dive(2);
        duck.fly();
        System.out.println("현재 고도: " + duck.getAltitude() + "m");
        duck.land();
    }
}
