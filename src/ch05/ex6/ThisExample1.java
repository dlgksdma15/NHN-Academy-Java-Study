package ch05.ex6;

/**
 * this를 사용하여 매개변수와 인스턴스 변수를 구분하는 예제
 */
class Book {
    private String title;
    private String author;
    private int pages;
    private double price;

    // 생성자에서 this 사용
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    // setter 메서드에서 this 사용
    public void setTitle(String title) {
        // TODO 2: this를 사용하여 title 설정하기
        this.title = title;
    }

    public void setPrice(double price) {
        // TODO 3: price가 0보다 크면 this.price에 설정하기
        if(price > 0){
            this.price = price;
        }
    }

    // this 없이도 가능한 경우 (이름이 다를 때)
    public void updatePrice(double newPrice) {
        price = newPrice;  // this.price와 동일
    }

    @Override
    public String toString() {
        // TODO 4: "책: [제목] (저자: [저자])" 형식으로 반환하기
        // this를 사용하여 인스턴스 변수에 접근
        return "책: %s (저자: %s)".formatted(this.title,this.author);
    }
}

// 테스트
public class ThisExample1 {
    public static void main(String[] args) {
        // TODO 5: Book 객체 생성하고 출력하기
        // 제목: "자바의 정석", 저자: "남궁성", 페이지: 1000, 가격: 30000
        Book book = new Book("자바의 정석", "남궁성", 1000, 30000);
        System.out.println(book);

        // TODO 6: 제목을 "이펙티브 자바"로, 가격을 45000으로 변경하고 출력하기
        book.setTitle("이펙티브 자바");
        System.out.println(book);
    }
}
