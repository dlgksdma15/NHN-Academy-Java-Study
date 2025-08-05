package ch05.ex8;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 익명 클래스를 사용한 스레드와 타이머 예제
 */
public class ThreadExample {

    public static void main(String[] args) {
        System.out.println("메인 스레드 시작");

        // TODO 80: 익명 클래스로 Thread 생성
        Thread worker1 = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Worker 1: " + i);
                        Thread.sleep(1000); // 1초
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // TODO 81: 익명 클래스로 Runnable 구현
        Thread worker2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Worker 2: " + i);
                        Thread.sleep(1500); // 1.5초
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // TODO 82: 람다 표현식으로 스레드 생성
        Thread worker3 = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Worker 3: " + i);
                    Thread.sleep(2000); // 2초
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // TODO 83: Timer와 익명 클래스로 TimerTask 구현
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                count++;
                System.out.println("타이머 실행: " + count + "회");
                if (count == 3) {
                    System.out.println("타이머 종료");
                    timer.cancel();
                }
            }
        }, 1000, 2000); // 1초 후 시작, 2초마다 실행

        // TODO 84: 모든 스레드 시작
        worker1.start();
        worker2.start();
        worker3.start();

        System.out.println("모든 스레드 시작됨");
    }
}
