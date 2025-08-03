package ch04.ex6;

// TODO 11: java.util 패키지만 import하기 (java.awt는 주석)

import java.util.ArrayList;
import java.util.List;

public class NameConflictExample {
    public static void main(String[] args) {
        // TODO 12: java.util.List 사용하기
        List<String> utilList = new ArrayList<>();
        utilList.add("Java");
        utilList.add("Python");

        // TODO 13: java.awt.List를 전체 이름으로 사용하기
        java.awt.List awtList = new java.awt.List();
        awtList.add("HTML");
        awtList.add("CSS");

        // TODO 14: 결과 출력하기
        System.out.println("util.List: " + utilList);
        System.out.println("awt.List 항목 수: " + awtList.getItemCount());
    }
}
