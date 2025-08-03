package ch04.ex6;

// TODO 1: 필요한 클래스들을 개별적으로 import하기

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BasicImportExample {
    public static void main(String[] args) {
        // TODO 2: Scanner 객체 생성하고 사용자 이름 입력받기

        // TODO 3: Random 객체로 1~100 사이의 행운의 숫자 생성하기

        // TODO 4: ArrayList 생성하고 취미 3개 추가하기

        // TODO 5: 결과 출력하기
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        Random rand = new Random();
        int luckyNumber = rand.nextInt(100) + 1;

        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("독서");
        hobbies.add("운동");
        hobbies.add("요리");

        System.out.println(name + "님의 행운의 숫자는 " + luckyNumber + "입니다.");
        System.out.println("취미: " + hobbies);

    }
}
