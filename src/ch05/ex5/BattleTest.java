package ch05.ex5;

abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int level;
    protected int attackPower;

    public GameCharacter(String name, int maxHealth, int attackPower) {
        // TODO 52: 필드 초기화하기
        // name, maxHealth, attackPower 초기화
        // health = maxHealth, level = 1로 설정
        this.name = name;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        health = 1;
        level = 1;
    }

    // 추상 메서드들
    public abstract void attack(GameCharacter target);
    public abstract void useSpecialSkill(GameCharacter target);
    public abstract String getClassName();

    // 공통 메서드들
    public void takeDamage(int damage) {
        // TODO 53: 피해 입기 구현하기
        // health에서 damage 차감 (0 미만이면 0으로)
        // "[이름]이(가) [피해]의 피해를 입었습니다! (남은 체력: [체력])" 출력
        // health가 0이면 "[이름]이(가) 쓰러졌습니다!" 추가 출력
        if(health - damage < 0){
            health = 0;
        }
        health -= damage;
        System.out.printf("%s이(가) %d의 피해를 입었습니다! ", name,damage);
        System.out.printf("(남은 체력: %d)",health);
        if(health == 0){
            System.out.println("%s이(가) 쓰러졌습니다!");
        }
    }

    public void heal(int amount) {
        // TODO 54: 체력 회복 구현하기
        // health에 amount 추가 (maxHealth 초과 시 maxHealth로)
        // "[이름]이(가) [회복량]의 체력을 회복했습니다! (현재 체력: [체력])" 출력
        health += amount;
        if(maxHealth < health + amount){
            health = maxHealth;
        }
        System.out.printf("%s이(가) %d의 채력을 회복했습니다.",name,amount);
        System.out.printf("(현재 체력: %d)\n",health);
    }

    public boolean isAlive() {
        // TODO 55: 생존 여부 반환하기
        if(health > 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO 56: 캐릭터 정보 문자열 반환하기
        // "[이름] (Lv.[레벨] [직업]) - HP: [현재체력]/[최대체력], 공격력: [공격력]"
        return "%s (Lv.%d %s) - HP: %d/%d, 공격력: %d"
                .formatted(name,level,getClassName(),health,maxHealth,attackPower);
    }
}

// 전사 클래스
class Warrior extends GameCharacter {
    private int armor;

    public Warrior(String name) {
        // TODO 57: 부모 생성자 호출하기
        // maxHealth: 150, attackPower: 20
        // armor = 10으로 초기화
        super(name,150,20);
        health = 150;
        armor = 10;
    }

    @Override
    public void attack(GameCharacter target) {
        // TODO 58: 기본 공격 구현하기
        // "[이름]이(가) [대상이름]을(를) 검으로 공격합니다!" 출력
        // target.takeDamage(attackPower) 호출
        System.out.printf("%s이(가) %s을(를) 검으로 공격합니다!\n",name,target.name);
        target.takeDamage(attackPower);
        System.out.println();

    }

    @Override
    public void useSpecialSkill(GameCharacter target) {
        // TODO 59: 특수 스킬 구현하기
        // "[이름]이(가) 광폭화를 사용합니다!" 출력
        // specialDamage = attackPower * 2
        // target.takeDamage(specialDamage) 호출
        System.out.printf("%s이(가) 광폭화를 사용합니다!\n",name);
        int specialDamage = attackPower * 2;
        target.takeDamage(specialDamage);
        System.out.println();
    }

    @Override
    public void takeDamage(int damage) {
        // TODO 60: 방어구 효과 적용하여 피해 입기
        // reducedDamage = damage - armor (최소 0)
        // "[이름]의 방어구가 [감소량]의 피해를 막았습니다!" 출력
        // super.takeDamage(reducedDamage) 호출
        int reducedDamage;
        if(armor >= 0){
             reducedDamage = damage - armor;
        }else{
            System.out.println("방어구는 0보다 커야합니다. 그럼으로 방어구 0으로 설정");
            reducedDamage = 0;
        }
        System.out.printf("%s의 방어구가 %d의 피해를 막았습니다!",name,reducedDamage);
        super.takeDamage(reducedDamage);
    }

    @Override
    public String getClassName() {
        // TODO 61: "전사" 반환하기
        return "전사";
    }
}

// 마법사 클래스
class Mage extends GameCharacter {
    private int mana;
    private int maxMana;

    public Mage(String name) {
        // TODO 62: 부모 생성자 호출하기
        // maxHealth: 80, attackPower: 15
        // maxMana = 100, mana = maxMana로 초기화
        super(name,80,15);
        maxMana = 100;
        health = 80;
        mana = maxMana;
    }

    @Override
    public void attack(GameCharacter target) {
        // TODO 63: 마법 공격 구현하기
        // mana >= 10이면:
        //   "[이름]이(가) [대상이름]에게 파이어볼을 시전합니다!" 출력
        //   target.takeDamage(attackPower + 10) 호출
        //   mana -= 10
        // 아니면:
        //   "[이름]의 마나가 부족합니다! 기본 공격을 합니다." 출력
        //   target.takeDamage(attackPower) 호출
        if(mana >= 10){
            System.out.printf("%s이(가) %s에게 파이어볼을 시전합니다!\n",name,target.name);
            target.takeDamage(attackPower + 10);
        }else{
            System.out.printf("%s의 마나가 부족합니다! 기본 공격을 합니다.\n",name);
            target.takeDamage(attackPower);
        }
        System.out.println();
        
    }

    @Override
    public void useSpecialSkill(GameCharacter target) {
        // TODO 64: 메테오 스킬 구현하기
        // mana >= 30이면:
        //   "[이름]이(가) 메테오를 시전합니다!" 출력
        //   specialDamage = attackPower * 3
        //   target.takeDamage(specialDamage) 호출
        //   mana -= 30
        // 아니면:
        //   "마나가 부족합니다!" 출력
        if(mana >= 30){
            System.out.printf("%s이(가) 메테오를 시전합니다!\n",name);
            int specialDamage = attackPower * 3;
            target.takeDamage(specialDamage);
            mana -= 30;
        }else{
            System.out.println("마나가 부족합니다!");
        }
    }

    @Override
    public String getClassName() {
        // TODO 65: "마법사" 반환하기
        return "마법사";
    }
}

// 간단한 전투 테스트
public class BattleTest {
    public static void main(String[] args) {
        // TODO 66: 전사와 마법사 생성하기
        // Warrior: "아서"
        // Mage: "멀린"
        Warrior warrior = new Warrior("아서");
        Mage mage = new Mage("멀린");

        // TODO 67: 캐릭터 정보 출력하기
        // 두 캐릭터의 toString() 결과 출력
        System.out.println("=== 초기 상태 ===");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println();

        // TODO 68: 전투 시뮬레이션하기
        // 전사가 마법사를 공격
        // 마법사가 전사를 공격
        // 전사가 특수 스킬 사용
        // 마법사가 특수 스킬 사용
        System.out.println("=== 전투 시작 ===");
        warrior.attack(mage);

        System.out.println();
        mage.attack(warrior);

        System.out.println();
        warrior.useSpecialSkill(mage);

        System.out.println();
        mage.useSpecialSkill(warrior);
        // TODO 69: 최종 상태 출력하기
        // 두 캐릭터의 생존 여부와 현재 정보 출력
        System.out.println(warrior);

        System.out.println();
        System.out.println("=== 최종 상태 ===");
        System.out.println(warrior);
        System.out.println(mage);
    }
}