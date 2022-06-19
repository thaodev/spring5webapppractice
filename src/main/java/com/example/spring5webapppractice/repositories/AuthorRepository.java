package com.example.spring5webapppractice.repositories;

import com.example.spring5webapppractice.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
