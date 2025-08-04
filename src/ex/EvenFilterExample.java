package ex;

import java.util.Arrays;
import java.util.List;

interface Predicate1<T> {
    boolean test(T num);
}
public class EvenFilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        Predicate1<Integer> isEven = n -> n % 2 ==0 ;

        System.out.println("짝수: ");
        for(int num : numbers){
            if(isEven.test(num)){
                System.out.print(num + " ");
            }
        }
    }
}
