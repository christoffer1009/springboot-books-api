package com.example.springwebapp.services;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.AuthorDTO;
import com.example.springwebapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll(){
        return (List<Author>) authorRepository.findAll();
    }

    public Author findById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Author create(AuthorDTO authorDTO){
        Author newAuthor = new Author(authorDTO.id(), authorDTO.firstName(), authorDTO.lastName());
        return authorRepository.save(newAuthor);
    }
}
