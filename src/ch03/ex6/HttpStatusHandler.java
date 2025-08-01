package ch03.ex6;

public class HttpStatusHandler {
    public static void main(String[] args) {
        int[] statusCodes = {200, 400, 401, 403, 404, 500, 503};

        for (int statusCode : statusCodes) {
            handleHttpStatus(statusCode);
        }
    }

    public static void handleHttpStatus(int statusCode) {
        String message = switch (statusCode / 100) {
            case 1 -> "정보 응답";
            case 2 -> "성공";
            case 3 -> "리다이렉션";
            case 4 -> "클라이언트 오류";
            case 5 -> "서버 오류";
            default -> "알 수 없는 상태";
        };

        String detail = switch (statusCode) {
            case 200 -> "OK - 요청 성공";
            case 201 -> "Created - 리소스 생성됨";
            case 400 -> "Bad Request - 잘못된 요청";
            case 401 -> "Unauthorized - 인증 필요";
            case 403 -> "Forbidden - 접근 금지";
            case 404 -> "Not Found - 리소스 없음";
            case 500 -> "Internal Server Error - 서버 내부 오류";
            case 503 -> "Service Unavailable - 서비스 사용 불가";
            default -> "기타 상태 코드";
        };

        boolean isError = switch (statusCode / 100) {
            case 4, 5 -> true;
            default -> false;
        };

        System.out.printf("[%d] %s - %s %s%n",
                statusCode, message, detail, isError ? "⚠️" : "✅");
    }
}