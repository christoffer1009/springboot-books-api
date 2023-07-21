//package com.example.springwebapp.bootstrap;
//
//import com.example.springwebapp.domain.Author;
//import com.example.springwebapp.domain.Book;
//import com.example.springwebapp.domain.Publisher;
//import com.example.springwebapp.repositories.AuthorRepository;
//import com.example.springwebapp.repositories.BookRepository;
//import com.example.springwebapp.repositories.PublisherRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BootstrapData implements CommandLineRunner {
//
//    private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
//    private final PublisherRepository publisherRepository;
//
//    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//        this.publisherRepository = publisherRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Author author = new Author();
//        author.setFirstName("Eric");
//        author.setLastName("Evans");
//
//        Author author2 = new Author();
//        author2.setFirstName("Rod");
//        author2.setLastName("Johnson");
//
//        Publisher publisher = new Publisher();
//        publisher.setName("My publisher");
//
//        Book book = new Book();
//        book.setTitle("Domain Driven Design");
//        book.setIsbn("123456");
//        book.setPublisher(publisher);
//
//        Book book2 = new Book();
//        book2.setTitle("J2EE Development");
//        book2.setIsbn("654321");
//        book2.setPublisher(publisher);
//
//        Publisher savedPublisher = publisherRepository.save(publisher);
//        Author savedAuthor = authorRepository.save(author);
//        Book savedBook = bookRepository.save(book);
//        Author savedAuthor2 = authorRepository.save(author2);
//        Book savedBook2 = bookRepository.save(book2);
//
//        publisher.getBooks().add(savedBook);
//        publisher.getBooks().add(savedBook2);
//        savedAuthor.getBooks().add(savedBook);
//        savedAuthor2.getBooks().add(savedBook2);
//        savedBook.getAuthors().add(savedAuthor);
//        savedBook2.getAuthors().add(savedAuthor2);
//
//        publisherRepository.save(savedPublisher);
//        authorRepository.save(savedAuthor);
//        authorRepository.save(savedAuthor2);
//        bookRepository.save(savedBook);
//        bookRepository.save(savedBook2);
//
//        System.out.println("In Bootstrap");
//        System.out.println("Author count = " + authorRepository.count());
//        System.out.println("Book count = " + bookRepository.count());
//        System.out.println("Publisher count = " + publisherRepository.count());
//    }
//}
