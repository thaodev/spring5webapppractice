package com.example.spring5webapppractice.repositories;


import com.example.spring5webapppractice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
