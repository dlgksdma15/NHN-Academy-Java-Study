package ch04.ex3;

public class ThreeNPlusOne {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 시퀀스 프로그램 ===\n");

        // TODO 18: 예제 시퀀스 실행하기
        System.out.println("예제 시퀀스:");
        System.out.println();
        System.out.println();

        // TODO 19: 추가 정보 출력하기
        int start = 3;
        System.out.println("추가 정보:");
        print3NSequence(start);
    }

    // TODO 20: 3N+1 시퀀스 출력 메서드 구현하기
    static void print3NSequence(int startingValue) {
        int temp = startingValue;
        while(startingValue != 1){
            System.out.print(startingValue + " -> ");
            if(startingValue % 2 == 1){
                startingValue = (startingValue * 3) + 1;
            }else{
                startingValue = startingValue / 2;
            }
        }
        System.out.println("1");
        System.out.printf("시작값 %d의 시퀀스 길이: %d\n",temp, getSequenceLength(temp));
        System.out.printf("시작값 %d의 최대값: %d",temp ,getMaxValue(temp));
    }

    // TODO 21: 시퀀스 길이 계산 메서드 구현하기
    static int getSequenceLength(int startingValue) {
        int count = 1;
        while(startingValue != 1){
            if(startingValue % 2 == 1){
                startingValue = (startingValue * 3) + 1;
                count++;
            }else{
                startingValue = startingValue / 2;
                count++;
            }
        }
        return count;
    }

    // TODO 22: 시퀀스의 최대값 찾기 메서드 구현하기
    static int getMaxValue(int startingValue) {
        int max = 0;
        while(startingValue != 1){
            if(startingValue % 2 == 1){
                startingValue = (startingValue * 3) + 1;
                if(max < startingValue){
                    max = startingValue;
                }
            }else{
                startingValue = startingValue / 2;
                if(max < startingValue){
                    max = startingValue;
                }
            }
        }
        return max;
    }
}