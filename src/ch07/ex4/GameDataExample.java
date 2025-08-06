package ch07.ex4;

import java.util.ArrayList;
import java.util.List;

public class GameDataExample {
    record Stats(int health, int attack, int defense, int speed) {
        public int combatPower() {
            return attack * 2 + defense + speed;
        }
    }

    record Item(String name, String type, int value, Stats bonusStats) {}

    record Character(String name, String job, Stats baseStats, List<Item> inventory) {
        public Stats totalStats() {
            int h = baseStats.health();
            int a = baseStats.attack();
            int d = baseStats.defense();
            int s = baseStats.speed();

            for (Item item : inventory) {
                h += item.bonusStats().health();
                a += item.bonusStats().attack();
                d += item.bonusStats().defense();
                s += item.bonusStats().speed();
            }
            return new Stats(h, a, d, s);
        }

        public Character addItem(Item item) {
            List<Item> newInv = new ArrayList<>(inventory);
            newInv.add(item);
            return new Character(name, job, baseStats, newInv);
        }
    }

    public static void main(String[] args) {
        Item sword = new Item("강철 검", "무기", 1000, new Stats(0, 10, 0, 0));
        Item shield = new Item("철 방패", "방어구", 800, new Stats(0, 0, 8, 0));
        Item boots = new Item("신속의 부츠", "신발", 500, new Stats(0, 0, 2, 5));

        Character warrior = new Character("아서", "전사", new Stats(100, 15, 10, 5), new ArrayList<>());
        warrior = warrior.addItem(sword);
        warrior = warrior.addItem(shield);
        warrior = warrior.addItem(boots);

        System.out.println("=== 캐릭터 정보 ===");
        System.out.println("이름: " + warrior.name());
        System.out.println("직업: " + warrior.job());

        System.out.println("\n기본 스탯:");
        Stats base = warrior.baseStats();
        System.out.printf("체력: %d, 공격력: %d, 방어력: %d, 속도: %d\n",
                base.health(), base.attack(), base.defense(), base.speed());

        System.out.println("\n장착 아이템:");
        for (Item i : warrior.inventory()) {
            System.out.println("- " + i.name() + " (" + i.type() + ")");
        }

        System.out.println("\n총 스탯:");
        Stats total = warrior.totalStats();
        System.out.printf("체력: %d, 공격력: %d, 방어력: %d, 속도: %d\n",
                total.health(), total.attack(), total.defense(), total.speed());
        System.out.println("전투력: " + total.combatPower());
    }
}
