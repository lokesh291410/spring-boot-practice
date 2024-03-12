package com.codingwallah.practice.service;

import com.codingwallah.practice.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@Service
public class BookService {
    @Getter
    private HashMap<Long, Book> books;
    private Long bookId;

    public Book getBookById(Long id) {
        if(books == null) {
            System.out.println("there is no book in the library with id: " + id);
            return null;
        }
        return books.get(id);
    }
    public void addBook(Book book) {
        if(books.containsKey(book.getId())) {
            System.out.println("Book with id: " + book.getId() + " already exists in the library");
            return;
        }
        books.put(book.getId(), book);
    }
    public String removeBook(Long id) {
        if(books == null || !books.containsKey(id)) {
            return "there is no book in the library with id: " + id;
        }
        books.remove(id);
        return "Book with id: " + id + " removed from the library";
    }
    public Book updateBook(Long id, Book newBook) {
        if(books == null || !books.containsKey(id)) {
            System.out.println("there is no book in the library with id: " + id);
            return null;
        }
        Book oldBook = books.get(id);
        if(newBook.getTitle() != null) {
            oldBook.setTitle(newBook.getTitle());
        }
        if(newBook.getAuthor() != null) {
            oldBook.setAuthor(newBook.getAuthor());
        }
        return newBook;
    }
    public Long generateId() {
        return ++bookId;
    }
}
