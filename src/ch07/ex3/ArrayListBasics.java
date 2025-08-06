package ch07.ex3;

import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        // TODO: ArrayList를 생성하세요
        // 제네릭 타입을 String으로 지정
        ArrayList<String> cities = new ArrayList<String>();

        // TODO: 요소들을 추가하세요
        // "서울", "부산", "대구", "인천" 순으로 추가
        cities.add("서울");
        cities.add("부산");
        cities.add("광주");
        cities.add("대구");
        cities.add("인천");


        System.out.println("초기 도시 목록: " + cities);
        // TODO: 특정 위치(인덱스 2)에 "광주"를 삽입하세요

        System.out.println("광주 추가 후: " + cities);

        // TODO: 첫 번째 요소를 가져와서 firstCity 변수에 저장하세요
        String firstCity =  cities.get(0);
        System.out.println("첫 번째 도시: " + firstCity);

        // TODO: 인덱스 1의 요소를 "울산"으로 수정하세요
        cities.set(1,"울산");
        System.out.println("부산을 울산으로 변경: " + cities);

        // TODO: ArrayList의 크기를 출력하세요
        System.out.println("도시 개수: " + cities.size());

        // TODO: "서울"이 포함되어 있는지 확인하세요
        boolean hasSeoul = cities.contains("서울");
        System.out.println("서울 포함 여부: " + hasSeoul);

        // TODO: "대구"의 인덱스를 찾으세요
        int daeguIndex = cities.indexOf("대구");
        System.out.println("대구의 인덱스: " + daeguIndex);

        // TODO: "광주"를 제거하고 첫 번째 요소(인덱스 0)도 제거하세요
        cities.remove("광주");
        cities.remove(0);
        System.out.println("삭제 후: " + cities);

        // TODO: 모든 요소를 제거하세요
        cities.clear();
        System.out.println("clear() 후 크기: " + cities.size());
    }
}