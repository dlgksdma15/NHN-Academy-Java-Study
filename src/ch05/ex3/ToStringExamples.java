package ch05.ex3;

/**
 * 책 정보를 나타내는 클래스
 */
class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    private boolean isAvailable;

    // 생성자
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.isAvailable = true; // 기본적으로 대출 가능
    }

    // Getter 메서드들
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // toString() 재정의
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', pages=" +
                pages + ", price=" + price + "원, available=" + (isAvailable ? "O" : "X") + "}";
    }
}

/**
 * 좌표를 나타내는 클래스
 */
class Point {
    private double x, y;

    // 생성자
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // toString() 재정의
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    // 다른 점과의 거리 계산
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// 테스트 클래스
public class ToStringExamples {
    public static void main(String[] args) {
        System.out.println("=== 다양한 toString() 구현 예제 ===\n");

        // Book 클래스 테스트
        Book book1 = new Book("자바의 정석", "남궁성", 1200, 35000);
        Book book2 = new Book("클린 코드", "로버트 마틴", 584, 29000);

        System.out.println(book1);
        System.out.println(book2);

        // Point 클래스 테스트
        Point p1 = new Point(3.5, 4.2);
        Point p2 = new Point(-2.1, 1.8);

        System.out.println("\n좌표:");
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.printf("두 점 사이의 거리: %.2f\n", p1.distanceTo(p2));
    }
}
