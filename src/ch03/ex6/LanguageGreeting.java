package ch03.ex6;

import textio.TextIO;

public class LanguageGreeting {
    public static void main(String[] args) {
        System.out.print("언어를 입력하세요 (한국어/영어/일본어/중국어): ");
        String language = TextIO.getln().toLowerCase();

        // TODO: switch 표현식으로 인사말 설정
        // 힌트: 여러 case 값 묶기
        String greeting = switch (language){
            case "한국어" -> "안녕하세요!";
            case "영어" -> "Hello";
            case "일본어" -> "こんにちは!";
            case "중국어" -> "你好!";
            default -> "지원되지 않는 언어입니다.";
        };


        System.out.println("인사말: " + greeting);

        // TODO: 언어별 추가 정보 출력
        // 힌트: switch문 사용

        // 여기에 코드를 작성하세요
        switch (language){
            case "한국어":
                System.out.println("사용 국가: 대한민국");
                break;
            case "영어":
                System.out.println("사용 국가: 미국, 영국 등");
                break;
            case "일본어":
                System.out.println("사용 국가: 일본");
                break;
            case "중국어":
                System.out.println("사용 국가: 중국, 대만 등");
                break;
            default:
                System.out.println("추가 정보를 제공할 수 없습니다.");
        }
    }
}