package com.example.springwebapp.repositories;

import com.example.springwebapp.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.id = :authorId")
    Set<Book> findByAuthors(Long authorId);

    @Query("SELECT b FROM Book b WHERE b.publisher.id = :publisherId")
    Set<Book> findByPublisher(Long publisherId);
}
