package ch05;

/**
 * 도서 정보를 관리하는 클래스
 */
class Book {
    // TODO 11: 인스턴스 변수 선언하기
    public String title;
    public String author;
    public String isbn;
    public int pages;
    public boolean isAvailable; // true = 대출 가능, false = 대출 중

    // TODO 12: 도서 정보 출력 메서드 구현하기
    public void displayInfo() {
        System.out.println("=== 도서 정보 ===");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("페이지: " + pages);
        System.out.println("대출 가능: " + (isAvailable ? "예" : "아니오"));
    }

    // TODO 13: 대출 처리 메서드 구현하기
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("'" + title + "' 도서가 대출되었습니다.");
        } else {
            System.out.println("'" + title + "' 도서는 현재 대출 중입니다.");
        }
    }

    // TODO 14: 반납 처리 메서드 구현하기
    public void returnBook() {
        isAvailable = true;
        System.out.println("'" + title + "' 도서가 반납되었습니다.");
    }
}

// TODO 15: 도서관 시스템 완성하기
public class LibrarySystem {
    public static void main(String[] args) {
        // TODO 16: 첫 번째 도서 객체 생성하고 정보 설정하기
        Book book1 = new Book();
        book1.title = "Java의 정석";
        book1.author = "남궁성";
        book1.isbn = "978-89-968088-0-1";
        book1.pages = 1022;
        book1.isAvailable = true;

        // TODO 17: 두 번째 도서 객체 생성하고 정보 설정하기
        Book book2 = new Book();
        book2.title = "Clean Code";
        book2.author = "Robert C. Martin";
        book2.isbn = "978-89-966260-2-3";
        book2.pages = 464;
        book2.isAvailable = true;

        // TODO 18: 도서 정보 표시하기
        book1.displayInfo();
        System.out.println(); // 빈 줄 출력
        book2.displayInfo();
        System.out.println();

        // TODO 19: 대출 시뮬레이션하기
        book1.borrowBook();  // 대출 성공
        book1.borrowBook();  // 이미 대출 중 → 실패 메시지

        // TODO 20: 반납하고 정보 다시 표시하기
        book1.returnBook();
        book1.displayInfo();
    }
}
