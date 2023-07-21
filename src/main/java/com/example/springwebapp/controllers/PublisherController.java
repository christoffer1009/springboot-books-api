package com.example.springwebapp.controllers;

import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.Publisher;
import com.example.springwebapp.domain.PublisherDTO;
import com.example.springwebapp.services.BookService;
import com.example.springwebapp.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private BookService bookService;

    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        List<Publisher> publishers = publisherService.findAll();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id){
        Publisher publisher = publisherService.findById(id);
        return ResponseEntity.ok(publisher);
    }

    @GetMapping("/publishers/{id}/books")
    public ResponseEntity<Set<Book>> getAllBooksByPublisherId(@PathVariable Long id){
        Set<Book> books = bookService.findAllBooksByPublisherId(id);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/publishers")
    public ResponseEntity<Publisher> createPublisher(@RequestBody PublisherDTO publisher) {

        Publisher createdPublisher = publisherService.create(publisher);
        return ResponseEntity.ok(createdPublisher);
    }
}
