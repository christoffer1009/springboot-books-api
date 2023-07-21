package com.example.springwebapp.controllers;

import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.BookDTO;
import com.example.springwebapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO book) {

        Book createdBook = bookService.create(book);
        return ResponseEntity.ok(createdBook);
    }


}
