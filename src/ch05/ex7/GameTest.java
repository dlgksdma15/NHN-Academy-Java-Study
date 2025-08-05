package ch05.ex7;

/**
 * 게임 설정을 위한 상수 인터페이스
 */
interface GameConstants {
    // 게임 설정 상수들 (모두 public static final)
    int MAX_PLAYERS = 4;
    int MIN_PLAYERS = 2;

    int BOARD_WIDTH = 10;
    int BOARD_HEIGHT = 10;

    int INITIAL_HEALTH = 100;
    int INITIAL_MANA = 50;

    // 게임 상태
    int STATE_WAITING = 0;
    int STATE_PLAYING = 1;
    int STATE_PAUSED = 2;
    int STATE_GAME_OVER = 3;

    // 방향
    int DIRECTION_UP = 0;
    int DIRECTION_RIGHT = 1;
    int DIRECTION_DOWN = 2;
    int DIRECTION_LEFT = 3;
}

// 게임 캐릭터 인터페이스
interface GameCharacter extends GameConstants {
    void move(int direction);
    void attack(GameCharacter target);
    int getHealth();
    int getMana();
    boolean isAlive();
}

// 플레이어 구현
class Player implements GameCharacter {
    private String name;
    private int health;
    private int mana;
    private int x, y;

    public Player(String name) {
        // TODO 19: 플레이어 초기화하기
        // name 설정
        // health를 INITIAL_HEALTH로 초기화
        // mana를 INITIAL_MANA로 초기화
        // x, y를 보드 중앙으로 설정 (BOARD_WIDTH/2, BOARD_HEIGHT/2)
        this.name = name;
        health = INITIAL_HEALTH;
        mana = INITIAL_MANA;
        x = BOARD_WIDTH / 2;
        y = BOARD_HEIGHT / 2;
    }

    @Override
    public void move(int direction) {
        // TODO 20: 방향에 따라 이동하기
        // DIRECTION_UP: y > 0이면 y--
        // DIRECTION_DOWN: y < BOARD_HEIGHT - 1이면 y++
        // DIRECTION_LEFT: x > 0이면 x--
        // DIRECTION_RIGHT: x < BOARD_WIDTH - 1이면 x++
        // "[name] 이동: (x, y)" 출력
        switch (direction){
            case 0:
                if(y > 0){
                    y--;
                    break;
                }
                break;
            case 1:
                if(x < BOARD_WIDTH - 1){
                    x++;
                    break;
                }
                break;
            case 2:
                if(y < BOARD_HEIGHT - 1){
                    y++;
                }
                break;
            case 3:
                if(x > 0){
                    x--;
                    break;
                }
                break;
        }
        System.out.println(name + "이동: " + "(" + x + "," + y + ")");
    }

    @Override
    public void attack(GameCharacter target) {
        // TODO 21: 공격 구현하기
        // "[name]이(가) 공격!" 출력
        System.out.println(name + "이(가) 공격!");
    }

    @Override
    public int getHealth() {
        // TODO 22: health 반환하기
        return health;
    }

    @Override
    public int getMana() {
        // TODO 23: mana 반환하기
        return mana;
    }

    @Override
    public boolean isAlive() {
        // TODO 24: health > 0인지 반환하기
        if(health > 0){
            return true;
        }
        return false;
    }
}

// 게임 관리자
class GameManager implements GameConstants {
    private GameCharacter[] players;
    private int gameState;
    private int playerCount;

    public GameManager() {
        // TODO 25: 게임 매니저 초기화하기
        // players를 MAX_PLAYERS 크기로 생성
        // gameState를 STATE_WAITING으로 설정
        // playerCount를 0으로 설정
        players = new GameCharacter[MAX_PLAYERS];
        gameState = STATE_WAITING;
        playerCount = 0;
    }

    public void addPlayer(GameCharacter player) {
        // TODO 26: 플레이어 추가하기
        // playerCount < MAX_PLAYERS이면 players 배열에 추가
        // playerCount 증가
        if(playerCount < MAX_PLAYERS){
            players[playerCount] = player;
            playerCount++;
        }
    }

    public void startGame() {
        // TODO 27: 게임 시작하기
        // playerCount >= MIN_PLAYERS이면:
        //   gameState를 STATE_PLAYING으로 변경
        //   "게임 시작!" 출력
        // 아니면:
        //   "최소 [MIN_PLAYERS]명이 필요합니다." 출력
        if(playerCount >= MIN_PLAYERS){
            gameState = STATE_PLAYING;
            System.out.println("게임 시작!");
        }else{
            System.out.println("최소 [" + MIN_PLAYERS +"]"+"명이 필요합니다.");
        }
    }

    private int getPlayerCount() {
        return playerCount;
    }
}

// 테스트
public class GameTest {
    public static void main(String[] args) {
        // TODO 28: GameManager 생성하기
        GameManager gameManager = new GameManager();
        
        // TODO 29: Player 생성하고 추가하기
        // "용사"와 "마법사" 플레이어 생성
        // GameManager에 추가
        Player warrior = new Player("용사");
        Player wizard = new Player("마법사");

        gameManager.addPlayer(warrior);
        gameManager.addPlayer(warrior);

        // TODO 30: 게임 시작 시도하기
        gameManager.startGame();

        // TODO 31: 플레이어들 이동시키기
        // 용사는 UP, RIGHT로 이동
        // 마법사는 DOWN, LEFT로 이동
        warrior.move(GameConstants.DIRECTION_UP);
        warrior.move(GameConstants.DIRECTION_RIGHT);
        wizard.move(GameConstants.DIRECTION_DOWN);
        wizard.move(GameConstants.DIRECTION_LEFT);

        // TODO 32: 서로 공격하기
        // 용사가 마법사를 공격
        // 마법사가 용사를 공격
        // 게임 시작! 
        // 용사 이동: (5, 4) 
        // 용사 이동: (6, 4) 
        // 마법사 이동: (5, 6) 
        // 마법사 이동: (4, 6) 
        // 용사이(가) 공격! 
        // 마법사이(가) 공격!
        warrior.attack(wizard);
        wizard.attack(warrior);

    }
}

