package ch07.ex3;

import java.util.ArrayList;

public class BookLibrary {
    static class Book {
        String title;
        String author;
        int year;
        double price;

        public Book(String title, String author, int year, double price) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.price = price;
        }

        @Override
        public String toString() {
            return title + " - " + author + " (" + year + ") " + price + "원";
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        library.add(new Book("자바의 정석", "남궁성", 2020, 30000));
        library.add(new Book("이펙티브 자바", "조슈아 블로크", 2018, 36000));
        library.add(new Book("클린 코드", "로버트 마틴", 2013, 29700));
        library.add(new Book("스프링 인 액션", "크레이그 월즈", 2020, 40000));

        System.out.println("=== 전체 도서 목록 ===");
        for (Book book : library) {
            System.out.println(book);
        }

        System.out.println("\n=== 남궁성 저자의 책 ===");
        for (Book book : library) {
            if (book.author.equals("남궁성")) {
                System.out.println(book);
            }
        }

        System.out.println("\n=== 30000원 이상의 책 ===");
        for (Book book : library) {
            if (book.price >= 30000) {
                System.out.println(book);
            }
        }

        System.out.println("\n=== 2020년 이후 출간 도서 ===");
        for (Book book : library) {
            if (book.year >= 2020) {
                System.out.println(book);
            }
        }

        double totalPrice = 0;
        for (Book book : library) {
            totalPrice += book.price;
        }

        System.out.println("\n도서 총 가격: " + totalPrice + "원");
    }
}
