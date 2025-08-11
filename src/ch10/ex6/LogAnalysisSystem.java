package ch10.ex6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class LogAnalysisSystem {
    private static final Pattern LOG_PATTERN = Pattern.compile(
            "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}) (\\w+) (.+)"
    );

    public static void main(String[] args) {
        List<String> logLines = generateSampleLogs();

        LogAnalysisSystem analyzer = new LogAnalysisSystem();
        analyzer.analyzeLogs(logLines);
    }

    private void analyzeLogs(List<String> logLines) {
        System.out.println("=== 로그 분석 시스템 ===");
        System.out.println("총 로그 라인 수: " + logLines.size());

        // 로그 파싱
        List<LogEntry> logs = logLines.stream()
                .map(this::parseLogLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println("파싱된 로그 수: " + logs.size());

        // 1. 로그 레벨별 통계
        System.out.println("\n1. 로그 레벨별 통계:");
        Map<String, Long> levelStats = logs.stream()
                .collect(Collectors.groupingBy(
                        LogEntry::getLevel,
                        Collectors.counting()
                ));

        levelStats.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("%s: %d건%n", entry.getKey(), entry.getValue()));

        // 2. 시간대별 로그 분포
        System.out.println("\n2. 시간대별 로그 분포:");
        Map<Integer, Long> hourlyLogs = logs.stream()
                .collect(Collectors.groupingBy(
                        log -> log.getTimestamp().getHour(),
                        Collectors.counting()
                ));

        hourlyLogs.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("%02d시: %d건%n", entry.getKey(), entry.getValue()));

        // 3. ERROR 로그 분석
        System.out.println("\n3. ERROR 로그 상세 분석:");
        List<LogEntry> errorLogs = logs.stream()
                .filter(log -> "ERROR".equals(log.getLevel()))
                .collect(Collectors.toList());

        System.out.println("총 ERROR 수: " + errorLogs.size());

        // ERROR 패턴 분석
        Map<String, Long> errorPatterns = errorLogs.stream()
                .map(log -> extractErrorType(log.getMessage()))
                .collect(Collectors.groupingBy(
                        errorType -> errorType,
                        Collectors.counting()
                ));

        System.out.println("ERROR 유형별 통계:");
        errorPatterns.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("  %s: %d건%n", entry.getKey(), entry.getValue()));

        // 4. 성능 이슈 탐지 (연속된 ERROR나 WARN)
        System.out.println("\n4. 성능 이슈 탐지:");
        List<List<LogEntry>> issuePatterns = findConsecutiveIssues(logs);

        System.out.println("연속된 이슈 패턴 수: " + issuePatterns.size());
        issuePatterns.stream()
                .limit(3)
                .forEach(pattern -> {
                    System.out.printf("이슈 시작: %s, 지속: %d개 로그%n",
                            pattern.get(0).getTimestamp(),
                            pattern.size());
                });

        // 5. 키워드 기반 검색
        System.out.println("\n5. 키워드 검색 결과:");
        searchKeywords(logs, Arrays.asList("exception", "timeout", "failed"));

        // 6. 로그 트렌드 분석 (시간당 ERROR 비율)
        System.out.println("\n6. 시간당 ERROR 비율:");
        Map<Integer, Double> errorRates = logs.stream()
                .collect(Collectors.groupingBy(
                        log -> log.getTimestamp().getHour(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                hourLogs -> {
                                    long errorCount = hourLogs.stream()
                                            .filter(log -> "ERROR".equals(log.getLevel()))
                                            .count();
                                    return (double) errorCount / hourLogs.size() * 100;
                                }
                        )
                ));

        errorRates.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("%02d시: %.1f%%%n", entry.getKey(), entry.getValue()));
    }

    private LogEntry parseLogLine(String line) {
        var matcher = LOG_PATTERN.matcher(line);
        if (matcher.matches()) {
            try {
                LocalDateTime timestamp = LocalDateTime.parse(
                        matcher.group(1),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                );
                String level = matcher.group(2);
                String message = matcher.group(3);
                return new LogEntry(timestamp, level, message);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String extractErrorType(String message) {
        if (message.toLowerCase().contains("nullpointer")) return "NullPointerException";
        if (message.toLowerCase().contains("timeout")) return "TimeoutException";
        if (message.toLowerCase().contains("connection")) return "ConnectionException";
        if (message.toLowerCase().contains("sql")) return "SQLException";
        if (message.toLowerCase().contains("io")) return "IOException";
        return "Other";
    }

    private List<List<LogEntry>> findConsecutiveIssues(List<LogEntry> logs) {
        List<List<LogEntry>> issues = new ArrayList<>();
        List<LogEntry> currentIssue = new ArrayList<>();

        for (LogEntry log : logs) {
            if ("ERROR".equals(log.getLevel()) || "WARN".equals(log.getLevel())) {
                currentIssue.add(log);
            } else {
                if (currentIssue.size() >= 3) { // 3개 이상 연속된 이슈만 기록
                    issues.add(new ArrayList<>(currentIssue));
                }
                currentIssue.clear();
            }
        }

        if (currentIssue.size() >= 3) {
            issues.add(currentIssue);
        }

        return issues;
    }

    private void searchKeywords(List<LogEntry> logs, List<String> keywords) {
        keywords.forEach(keyword -> {
            long count = logs.stream()
                    .filter(log -> log.getMessage().toLowerCase().contains(keyword.toLowerCase()))
                    .count();
            System.out.printf("'%s': %d건%n", keyword, count);
        });
    }

    private static List<String> generateSampleLogs() {
        List<String> logs = new ArrayList<>();
        Random random = new Random(42);

        String[] levels = {"INFO", "WARN", "ERROR", "DEBUG"};
        String[] messages = {
                "Application started successfully",
                "User login: user123",
                "Database connection timeout",
                "NullPointerException in UserService",
                "Processing request: /api/users",
                "SQL query executed in 120ms",
                "Connection failed to external service",
                "Cache miss for key: user_123",
                "Memory usage: 75%",
                "IO Exception reading file config.xml"
        };

        LocalDateTime baseTime = LocalDateTime.of(2023, 12, 1, 0, 0);

        for (int i = 0; i < 1000; i++) {
            LocalDateTime timestamp = baseTime.plusMinutes(random.nextInt(1440)); // 하루 범위
            String level = levels[random.nextInt(levels.length)];
            String message = messages[random.nextInt(messages.length)];

            // ERROR 비율을 시간대별로 다르게 조정
            int hour = timestamp.getHour();
            if (hour >= 14 && hour <= 16) { // 오후 2-4시에 ERROR 증가
                if (random.nextDouble() < 0.3) {
                    level = "ERROR";
                }
            }

            String logLine = String.format("%s %s %s",
                    timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    level,
                    message
            );

            logs.add(logLine);
        }

        return logs;
    }
}

class LogEntry {
    private LocalDateTime timestamp;
    private String level;
    private String message;

    public LogEntry(LocalDateTime timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getLevel() { return level; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return String.format("%s %s %s",
                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                level, message);
    }
}