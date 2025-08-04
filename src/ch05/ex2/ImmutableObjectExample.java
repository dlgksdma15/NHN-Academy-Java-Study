package ch05.ex2;

/**
 * final 필드를 가진 불변 Person 클래스
 */
class ImmutablePerson {
    // TODO 54: final 필드 선언하기
    private final String name;
    private final String socialId;
    private final int birthYear;
    private int age;

    // TODO 55: 생성자 구현하기
    public ImmutablePerson(String name, String socialId, int birthYear) {
        // name이 null이거나 비어있으면 "이름은 필수입니다." 예외
        // socialId가 null이거나 13자리가 아니면 "주민번호는 13자리여야 합니다." 예외
        // birthYear가 1900보다 작거나 2023보다 크면 "출생연도가 유효하지 않습니다." 예외
        // final 필드들 초기화
        // age = 2023 - birthYear로 계산
        if(name == null){
            throw new IllegalArgumentException("이름은 필수입니다.");
        }
        if(socialId == null || socialId.length() != 13){
            throw new IllegalArgumentException("주민번호는 13자리여야 합니다.");
        }
        if(birthYear < 1900 || birthYear > 2023){
            throw new IllegalArgumentException("출생연도가 유요하지 않습니다.");
        }
        this.name = name;
        this.socialId = socialId;
        this.birthYear = birthYear;
        this.age = 2023 - birthYear;
    }

    // TODO 56: getter 메서드들 구현하기 (setter는 없음)
    public String getName() { return name; }
    public String getSocialId() { return socialId; }
    public int getBirthYear() { return birthYear; }
    public int getAge() { return age; }

    // TODO 57: age 업데이트 메서드 구현하기
    public void updateAge(int currentYear) {
        this.age = currentYear - birthYear;
    }

    // TODO 58: 새로운 객체를 반환하는 방식으로 "변경" 구현하기
    public ImmutablePerson withNewAge(int currentYear) {
        // 같은 name, socialId, birthYear로 새 객체 생성
        // 새 객체의 age를 currentYear - birthYear로 설정
        // 새 객체 반환
        ImmutablePerson person = new ImmutablePerson(name, socialId, birthYear);
        person.age = currentYear - birthYear;
        return person;

    }

    // TODO 59: 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "이름: [이름], 주민번호: [앞6자리]-*******, 출생연도: [년도], 나이: [나이]" 출력
        System.out.printf("이름: %s, 주민번호: %s-********, 출생연도: %d, 나이: %d\n",
                name,socialId,birthYear,age);
    }
}

// TODO 60: 사용 예제 완성하기
public class ImmutableObjectExample {
    public static void main(String[] args) {
        try {
            System.out.println("=== 불변 객체 예제 ===");

            // TODO 61: 불변 객체 생성하기
            // "김철수", "9001011234567", 1990으로 person 생성하고 정보 출력
            ImmutablePerson person = new ImmutablePerson("김철수", "9001011234567", 1990);
            person.displayInfo();
            System.out.println();

            // TODO 62: age 업데이트하기
            // 2024년 기준으로 나이 업데이트하고 정보 출력
            System.out.println("나이 업데이트 후:");
            person.updateAge(2024);
            person.displayInfo();
            System.out.println();

            System.out.println("새 객체 생성 후");
            System.out.println("원본 객체:");
            person.displayInfo();


            // TODO 63: 새 객체 생성 방식 테스트하기
            // 2025년 기준으로 새 객체 생성
            // 원본 객체와 새 객체 정보 모두 출력
            System.out.println("새 객체:");
            ImmutablePerson newPerson = person.withNewAge(2025);
            newPerson.displayInfo();



        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}