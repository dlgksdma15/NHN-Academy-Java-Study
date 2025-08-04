package ex;

import java.util.Date;
import java.util.Random;

public class BuilderPractice {
    public static void main(String[] args) {
        /*StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 1000; i++){
            builder.append(i).append(" ");
        }
        String result = builder.toString();
        System.out.println(result);*/

        Random random = new Random();

        for(int i = 0; i < 6; i++){
            int n = random.nextInt(6) + 1;
            System.out.print(n + " ");
        }
        System.out.println();
        Date now = new Date();
        System.out.println("현재 시간: " + now);



    }
}
