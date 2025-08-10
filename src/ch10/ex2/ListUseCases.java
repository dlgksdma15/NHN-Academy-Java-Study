package ch10.ex2;

import java.util.*;

public class ListUseCases {

    // 사례 1: 대량 데이터 저장 및 조회 - ArrayList 적합
    static class DataRepository {
        private ArrayList<String> data = new ArrayList<>();

        public void loadData(List<String> items) {
            // TODO: items의 모든 요소를 data에 추가
            data.addAll(items);
        }

        public String getData(int index) {
            // TODO: 지정된 인덱스의 데이터 반환
            return data.get(index);
        }

        public List<String> search(String keyword) {
            List<String> results = new ArrayList<>();
            // TODO: data에서 keyword를 포함하는 모든 항목을 results에 추가
            for (String item : data) {
                if (item.contains(keyword)) {
                    results.add(item);
                }
            }

            return results;
        }
    }

    // 사례 2: 작업 큐 - LinkedList 적합
    static class TaskQueue {
        private LinkedList<String> tasks = new LinkedList<>();

        public void addTask(String task) {
            // TODO: 일반 작업을 큐의 끝에 추가
            tasks.addLast(task);
        }

        public void addUrgentTask(String task) {
            // TODO: 긴급 작업을 큐의 앞에 추가
            tasks.addFirst(task);
        }

        public String getNextTask() {
            // TODO: 첫 번째 작업을 제거하고 반환 (pollFirst 사용)
            return tasks.pollFirst();
        }

        public boolean hasTask() {
            // TODO: 작업이 남아있는지 확인
            return !tasks.isEmpty();
        }
    }

    // 사례 3: 브라우저 히스토리 - LinkedList 적합
    static class BrowserHistory {
        private LinkedList<String> history = new LinkedList<>();
        private int currentIndex = -1;

        public void visit(String url) {
            // TODO: 현재 위치 이후의 히스토리 삭제
            // 힌트: history.size() > currentIndex + 1인 동안 removeLast()
            while (history.size() > currentIndex + 1) {
                history.removeLast();
            }

            // TODO: 새 URL을 history에 추가하고 currentIndex 증가
            history.add(url);
            currentIndex++;
        }

        public String back() {
            // TODO: 이전 페이지로 이동
            // 힌트: currentIndex > 0일 때만 가능
            if (currentIndex > 0) {
                currentIndex--;
                return history.get(currentIndex);
            }
            return null;
        }

        public String forward() {
            // TODO: 다음 페이지로 이동
            // 힌트: currentIndex < history.size() - 1일 때만 가능
            if (currentIndex < history.size() - 1) {
                currentIndex++;
                return history.get(currentIndex);
            }
            return null;
        }

        public String current() {
            // TODO: 현재 페이지 URL 반환
            if (currentIndex >= 0 && currentIndex < history.size()) {
                return history.get(currentIndex);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 데이터 저장소 테스트
        DataRepository repo = new DataRepository();
        repo.loadData(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));
        System.out.println("Index 2: " + repo.getData(2));
        System.out.println("Search 'err': " + repo.search("err"));

        // 작업 큐 테스트
        System.out.println("\n=== 작업 큐 ===");
        TaskQueue queue = new TaskQueue();
        queue.addTask("일반 작업 1");
        queue.addTask("일반 작업 2");
        queue.addUrgentTask("긴급 작업");

        while (queue.hasTask()) {
            System.out.println("처리: " + queue.getNextTask());
        }

        // 브라우저 히스토리 테스트
        System.out.println("\n=== 브라우저 히스토리 ===");
        BrowserHistory browser = new BrowserHistory();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("github.com");

        System.out.println("현재: " + browser.current());
        System.out.println("뒤로: " + browser.back());
        System.out.println("뒤로: " + browser.back());
        System.out.println("앞으로: " + browser.forward());
        browser.visit("stackoverflow.com");
        System.out.println("새 방문: " + browser.current());
    }
}