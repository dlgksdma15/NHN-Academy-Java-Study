package ex;

abstract class Animal{
    protected String name;

    public void sleep(){
        System.out.println(name + "이(가) 잠을 잡니다.");
    }

    public abstract void makeSound();
    public abstract void move();

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }

    @Override
    public void move() {
        System.out.println("네 발로 뛰어다닙니다.");
    }
}

class Bird extends Animal{
    @Override
    public void makeSound() {
        System.out.println("짹짹!");
    }

    @Override
    public void move() {
        System.out.println("날개로 날아다닙니다.");
    }
}
public class AbstractAnimal {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();

        Bird bird = new Bird();
        bird.makeSound();

        Animal animal = new Dog();
        animal.name = "강아지";
        animal.sleep();

        Dog dog1 = new Dog();
        dog1.setName("갱애지");
        dog1.sleep();


    }
}
