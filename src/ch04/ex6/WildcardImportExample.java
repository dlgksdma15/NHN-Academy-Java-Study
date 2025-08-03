package ch04.ex6;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WildcardImportExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        set.add("banana");
        set.add("apple");
        set.add("banana");
        
        map.put("김철수", 90);
        map.put("이영희", 85);

        System.out.println("리스트 데이터: " + list);
        System.out.println("세트 데이터: " + set);
        System.out.println("맵 데이터: " + map);

        File currentDir = new File(".");

        try {
            System.out.println("현재 디렉토리: " + currentDir.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
