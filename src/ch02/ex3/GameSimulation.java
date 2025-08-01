package ch02.ex3;

public class GameSimulation {
    // TODO: 게임 상태 열거형을 정의하세요
    enum GameState { MENU, PLAYING, PAUSED, GAME_OVER }

    // TODO: 방향 열거형을 정의하세요
    enum Direction { NORTH, SOUTH, EAST, WEST }

    public static void main(String[] args) {
        // TODO: 게임 상태를 관리하세요
        // 힌트:
        GameState state = GameState.MENU;
        System.out.println("게임 상태: " + state);

        // TODO: 게임을 시작하세요
        state = GameState.PLAYING;
        System.out.println("게임 시작! 상태: " + state);

        // TODO: 플레이어 초기 위치를 설정하세요
        int x = 5, y = 5;
        System.out.println("시작 위치: (" + x + ", " + y + ")");

        // TODO: 랜덤 이동을 5번 수행하세요
        // 힌트:
        System.out.println("\n랜덤 이동 5회:");
        for (int i = 0; i < 5; i++){
            Direction dir = getRandomDirection();
            System.out.print("이동 방향: " + dir);
            switch (dir){
                case NORTH: y++;break;
                case SOUTH: y--;break;
                case EAST: x++;break;
                case WEST: x--;break;

            }
            System.out.println(" -> 새 위치: (" + x + ", " + y + ")");
        }

        // TODO: 점수를 계산하고 게임을 종료하세요
        int score = (int)(Math.random() * 1000);

        System.out.println("\n최종 점수: " + score);
        state = GameState.GAME_OVER;
        System.out.println("게임 종료! 상태: " + state);

    }

    // TODO: 랜덤 방향을 생성하는 메소드를 구현하세요
    // 힌트:
    // 1. directions = Direction.values() 배열 획득
    // 2. index = (int)(Math.random() * directions.length) 랜덤 인덱스
    // 3. directions[index] 반환
    public static Direction getRandomDirection() {
        // 여기에 코드를 작성하세요
        Direction[] directions = Direction.values();
        int index = (int)(Math.random() * directions.length);
        System.out.println("index = " + index);
        return directions[index];
    }
}