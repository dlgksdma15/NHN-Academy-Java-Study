package ch03.ex6;

public class FallThroughExample {
    public static void main(String[] args) {
        int month = 2;

        System.out.println("월: " + month);
        System.out.println("해당 월과 이후 월들:");

        // 의도적인 fall-through 사용
        switch (month) {
            case 1:
                System.out.println("1월 - 새해");
            case 2:
                System.out.println("2월 - 설날");
            case 3:
                System.out.println("3월 - 봄의 시작");
            case 4:
                System.out.println("4월 - 벚꽃");
            case 5:
                System.out.println("5월 - 어린이날");
            case 6:
                System.out.println("6월 - 호국보훈의 달");
            case 7:
                System.out.println("7월 - 여름 시작");
            case 8:
                System.out.println("8월 - 휴가철");
            case 9:
                System.out.println("9월 - 가을 시작");
            case 10:
                System.out.println("10월 - 단풍");
            case 11:
                System.out.println("11월 - 수능");
            case 12:
                System.out.println("12월 - 크리스마스");
                break;
            default:
                System.out.println("잘못된 월");
        }
    }
}