package lab3.task2;

import java.util.HashMap;

public class LibraryHashMap {
    private final HashMap<String, Book> hashMap;

    public LibraryHashMap() {
        this.hashMap = new HashMap<>();
    }

    public void put(String isbn, Book book) {
        hashMap.put(isbn, book);
    }

    public Book get(String isbn) {
        return hashMap.get(isbn);
    }

    public Book remove(String isbn) {
        return hashMap.remove(isbn);
    }
}
