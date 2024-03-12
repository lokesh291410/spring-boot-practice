package com.codingwallah.practice.controller;

import com.codingwallah.practice.entity.Book;
import com.codingwallah.practice.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @GetMapping
    public Map<Long, Book> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @PostMapping
    public void addBook(Book book) {
        bookService.addBook(book);
    }
    @DeleteMapping("/{id}")
    public String removeBook(@PathVariable Long id) {
        return bookService.removeBook(id);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

}
