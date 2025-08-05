package ch05.ex5;

import java.util.ArrayList;
import java.util.List;

/**
 * 복잡한 클래스 계층 구조를 보여주는 예제
 */
// 최상위 추상 클래스
abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // 추상 메서드
    public abstract void makeSound();
    public abstract void move();
    public abstract String getHabitat();

    // 구체 메서드
    public void eat() {
        // TODO 28: "[이름]이(가) 먹이를 먹습니다." 출력하기
        System.out.printf("%s이(가) 먹이를 먹습니다.\n",name);
    }

    public void sleep() {
        // TODO 29: "[이름]이(가) 잠을 잡니다." 출력하기
        System.out.printf("%s(가) 잠을 잡니다.\n",name);
    }

    @Override
    public String toString() {
        // TODO 30: "[이름] (나이: [나이], 체중: [체중]kg)" 형식으로 반환하기
        return "%s (나이: %d, 체중: %.1fkg)".formatted(name,age,weight);
    }
}

// 포유류 추상 클래스
abstract class Mammal extends Animal {
    protected boolean hasFur;

    public Mammal(String name, int age, double weight, boolean hasFur) {
        super(name, age, weight);
        this.hasFur = hasFur;
    }
    public void nurse() {
        // TODO 32: "[이름]이(가) 새끼에게 젖을 먹입니다." 출력하기
        System.out.printf("%s이(가) 새끼에게 젖을 먹입니다.\n",name);
    }
}

// 조류 추상 클래스
abstract class Bird extends Animal {
    protected double wingspan;
    protected boolean canFly;

    public Bird(String name, int age, double weight, double wingspan, boolean canFly) {
        super(name, age, weight);
        this.wingspan = wingspan;
        this.canFly = canFly;
    }

    public void layEggs() {
        // TODO 34: "[이름]이(가) 알을 낳습니다." 출력하기
        System.out.printf("%s이(가) 알을 낳습니다.\n",name);
    }
}

// 구체적인 동물 클래스들
class Dog extends Mammal {
    private String breed;

    /*public Dog(String name, int age, double weight, String breed) {
        // TODO 35: 부모 생성자 호출(hasFur는 true)하고 breed 초기화하기
    }*/

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight,true);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        // TODO 36: "멍멍!" 출력하기
        System.out.println("멍멍!");
    }

    @Override
    public void move() {
        // TODO 37: "[이름]이(가) 네 발로 뛰어다닙니다." 출력하기
        System.out.printf("%s이(가) 네 발로 뛰어다닙니다.\n",name);
    }

    @Override
    public String getHabitat() {
        // TODO 38: "인간과 함께 사는 집" 반환하기
        return "인간과 함께 사는 집";
    }

    public void wagTail() {
        // TODO 39: "[이름]이(가) 꼬리를 흔듭니다." 출력하기
        System.out.printf("%s이(가) 꼬리를 흔듭니다.\n",name);
    }
}

class Eagle extends Bird {
    private double huntingRange;

//    public Eagle(String name, int age, double weight, double wingspan, double huntingRange) {
//        // TODO 40: 부모 생성자 호출(canFly는 true)하고 huntingRange 초기화하기
//    }

    public Eagle(String name, int age, double weight, double wingspan, boolean canFly, double huntingRange) {
        super(name, age, weight, wingspan,true);
        this.huntingRange = huntingRange;
    }

    @Override
    public void makeSound() {
        // TODO 41: "끼이익!" 출력하기
        System.out.println("끼이익!");
    }

    @Override
    public void move() {
        // TODO 42: "[이름]이(가) 하늘을 날아다닙니다." 출력하기
        System.out.printf("%s이(가) 하늘을 날아다닙니다.\n",name);
    }

    @Override
    public String getHabitat() {
        // TODO 43: "높은 산의 절벽" 반환하기
        return "높은 산의 절벽";
    }

    public void hunt() {
        // TODO 44: "[이름]이(가) 사냥을 합니다. 사냥 범위: [사냥범위]km" 출력하기
        System.out.printf("%s이(가) 사냥을 합니다. 사냥 범위: %.1fkm\n",name,huntingRange);
    }
}

// 동물원 관리 시스템
class Zoo {
    private List<Animal> animals;
    private String name;

    public Zoo(String name) {
        // TODO 45: name 초기화하고 animals를 새 ArrayList로 초기화하기
        this.name = name;
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        // TODO 46: animals에 animal 추가하고
        // "[동물이름]이(가) [동물원이름]에 추가되었습니다." 출력하기
        animals.add(animal);
        System.out.printf("%s이(가) %s에 추가되었습니다.\n",animal.name,name);

    }

    public void feedAllAnimals() {
        // TODO 47: 모든 동물에게 먹이 주기
        // "=== 모든 동물에게 먹이 주기 ===" 출력
        // 모든 동물의 eat() 메서드 호출
        System.out.println("=== 모든 동물에게 먹이 주기 ===");
        for(Animal animal : animals){
            animal.eat();
        }
    }

    public void makeAllSounds() {
        // TODO 48: 모든 동물의 소리 듣기
        // "=== 동물들의 소리 ===" 출력
        // 각 동물에 대해 "[이름]: " 출력 후 makeSound() 호출
        System.out.println("=== 동물들의 소리 ===");
        for (Animal animal : animals) {
            System.out.print(animal.name + ": ");
            animal.makeSound();
        }
    }

    public void performSpecialActions() {
        // TODO 49: 특별한 행동들 수행하기
        // "=== 특별한 행동들 ===" 출력
        // Dog이면 wagTail(), Eagle이면 hunt() 호출
        // instanceof 사용
        System.out.println("=== 특별한 행동들 ===");
        //Animal[] animals = {dog,eagle}
         for (Animal animal : animals) {
            if(animal instanceof Dog dog){
                dog.wagTail();
            }else if(animal instanceof Eagle eagle){
                eagle.hunt();
            }
        }

    }
}

// 테스트
public class ZooTest {
    public static void main(String[] args) {
        // TODO 50: 동물원 생성하고 동물들 추가하기
        // Zoo: "행복한 동물원"
        // Dog: "바둑이", 5, 15.5, "진돗개"
        // Eagle: "독수리", 7, 6.8, 2.1, 50
        Zoo zoo = new Zoo("행복한 동물원");
        Dog dog = new Dog("바둑이", 5, 15.5, "진돗개");
        Eagle eagle = new Eagle("독수리", 7, 6.8, 2.1, true,50);
        zoo.addAnimal(dog);
        zoo.addAnimal(eagle);
        // TODO 51: 동물원 운영하기
        // feedAllAnimals(), makeAllSounds(), performSpecialActions() 호출
        zoo.feedAllAnimals();
        zoo.makeAllSounds();
        zoo.performSpecialActions();
    }
}