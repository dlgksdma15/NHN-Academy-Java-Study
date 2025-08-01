package ch03.ex6;

import textio.TextIO;

public class BrowserDetector {
    public static void main(String[] args) {
        System.out.print("브라우저명을 입력하세요: ");
        String browser = TextIO.getln().toLowerCase();

        // TODO: switch 표현식으로 브라우저 정보 설정
        // 힌트: yield 사용
        String engineInfo = switch (browser){
            case "chrome" -> "Chromium 기반 브라우저입니다.\n" +
                    "Blink 렌더링 엔진을 사용합니다.\n" +
                    "V8 JavaScript 엔진을 사용합니다.";
            case "firefox" -> "Mozilla Foundation의 브라우저입니다.\n" +
                    "Gecko 렌더링 엔진을 사용합니다.\n" +
                    "SpiderMonkey JavaScript 엔진을 사용합니다.";
            default -> "현재로써는 브라우저 정보가 없습니다.";
        };

        System.out.println("\n브라우저 정보:");
        System.out.println(engineInfo);

        // TODO: 보안 등급 평가
        // 힌트: switch 표현식
        String securityLevel = switch (browser) {
            case "chrome","firefox" -> "높음";
            default -> "미정";
        };

        System.out.println("보안 수준: " + securityLevel);
    }
}