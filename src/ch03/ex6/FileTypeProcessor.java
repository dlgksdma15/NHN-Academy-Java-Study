package ch03.ex6;

public class FileTypeProcessor {
    public static void main(String[] args) {
        String[] files = {
                "document.pdf", "image.jpg", "data.csv",
                "script.js", "style.css", "page.html",
                "archive.zip", "video.mp4", "unknown.xyz"
        };

        for (String filename : files) {
            processFile(filename);
        }
    }

    public static void processFile(String filename) {
        String extension = getFileExtension(filename).toLowerCase();

        String fileType = switch (extension) {
            case "jpg", "jpeg", "png", "gif", "bmp" -> "이미지";
            case "mp4", "avi", "mov", "wmv", "flv" -> "비디오";
            case "mp3", "wav", "aac", "flac", "ogg" -> "오디오";
            case "pdf", "doc", "docx", "txt", "rtf" -> "문서";
            case "html", "htm", " xml" -> "웹 페이지";
            case "css", "js", "java", "py", "cpp" -> "코드";
            case "zip", "rar", "7z", "tar", "gz" -> "압축 파일";
            case "csv", "json", "xml" -> "데이터";
            default -> "알 수 없음";
        };

        String icon = switch (fileType) {
            case "이미지" -> "🖼️";
            case "비디오" -> "🎬";
            case "오디오" -> "🎵";
            case "문서" -> "📄";
            case "웹 페이지" -> "🌐";
            case "코드" -> "💻";
            case "압축 파일" -> "🗜️";
            case "데이터" -> "📊";
            default -> "❓";
        };

        String action = switch (fileType) {
            case "이미지" -> "이미지 뷰어로 열기";
            case "비디오" -> "미디어 플레이어로 재생";
            case "오디오" -> "음악 플레이어로 재생";
            case "문서" -> "문서 편집기로 열기";
            case "웹 페이지" -> "브라우저로 열기";
            case "코드" -> "IDE로 편집";
            case "압축 파일" -> "압축 해제";
            case "데이터" -> "데이터 분석 도구로 열기";
            default -> "시스템 기본 프로그램으로 열기";
        };

        System.out.printf("%s %s (%s) - %s%n",
                icon, filename, fileType, action);
    }

    private static String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        return (lastDot > 0) ? filename.substring(lastDot + 1) : "";
    }
}