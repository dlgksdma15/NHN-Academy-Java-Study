package ch05.ex5;

/**
 * 상속의 기본 개념을 보여주는 예제
 */
// 부모 클래스
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        // TODO 1: name과 age 초기화하기
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        // TODO 2: "안녕하세요, 저는 [이름]이고, [나이]살입니다." 출력하기
        System.out.printf("안녕하세요, 저는 %s고, %d살입니다.\n",name,age);
    }

    public void sleep() {
        // TODO 3: "[이름]이(가) 잠을 잡니다." 출력하기
        System.out.printf("%s이(가) 잠을 잡니다.\n",name);
    }
}

// 자식 클래스 1
class Student extends Person {
    private String school;
    private int grade;

    public Student(String name, int age, String school, int grade) {
        // TODO 4: 부모 생성자 호출하고 school, grade 초기화하기
        // super() 사용
        super(name,age);
        this.school = school;
        this.grade = grade;
    }

    // 메서드 오버라이딩
    @Override
    public void introduce() {
        // TODO 5: 부모의 introduce() 호출 후 추가 정보 출력하기
        // super.introduce() 사용
        // "저는 [학교] [학년]학년입니다." 추가 출력
        super.introduce();
        System.out.printf("저는 %s %d학년입니다.\n",school,grade);

    }

    // 새로운 메서드 추가
    public void study() {
        // TODO 6: "[이름]이(가) 공부를 합니다." 출력하기
        System.out.printf("%s이(가) 공부를 합니다.\n",name);
    }
}

// 자식 클래스 2
class Teacher extends Person {
    private String subject;
    private int experience;

    public Teacher(String name, int age, String subject, int experience) {
        // TODO 7: 부모 생성자 호출하고 subject, experience 초기화하기
        super(name, age);
        this.subject = subject;
        this.experience = experience;
    }

    @Override
    public void introduce() {
        // TODO 8: 부모의 introduce() 호출 후 추가 정보 출력하기
        // "저는 [과목] 과목을 [경력]년간 가르쳤습니다." 추가 출력
        super.introduce();
        System.out.printf("저는 %s 과목을 %d년간 가르쳤습니다.\n",subject,experience);
    }

    public void teach() {
        // TODO 9: "[이름] 선생님이 [과목]을(를) 가르칩니다." 출력하기
        System.out.printf("%s 선생님이 %s을(를) 가르칩니다.\n",name,subject);
    }
}

// 테스트 클래스
public class InheritanceExample {
    public static void main(String[] args) {
        // TODO 10: Person, Student, Teacher 객체 생성하기
        // Person: "김철수", 30
        // Student: "이영희", 16, "한국고등학교", 2
        // Teacher: "박교사", 45, "수학", 20
        Person person = new Person("김철수", 30);
        Student student = new Student("이영희", 16, "한국고등학교", 2);
        Teacher teacher = new Teacher("박교사",45,"수학",20);

        // TODO 11: 각자 소개하기
        // 각 객체의 introduce() 메서드 호출
        person.introduce();
        student.introduce();
        teacher.introduce();
        // TODO 12: 공통 행동 실행하기
        // 모든 객체의 sleep() 메서드 호출
        System.out.println("=== 공통 행동 ===");
        Person[] persons = {person,student,teacher};
        for (Person p : persons) {
            p.sleep();
        }
        // TODO 13: 특수 행동 실행하기
        // student.study()와 teacher.teach() 호출
        System.out.println("=== 특수 행동 ===");
        student.study();
        teacher.teach();
    }
}