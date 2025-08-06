package ch07.ex4;

import java.util.Map;
import java.util.stream.Collectors;

public class ConfigurationExample {
    record DatabaseConfig(String host, int port, String database,
                          String username, String password, Map<String,String> options) {
        public String getConnectionUrl() {
            String optStr = options.entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue())
                    .collect(Collectors.joining("&"));
            return "jdbc:mysql://" + host + ":" + port + "/" + database + "?" + optStr;
        }
    }
    record ServerConfig(int port, String contextPath, int maxConnections, int timeout) {}
    record AppConfig(String appName, String version,
                     DatabaseConfig database, ServerConfig server, boolean debugMode) {}

    public static void main(String[] args) {
        DatabaseConfig db = new DatabaseConfig("localhost", 3306, "myapp", "user", "pass",
                Map.of("useSSL","false","serverTimezone","UTC","characterEncoding","UTF-8"));
        ServerConfig server = new ServerConfig(8080, "/api", 100, 30);
        AppConfig app = new AppConfig("MyApplication", "1.0.0", db, server, true);

        System.out.println("=== 애플리케이션 설정 ===");
        System.out.println("앱 이름: " + app.appName());
        System.out.println("버전: " + app.version());
        System.out.println("디버그 모드: " + app.debugMode());

        System.out.println("\n=== 데이터베이스 설정 ===");
        System.out.println("호스트: " + app.database().host());
        System.out.println("포트: " + app.database().port());
        System.out.println("연결 URL: " + app.database().getConnectionUrl());

        System.out.println("\n=== 서버 설정 ===");
        System.out.println("포트: " + app.server().port());
        System.out.println("컨텍스트 경로: " + app.server().contextPath());
        System.out.println("최대 연결 수: " + app.server().maxConnections());
    }
}
