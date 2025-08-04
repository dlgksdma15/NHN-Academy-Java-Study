package ex;

import java.util.*;

interface StringComparaotr{
    int compare(String a, String b);
}
public class StringSortExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("banana", "kiwi", "apple", "cherry"));

        StringComparaotr comp = (a,b) -> a.length() - b.length();

        // 문자열 길이 기준 정렬 람다 작성
        fruits.sort((a, b) -> a.length() - b.length());

        for(int i = 0; i < fruits.size() - 1; i++){
            for(int j = 0; j < fruits.size() - i - 1; j++){
                if(comp.compare(fruits.get(j), fruits.get(j + 1)) > 0){
                    String temp = fruits.get(j);
                    fruits.set(j, fruits.get(j + 1));
                    fruits.set(j+1,temp);
                }
            }
        }

        System.out.println(fruits);
    }
}
