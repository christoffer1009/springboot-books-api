package com.example.springwebapp.services;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.BookDTO;
import com.example.springwebapp.domain.Publisher;
import com.example.springwebapp.repositories.AuthorRepository;
import com.example.springwebapp.repositories.BookRepository;
import com.example.springwebapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book create(BookDTO bookDTO){
        Set<Author> authors = bookDTO.authorsIds().stream()
                .map(authorId -> authorRepository.findById(authorId).orElse(null))
                .collect(Collectors.toSet());
        Publisher publisher = publisherRepository.findById(bookDTO.publisherId()).orElse(null);
        Book newBook = new Book(bookDTO.id(), bookDTO.title(),bookDTO.isbn(), authors, publisher);

        return  bookRepository.save(newBook);
    }

    public Set<Book> findAllBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthors(authorId);
    }

    public Set<Book> findAllBooksByPublisherId(Long publisherId) {
        return bookRepository.findByPublisher(publisherId);
    }
}
