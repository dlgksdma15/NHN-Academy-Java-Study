package ch02.ex4;

import textio.TextIO;

public class WriteToFile {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 일기를 파일에 저장하는 프로그램을 만드세요
        System.out.println("=== 일기장 프로그램 ===");

        System.out.print("날짜 (예: 2024-01-15): ");
        String date = TextIO.getln();

        System.out.print("날씨: ");
        String weather = TextIO.getln();

        System.out.println("일기 내용을 입력하세요 (종료: 빈 줄 입력):");

        StringBuilder diaryContent = new StringBuilder();
        diaryContent.append("날짜: ").append(date).append("\n");
        diaryContent.append("날씨: ").append(weather).append("\n\n");

        while (true) {
            String line = TextIO.getln();
            if (line.isEmpty()) break;
            diaryContent.append(line).append("\n");
        }

        String fileName = "diary_" + date + ".txt";
        TextIO.writeFile(fileName);
        TextIO.putln(diaryContent.toString());
        TextIO.writeStandardOutput();

        System.out.printf("\n일기가 %s 파일에 저장되었습니다.\n", fileName);
        System.out.println(System.getProperty("user.dir"));


    }
}
