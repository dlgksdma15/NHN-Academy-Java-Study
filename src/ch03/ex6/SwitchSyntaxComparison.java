package ch03.ex6;

public class SwitchSyntaxComparison {
    public static void main(String[] args) {
        int dayOfWeek = 3;

        System.out.println("=== 전통적인 switch문 ===");
        traditionalSwitch(dayOfWeek);

        System.out.println("\n=== 새로운 switch문 ===");
        modernSwitch(dayOfWeek);
    }

    // 전통적인 switch문 (break 필수)
    public static void traditionalSwitch(int day) {
        switch (day) {
            case 1:
                System.out.println("월요일");
                System.out.println("새로운 주의 시작");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                System.out.println("주중");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                System.out.println("주말이 코앞!");
                break;
            case 6:
            case 7:
                System.out.println("주말");
                System.out.println("휴식 시간");
                break;
            default:
                System.out.println("잘못된 요일");
        }
    }

    // 새로운 switch문 (break 불필요)
    public static void modernSwitch(int day) {
        switch (day) {
            case 1 -> {
                System.out.println("월요일");
                System.out.println("새로운 주의 시작");
            }
            case 2 -> System.out.println("화요일");
            case 3 -> {
                System.out.println("수요일");
                System.out.println("주중");
            }
            case 4 -> System.out.println("목요일");
            case 5 -> {
                System.out.println("금요일");
                System.out.println("주말이 코앞!");
            }
            case 6, 7 -> {
                System.out.println("주말");
                System.out.println("휴식 시간");
            }
            default -> System.out.println("잘못된 요일");
        }
    }
}