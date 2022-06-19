package com.example.spring5webapppractice.bootstrap;

import com.example.spring5webapppractice.domain.Author;
import com.example.spring5webapppractice.domain.Book;
import com.example.spring5webapppractice.domain.Publisher;

import com.example.spring5webapppractice.repositories.AuthorRepository;
import com.example.spring5webapppractice.repositories.BookRepository;
import com.example.spring5webapppractice.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Peterburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: "+ publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "72049969");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        System.out.println("Publisher has " + publisherRepository.count() + " number of books.");

    }
}
