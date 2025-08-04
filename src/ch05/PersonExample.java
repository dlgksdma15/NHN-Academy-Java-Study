package ch05;

/**
 * 사람을 나타내는 기본 클래스
 */
class Person {
    // TODO 1: 인스턴스 변수 선언하기
    // name (문자열), age (정수), email (문자열) 변수를 public으로 선언
    public String name;
    public int age;
    public String email;
    // TODO 2: 자기소개 메서드 구현하기
    public void introduce() {
        System.out.printf("안녕하세요! 저는 %s입니다.\n", name);
        System.out.printf("나이는 %d살입니다.\n",age);
    }

    // TODO 3: 생일 메서드 구현하기
    public void haveBirthday() {
        // age를 1 증가시키고 "[이름]님의 생일을 축하합니다! 이제 [나이]살이 되었습니다." 출력
        System.out.printf("%s의 생일을 축하합니다! 이제 %d살이 되었습니다.\n",name,age + 1);
    }

    // TODO 4: 이메일 유효성 확인 메서드 구현하기
    public boolean hasValidEmail() {
        // email이 null이 아니고 "@"를 포함하면 true, 아니면 false 반환
        if(email != null && email.equals("@")){
            return true;
        }
        return false;
    }
}

// TODO 5: 사용 예제 완성하기
public class PersonExample {
    public static void main(String[] args) {
        // TODO 6: 첫 번째 객체 생성하고 정보 설정하기
        // Person 객체를 생성하고 name = "김철수", age = 25, email = "kim@example.com"으로 설정
        Person kim = new Person();
        kim.name = "김철수";
        kim.age = 25;
        kim.email = "kim@example.com";
        // TODO 7: 두 번째 객체 생성하고 정보 설정하기
        // Person 객체를 생성하고 name = "이영희", age = 23, email = "lee@example.com"으로 설정
        Person lee = new Person();
        lee.name = "이영희";
        lee.age = 23;
        lee.email = "lee@example.com";

        // TODO 8: 메서드 호출하기
        // 두 사람의 introduce() 메서드 호출
        kim.introduce();
        lee.introduce();
        // TODO 9: 생일 축하하기
        // person1의 haveBirthday() 메서드 호출
        kim.haveBirthday();
        // TODO 10: 이메일 유효성 확인하기
        // person1의 이메일이 유효하면 "[이름]님의 이메일은 유효합니다." 출력
        if(kim.hasValidEmail()){
            System.out.printf("%s님의 이메일은 유효합니다",kim.name);
        }else{
            System.out.printf("%s님의 이메일은 유효하지 않습니다.",kim.name);
        }
    }
}