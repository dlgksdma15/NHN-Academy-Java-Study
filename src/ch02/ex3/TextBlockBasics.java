package ch02.ex3;

public class TextBlockBasics {
    public static void main(String[] args) {
        // 기존 방식으로 여러 줄 문자열 만들기
        String oldWay = "첫 번째 줄\n" + "두 번째 줄\n" + "세 번째 줄";

        // 텍스트 블록 방식으로 여러 줄 문자열 만들기
        String newWay = """
                첫 번째 줄
                두 번째 줄
                세 번째 줄""";

        // 두 방식의 결과 비교 출력
        System.out.println("기존 방식:");
        System.out.println(oldWay);

        System.out.println("\n텍스트 블록:");
        System.out.println(newWay);

        // JSON 형식의 텍스트 블록
        String jsonData = """
                {
                    "name": "홍길동",
                    "age": 30,
                    "address": "서울시 강남구"
                }""";

        System.out.println(jsonData);
    }
}