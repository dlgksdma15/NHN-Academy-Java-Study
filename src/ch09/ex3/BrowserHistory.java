package ch09.ex3;

import java.util.Date;
import java.util.EmptyStackException;

public class BrowserHistory {

    static class Page {
        String url;
        String title;
        Date visitTime;

        public Page(String url, String title) {
            this.url = url;
            this.title = title;
            this.visitTime = new Date();
        }

        @Override
        public String toString() {
            return title + " (" + url + ")";
        }
    }

    private GenericLinkedStack<Page> backStack;
    private GenericLinkedStack<Page> forwardStack;
    private Page currentPage;

    public BrowserHistory() {
        this.backStack = new GenericLinkedStack<>();
        this.forwardStack = new GenericLinkedStack<>();
        this.currentPage = null;
    }

    /**
     * 새 페이지 방문
     */
    public void visit(String url, String title) {
        // TODO 1: 현재 페이지가 있으면 backStack에 push
        if (currentPage != null) {
            backStack.push(currentPage);
        }

        // TODO 2: 새 Page 객체를 생성하여 currentPage로 설정
        this.currentPage = new Page(url, title);

        // TODO 3: forwardStack을 clear() (새 페이지 방문 시 앞으로 가기 기록 삭제)
        forwardStack.clear();

        System.out.println("방문: " + currentPage);
        displayStatus();
    }

    /**
     * 뒤로 가기
     */
    public void back() {
        // TODO 1: backStack이 비어있는지 확인
        if (backStack.isEmpty()) {
            System.out.println("뒤로 갈 페이지가 없습니다.");
            return;
        }

        // TODO 2: 현재 페이지를 forwardStack에 push
        forwardStack.push(currentPage);

        // TODO 3: backStack에서 pop한 페이지를 currentPage로 설정
        currentPage = backStack.pop();

        System.out.println("뒤로 가기: " + currentPage);
        displayStatus();
    }

    /**
     * 앞으로 가기
     */
    public void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("앞으로 갈 페이지가 없습니다.");
            return;
        }

        backStack.push(currentPage);
        currentPage = forwardStack.pop();

        System.out.println("앞으로 가기: " + currentPage);
        displayStatus();
    }

    /**
     * 현재 상태 표시
     */
    private void displayStatus() {
        System.out.println("현재 페이지: " + (currentPage != null ? currentPage : "없음"));
        System.out.println("뒤로 가기 가능: " + backStack.size() + "개");
        System.out.println("앞으로 가기 가능: " + forwardStack.size() + "개");
        System.out.println();
    }

    /**
     * 방문 기록 표시
     */
    public void showHistory() {
        System.out.println("\n=== 방문 기록 ===");

        // 임시 스택에 저장
        GenericLinkedStack<Page> tempStack = new GenericLinkedStack<>();

        // 뒤로 가기 스택의 내용을 임시로 이동
        while (!backStack.isEmpty()) {
            tempStack.push(backStack.pop());
        }

        // 출력하면서 원래대로 복원
        System.out.println("이전 페이지들:");
        while (!tempStack.isEmpty()) {
            Page page = tempStack.pop();
            System.out.println("  - " + page);
            backStack.push(page);
        }

        if (currentPage != null) {
            System.out.println("현재 페이지: " + currentPage + " ← 현재 위치");
        }

        // 앞으로 가기 스택 표시
        if (!forwardStack.isEmpty()) {
            System.out.println("다음 페이지들:");
            // 앞으로 가기 스택도 같은 방식으로 처리
            while (!forwardStack.isEmpty()) {
                tempStack.push(forwardStack.pop());
            }
            while (!tempStack.isEmpty()) {
                Page page = tempStack.pop();
                System.out.println("  - " + page);
                forwardStack.push(page);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 브라우저 히스토리 관리 ===\n");

        BrowserHistory browser = new BrowserHistory();

        // 웹 서핑 시뮬레이션
        browser.visit("https://www.google.com", "Google");
        browser.visit("https://www.github.com", "GitHub");
        browser.visit("https://www.stackoverflow.com", "Stack Overflow");
        browser.visit("https://www.youtube.com", "YouTube");

        System.out.println("=== 뒤로 가기 테스트 ===");
        browser.back();
        browser.back();

        System.out.println("=== 앞으로 가기 테스트 ===");
        browser.forward();

        System.out.println("=== 새 페이지 방문 ===");
        browser.visit("https://www.reddit.com", "Reddit");

        browser.showHistory();
    }
}