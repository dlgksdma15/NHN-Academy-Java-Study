package ch10.ex1;

import java.util.*;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // equals() 재정의
    @Override
    public boolean equals(Object obj) {
        // TODO: equals 메서드 구현
        // 1. 같은 객체인지 확인 (this == obj)
        // 2. null이거나 다른 클래스인지 확인
        // 3. ISBN으로 비교
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Book otherBook = (Book) obj;
        return this.isbn.equals(otherBook.isbn);

    }

    // hashCode() 재정의 (equals()와 일관성 유지)
    @Override
    public int hashCode() {
        // TODO: ISBN의 hashCode 반환
        return Objects.hash(isbn); // 임시 반환값
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s (%d)", title, author, year);
    }

    public static void main(String[] args) {
        // 실행 결과:
        // book1.equals(book2): true
        // book1.equals(book3): false
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018);
        Book book2 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018);
        Book book3 = new Book("978-0321765723", "The Lord of the Rings", "J.R.R. Tolkien", 1954);

        System.out.println("book1.equals(book2): " + book1.equals(book2));
        System.out.println("book1.equals(book3): " + book1.equals(book3));

        System.out.println();
        //
        // HashSet의 책들:
        // 'Effective Java' by Joshua Bloch (2018)
        // 'Clean Code' by Robert Martin (2008)
        //
        // ISBN 978-0134685991 찾기: true

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2); // ISBN이 같으므로 중복으로 간주되어 추가되지 않음
        bookSet.add(book3);
        System.out.println("HashSet의 책들:");

        for (Book book : bookSet) {
            System.out.println(book);
        }

        System.out.println();

        Book searchBook = new Book("978-0134685991", "임시 제목", "임시 저자", 0);
        System.out.println("ISBN 978-0134685991 찾기: " + bookSet.contains(searchBook));
    }
}