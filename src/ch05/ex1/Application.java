package ch05.ex1;

/**
 * 설정 클래스 - 변경 가능한 설정값들
 */
class Configuration {
    private String serverUrl;
    private int port;
    private boolean debugMode;

    public Configuration(String serverUrl, int port) {
        this.serverUrl = serverUrl;
        this.port = port;
        this.debugMode = false;
    }

    // Getter/Setter
    public String getServerUrl() { return serverUrl; }
    public void setServerUrl(String url) { this.serverUrl = url; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public boolean isDebugMode() { return debugMode; }
    public void setDebugMode(boolean debug) { this.debugMode = debug; }

    public void printConfig() {
        System.out.println("Server: " + serverUrl + ":" + port);
        System.out.println("Debug Mode: " + debugMode);
    }
}

/**
 * 애플리케이션 클래스
 */
public class Application {
    // final 객체 변수 - 참조는 변경 불가, 내용은 변경 가능
    private final Configuration config;
    private final String appName;

    public Application(String appName) {
        this.appName = appName;
        // config 객체 생성 (이후 다른 객체로 변경 불가)
        this.config = new Configuration("localhost", 8080);
    }

    // 설정 변경 메서드들
    public void changeServer(String newUrl, int newPort) {
        // config = new Configuration(newUrl, newPort);  // 오류! final 변수

        // 하지만 객체 내부는 변경 가능
        config.setServerUrl(newUrl);
        config.setPort(newPort);
        System.out.println("서버 설정이 변경되었습니다.");
    }

    public void enableDebugMode() {
        config.setDebugMode(true);
        System.out.println("디버그 모드가 활성화되었습니다.");
    }

    public void showInfo() {
        System.out.println("\n=== " + appName + " 설정 ===");
        config.printConfig();
    }

    public static void main(String[] args) {
        Application app = new Application("MyApp");

        // 초기 설정
        app.showInfo();

        // 설정 변경 (가능)
        app.changeServer("192.168.1.100", 9090);
        app.enableDebugMode();

        // 변경된 설정
        app.showInfo();

        // final 배열 예제
        final int[] numbers = {1, 2, 3, 4, 5};
        // numbers = new int[10];  // 오류! final 변수

        // 하지만 배열 내용은 변경 가능
        numbers[0] = 10;
        numbers[1] = 20;

        System.out.println("\n변경된 배열:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}