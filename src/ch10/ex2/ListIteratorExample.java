package ch10.ex2;

import java.util.*;

public class ListIteratorExample {

    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        playlist.add("Song D");
        playlist.add("Song E");

        System.out.println("원본 재생목록: " + playlist);

        // ListIterator 생성
        ListIterator<String> iter = playlist.listIterator();

        // 앞으로 이동하며 출력
        System.out.println("\n=== 정방향 재생 ===");
        while (iter.hasNext()) {
            String song = iter.next();
            System.out.println("재생 중: " + song);

            // Song C 뒤에 새 곡 추가
            if (song.equals("Song C")) {
                iter.add("Song C-2");
                System.out.println("  -> 새 곡 추가됨");
            }
        }

        // 뒤로 이동하며 출력
        System.out.println("\n=== 역방향 재생 ===");
        while (iter.hasPrevious()) {
            String song = iter.previous();
            System.out.println("재생 중: " + song);

            // Song B를 새 버전으로 교체
            if (song.equals("Song B")) {
                iter.set("Song B (Remastered)");
                System.out.println("  -> 리마스터 버전으로 교체");
            }
        }

        System.out.println("\n최종 재생목록: " + playlist);

        // 특정 위치에서 시작
        System.out.println("\n=== 중간부터 재생 ===");
        ListIterator<String> midIter = playlist.listIterator(3);
        System.out.println("현재 위치: " + midIter.nextIndex());

        // 앞뒤로 한 곡씩
        if (midIter.hasNext()) {
            System.out.println("다음 곡: " + midIter.next());
        }
        if (midIter.hasPrevious()) {
            System.out.println("이전 곡: " + midIter.previous());
        }
    }
}