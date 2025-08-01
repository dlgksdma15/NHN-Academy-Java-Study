package ch03.ex1;

public class AbsoluteValue {
    public static void main(String[] args) {
        int[] numbers = {-5, 3, -12, 0, 8, -1};

        System.out.println("절댓값 계산:");

        for (int num : numbers) {
            int absolute;
            /*if(num < 0){
                absolute = Math.abs(num);
            }else{
                absolute = num;
            }*/
            absolute = (num < 0) ? Math.abs(num) : num; // 삼항연산자로 풀기
            System.out.println("|" + num + "| = " + absolute);

        }
    }
}
