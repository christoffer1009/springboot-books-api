package com.example.springwebapp.services;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.Publisher;
import com.example.springwebapp.domain.PublisherDTO;
import com.example.springwebapp.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAll(){
        return (List<Publisher>) publisherRepository.findAll();
    }

    public Publisher findById(Long id){
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher create(PublisherDTO publisherDTO){

        Publisher newPublisher = new Publisher(publisherDTO.id(), publisherDTO.name());
        return publisherRepository.save(newPublisher);
    }
}
