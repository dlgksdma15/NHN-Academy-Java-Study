package ch05.ex2;

/**
 * 동적 초기화를 보여주는 주사위 클래스
 */
class DynamicDice {
    // TODO 31: 동적으로 초기화되는 인스턴스 변수 선언하기
    private int value = (int)(Math.random() * 6) + 1;
    private String createdTime = java.time.LocalTime.now().toString();
    private static int totalDiceCount = 0;
    private int diceNumber;

    // TODO 32: 생성자 구현하기
    public DynamicDice() {
        totalDiceCount++;
        diceNumber = totalDiceCount;
        System.out.printf("%d번째 주사위 생성 - 초기값: %d (생성시간: %s)\n"
                ,diceNumber,value,createdTime);
    }

    // TODO 33: getter 메서드들 구현하기
    public int getValue() {
        return value;
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public int getDiceNumber() {
        return diceNumber;
    }
    public static int getTotalDiceCount() {
        return totalDiceCount;
    }

    // TODO 34: 주사위 굴리기 메서드 구현하기
    public void roll() {
        // value를 새로운 랜덤 값(1~6)으로 변경
        int v = (int)(Math.random() * 6) + 1;
        value = v;
        // "[번호]번 주사위를 굴렸습니다: [값]" 출력
        System.out.printf("%d번 주사위를 굴렸습니다: %d\n",diceNumber, value);
    }
}

// TODO 35: 사용 예제 완성하기
public class DynamicInitializationExample {
    public static void main(String[] args) {
        System.out.println("=== 동적 초기화 테스트 ===");

        // TODO 36: 주사위 3개 생성하기
        // DynamicDice dice1, dice2, dice3 생성
        DynamicDice dice1 = new DynamicDice();
        DynamicDice dice2 = new DynamicDice();
        DynamicDice dice3 = new DynamicDice();

        DynamicDice[] dices = {dice1,dice2,dice3};


        // TODO 37: 주사위 굴리기
        System.out.println("\n=== 주사위 굴리기 ===");
        // 각 주사위의 roll() 메서드 호출
        for (DynamicDice dice : dices) {
            dice.roll();

        }

        // TODO 38: 총 생성된 주사위 수 출력하기
        // "총 생성된 주사위 수: [개수]" 출력
        System.out.print("총 생성된 주사위 수: " + DynamicDice.getTotalDiceCount());
    }
}