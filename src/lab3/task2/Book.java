package lab3.task2;

import java.util.Objects;

public class Book {
    public String title;
    public String author;
    public int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return copies == book.copies && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, copies);
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %d копий", title, author, copies);
    }
}
