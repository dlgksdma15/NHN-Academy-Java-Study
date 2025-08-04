package ch05.ex1;

/**
 * 게임 캐릭터를 나타내는 클래스
 */
class GameCharacter {
    // Static 변수 (클래스 변수)
    public static int totalCharacters = 0;
    public static int maxLevel = 100;

    // Instance 변수
    public String name;
    public int level;
    public int health;
    public int experience;

    // 생성자에서 총 캐릭터 수 증가
    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.experience = 0;
        totalCharacters++;  // static 변수 증가
    }

    // 경험치 획득
    public void gainExperience(int exp) {
        experience += exp;
        System.out.println(name + "이(가) " + exp + " 경험치를 획득했습니다.");

        // 레벨업 체크
        while (experience >= level * 100) {
            experience -= level * 100;
            levelUp();
        }
    }

    // 레벨업
    private void levelUp() {
        if (level < maxLevel) {
            level++;
            health += 10;
            System.out.println(name + "이(가) 레벨 " + level + "이(가) 되었습니다!");
        }
    }

    // 상태 출력
    public void showStatus() {
        System.out.println("=== " + name + "의 상태 ===");
        System.out.println("레벨: " + level + "/" + maxLevel);
        System.out.println("체력: " + health);
        System.out.println("경험치: " + experience);
    }

    // Static 메서드
    public static void showGameInfo() {
        System.out.println("=== 게임 정보 ===");
        System.out.println("총 캐릭터 수: " + totalCharacters);
        System.out.println("최대 레벨: " + maxLevel);
    }
}

// 사용 예제
public class GameExample {
    public static void main(String[] args) {
        // 게임 정보 표시 (객체 생성 전)
        GameCharacter.showGameInfo();

        // 캐릭터 생성
        GameCharacter warrior = new GameCharacter("전사");
        GameCharacter mage = new GameCharacter("마법사");
        GameCharacter archer = new GameCharacter("궁수");

        // 게임 정보 다시 표시
        GameCharacter.showGameInfo();

        // 캐릭터 플레이
        warrior.gainExperience(150);
        warrior.gainExperience(200);
        warrior.showStatus();

        mage.gainExperience(300);
        mage.showStatus();

        System.out.println("\n총 캐릭터 수: " + GameCharacter.totalCharacters);
    }
}