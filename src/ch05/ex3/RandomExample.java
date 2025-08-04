package ch05.ex3;

import java.util.Random;

/**
 * Random 클래스의 다양한 활용 예제
 */
public class RandomExample {
    private static Random random = new Random();

    /**
     * 주사위 시뮬레이션 클래스
     */
    public static class DiceSimulator {
        private Random rand;

        // TODO 9: 생성자 구현하기
        public DiceSimulator() {
            // Random 객체 생성
            rand = random;

        }

        // TODO 10: 주사위 하나 굴리기 메서드 구현하기
        public int rollDie() {
            return rand.nextInt(6) + 1;
        }

        // TODO 11: 주사위 여러 개 굴리기 메서드 구현하기
        public int rollDice(int count) {
            // sum을 0으로 초기화
            // count번 rollDie() 호출하여 합계 계산
            // 합계 반환
            int sum = 0;
            for(int i = 0; i < count; i++){
                sum += rollDie();
            }
            return sum;
        }

        // TODO 12: 주사위 통계 시뮬레이션 메서드 구현하기
        public void simulateRolls(int times) {
            // int[] counts = new int[13] 생성 (2-12 합계 카운트)
            // times번 반복:
            //   - 주사위 2개 굴리기 (rollDie() + rollDie())
            //   - 합계에 해당하는 counts 배열 요소 증가
            // 결과 출력:
            //   - "=== 주사위 2개 굴리기 [times]회 결과 ==="
            //   - 2부터 12까지 각 합계의 회수와 퍼센트 출력
            System.out.println("=== 주사위 2개 굴리기 10000회 결과 ===");
            int[] counts = new int[13];
            double total = 0;
            for(int i = 0; i < times;i++){
                int sum = rollDie() + rollDie();
                counts[sum]++;
                total += sum;
            }
            for(int i = 0; i < counts.length; i++){
                if(i > 1){
                    System.out.printf("합계 %d: %d회 (%.1f",i,counts[i], counts[i] * 1000 / total);
                    System.out.print("%)\n");


                }
            }
        }
    }
    public static class RandomStringGenerator {
        private static final String CHARACTERS =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // 비밀번호 생성
        public static String generatePassword(int length) {
            StringBuilder password = new StringBuilder();
            Random rand = new Random();

            for (int i = 0; i < length; i++) {
                int index = rand.nextInt(CHARACTERS.length());
                password.append(CHARACTERS.charAt(index));
            }
            return password.toString();
        }
    }

    /**
     * 랜덤 데이터 생성기 클래스
     */
    public static class RandomDataGenerator {
        private static final String[] FIRST_NAMES =
                {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임"};
        private static final String[] LAST_NAMES =
                {"철수", "영희", "민수", "지영", "현우", "수진", "준호", "은영", "태현", "소영"};

        // 랜덤 이름 생성
        public static String generateName() {
            String first = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String last = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            return first + last;
        }

        // 랜덤 나이 생성
        public static int generateAge(int min, int max) {
            return random.nextInt(max - min + 1) + min;
        }
    }

    // TODO 16: 사용 예제 완성하기
    public static void main(String[] args) {
        System.out.println("=== Random 클래스 활용 예제 ===\n");

        // TODO 17: 주사위 시뮬레이션 테스트하기
        // DiceSimulator 객체 생성
        // simulateRolls(10000) 호출
        DiceSimulator diceSimulator = new DiceSimulator();
        diceSimulator.simulateRolls(10000);

        // TODO 18: 랜덤 비밀번호 생성 테스트하기
        String password = RandomStringGenerator.generatePassword(8);
        System.out.println("\n랜덤 비밀번호: " + password);

        System.out.println("\n=== 랜덤 사용자 데이터 ===");
        for (int i = 0; i < 5; i++) {
            String name = RandomDataGenerator.generateName();
            int age = RandomDataGenerator.generateAge(20, 30);
            System.out.println(name + " (" + age + "세)");
        }
    }
}