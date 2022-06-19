package com.example.spring5webapppractice.repositories;


import com.example.spring5webapppractice.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
