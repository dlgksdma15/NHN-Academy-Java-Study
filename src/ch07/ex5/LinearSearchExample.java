package ch07.ex5;

public class LinearSearchExample {
    public static void main(String[] args) {
        int[] numbers = {45, 23, 67, 12, 89, 34, 78};
        String[] names = {"김철수", "이영희", "박민수", "최지영", "홍길동"};
        
        // 숫자 검색
        int target = 67;
        int index = linearSearch(numbers, target);
        System.out.println(target + "의 위치: " + index);
        
        // 문자열 검색
        String targetName = "박민수";
        int nameIndex = linearSearchString(names, targetName);
        System.out.println(targetName + "의 위치: " + nameIndex);
        
        // 존재하지 않는 값 검색
        int notFound = linearSearch(numbers, 100);
        System.out.println("100의 위치: " + notFound + " (없음)");
    }
    
    // TODO: 정수 배열에서 선형 검색 메서드를 작성하세요
    // 메서드명: linearSearch, 매개변수: int[] array, int target
    // 반환값: 찾은 요소의 인덱스, 없으면 -1
    // 힌트: for 루프로 배열을 순차적으로 탐색
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // TODO: 문자열 배열에서 선형 검색 메서드를 작성하세요
    // 메서드명: linearSearchString, 매개변수: String[] array, String target
    // 반환값: 찾은 요소의 인덱스, 없으면 -1
    // 힌트: String 비교시 equals() 메서드 사용
    public static int linearSearchString(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}