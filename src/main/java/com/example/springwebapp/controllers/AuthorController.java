package com.example.springwebapp.controllers;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.AuthorDTO;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.BookDTO;
import com.example.springwebapp.repositories.AuthorRepository;
import com.example.springwebapp.services.AuthorService;
import com.example.springwebapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.findAll();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Author author =authorService.findById(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/authors/{id}/books")
    public ResponseEntity<Set<Book>> getBooksByAuthorId(@PathVariable Long id){
        Set<Book> books = bookService.findAllBooksByAuthorId(id);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = authorService.create(authorDTO);
        return ResponseEntity.ok(author);
    }
}
