package ch03.ex5;

import textio.TextIO;

import textio.TextIO;

public class TemperatureAdvice {
    public static void main(String[] args) {
        System.out.print("현재 온도를 입력하세요 (섭씨): ");
        double temp = TextIO.getlnDouble();

        String advice;
        String clothing;

        if (temp < -20) {
            advice = "매우 춥습니다. 외출을 자제하세요.";
            clothing = "두꺼운 코트, 목도리, 장갑, 모자";
        } else if (temp < -10) {
            advice = "매우 춥습니다. 외출을 자제하세요.";
            clothing = "두꺼운 코트, 목도리, 장갑, 모자";
        } else if (temp < 0) {
            advice = "춥습니다. 따뜻하게 입으세요.";
            clothing = "겨울 코트, 목도리";
        } else if (temp < 10) {
            advice = "쌀쌀합니다.";
            clothing = "자켓이나 가디건";
        } else if (temp < 20) {
            advice = "선선합니다.";
            clothing = "긴팔 셔츠";
        } else if (temp < 25) {
            advice = "쾌적한 날씨입니다.";
            clothing = "반팔이나 긴팔";
        } else if (temp < 30) {
            advice = "따뜻합니다.";
            clothing = "반팔 셔츠";
        } else if (temp < 35) {
            advice = "덥습니다. 수분을 충분히 섭취하세요.";
            clothing = "가벼운 옷";
        } else {
            advice = "매우 덥습니다. 야외 활동을 자제하세요.";
            clothing = "최대한 가벼운 옷";
        }

        System.out.println("\n=== 날씨 정보 ===");
        System.out.printf("온도: %.1f°C%n", temp);
        System.out.println("조언: " + advice);
        System.out.println("추천 복장: " + clothing);

        // ⚠️ 극한 날씨 경고
        if (temp < -20 || temp > 40) {
            System.out.println("⚠️ 극한 날씨 주의!");
        }
    }
}

