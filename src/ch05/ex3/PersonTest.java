package ch05.ex3;

import java.util.Objects;

/**
 * Object 클래스 메서드를 올바르게 재정의한 예제
 */
class Person {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;

    // 생성자
    public Person(String name, int age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // toString() 재정의
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age +
                ", email='" + email + "', phone='" + phoneNumber + "'}";
    }

    // equals() 재정의
    @Override
    public boolean equals(Object obj) {
        // 1. 같은 참조인지 확인
        if (this == obj) return true;
        // 2. null 또는 타입 다르면 false
        if (obj == null || getClass() != obj.getClass()) return false;

        // 3. 캐스팅 후 필드 비교
        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }

    // hashCode() 재정의
    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, phoneNumber);
    }
}

// 테스트 클래스
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("=== Person 클래스 테스트 ===\n");

        // 객체 생성
        Person person1 = new Person("김철수", 25, "kim@email.com", "010-1234-5678");
        Person person2 = new Person("이영희", 23, "lee@email.com", "010-9876-5432");
        Person person3 = new Person("김철수", 25, "kim@email.com", "010-1234-5678");

        // toString 테스트
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);

        // equals 테스트
        System.out.println("\n=== equals() 테스트 ===");
        System.out.println("person1.equals(person2): " + person1.equals(person2));
        System.out.println("person1.equals(person3): " + person1.equals(person3));
        System.out.println("person1 == person3: " + (person1 == person3));

        // hashCode 테스트
        System.out.println("\n=== hashCode() 테스트 ===");
        System.out.println("person1 hashCode: " + person1.hashCode());
        System.out.println("person2 hashCode: " + person2.hashCode());
        System.out.println("person3 hashCode: " + person3.hashCode());
        System.out.println("person1과 person3 hashCode 같은가? " +
                (person1.hashCode() == person3.hashCode()));
    }
}
