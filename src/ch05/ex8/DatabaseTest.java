package ch05.ex8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 데이터베이스 연결을 관리하는 클래스
 */
class DatabaseManager {

    // 연결 설정을 저장하는 정적 중첩 클래스
    public static class ConnectionConfig {
        private String host;
        private int port;
        private String database;
        private String username;
        private String password;

        // Builder 패턴
        public static class Builder {
            private String host = "localhost";
            private int port = 3306;
            private String database;
            private String username;
            private String password;

            public Builder host(String host) {
                // TODO 19
                this.host = host;
                return this;
            }

            public Builder port(int port) {
                // TODO 20
                this.port = port;
                return this;
            }

            public Builder database(String database) {
                // TODO 21
                this.database = database;
                return this;
            }

            public Builder username(String username) {
                // TODO 22
                this.username = username;
                return this;
            }

            public Builder password(String password) {
                // TODO 23
                this.password = password;
                return this;
            }

            public ConnectionConfig build() {
                // TODO 24
                ConnectionConfig config = new ConnectionConfig();
                config.host = this.host;
                config.port = this.port;
                config.database = this.database;
                config.username = this.username;
                config.password = this.password;
                return config;
            }
        }

        private ConnectionConfig() {} // private 생성자

        public String getConnectionUrl() {
            // TODO 25
            return "jdbc:mysql://" + host + ":" + port + "/" + database;
        }

        @Override
        public String toString() {
            // TODO 26
            return "ConnectionConfig[" + username + "@" + host + ":" + port + "]";
        }
    }

    // 쿼리 결과를 저장하는 정적 중첩 클래스
    public static class QueryResult {
        private List<Map<String, Object>> rows;
        private int affectedRows;
        private long executionTime;

        public QueryResult() {
            this.rows = new ArrayList<>();
        }

        public void addRow(Map<String, Object> row) {
            // TODO 27
            rows.add(row);
        }

        public int getRowCount() {
            // TODO 28
            return rows.size();
        }

        public List<Map<String, Object>> getRows() {
            // TODO 29
            return new ArrayList<>(rows);
        }
    }

    private ConnectionConfig config;

    public DatabaseManager(ConnectionConfig config) {
        // TODO 30
        this.config = config;
    }

    public void connect() {
        System.out.println("데이터베이스 연결: " + config.getConnectionUrl());
    }

    public QueryResult executeQuery(String sql) {
        System.out.println("쿼리 실행: " + sql);
        // TODO 31
        QueryResult result = new QueryResult();
        Map<String, Object> row = new HashMap<>();
        row.put("id", 1);
        row.put("name", "Test");
        result.addRow(row);
        return result;
    }
}

// 테스트
class DatabaseTest {
    public static void main(String[] args) {
        // TODO 32: Builder 패턴으로 ConnectionConfig 생성하기
        DatabaseManager.ConnectionConfig config =
                new DatabaseManager.ConnectionConfig.Builder()
                        .host("192.168.1.100")
                        .port(3306)
                        .database("mydb")
                        .username("admin")
                        .password("secret")
                        .build();

        // TODO 33: 연결 설정 정보 출력하기
        System.out.println(config);
        System.out.println("URL: " + config.getConnectionUrl());

        // TODO 34: DatabaseManager 생성하고 연결하기
        DatabaseManager db = new DatabaseManager(config);
        db.connect();

        // TODO 35: 쿼리 실행하고 결과 출력하기
        DatabaseManager.QueryResult result = db.executeQuery("SELECT * FROM users");
        System.out.println("결과 행 수: " + result.getRowCount());
    }
}
