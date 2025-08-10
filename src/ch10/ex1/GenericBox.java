package ch10.ex1;

/**
 * 제네릭 Box 클래스 - 어떤 타입의 객체든 저장 가능
 */
public class GenericBox<T> {
    private T content;

    public void put(T item) {
        // TODO: item을 content에 저장
        content = item;
    }

    public T get() {
        // TODO: content를 반환
        return content; // 임시 반환값
    }

    public boolean isEmpty() {
        // TODO: content가 null인지 확인
        if(content == null){
            return false;
        }
        return true; // 임시 반환값
    }

    public static void main(String[] args) {
        // String을 저장하는 Box
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.put("Hello, Generics!");

        // Integer를 저장하는 Box
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.put(42);

        // 실행 결과:
        // String Box: Hello, Generics!
        // Integer Box: 42
        // Person Box: 홍길동 (25세)
        System.out.println("String Box: " + stringBox.get());
        System.out.println("Integer Box: " + intBox.get());

        Person person = new Person("홍길동",25);
        GenericBox<Person> personBox = new GenericBox<>();
        personBox.put(person);
        System.out.println("Person Box: " + personBox.get());

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + "세)";
    }
}