package com.example.spring5webapppractice.controller;

import com.example.spring5webapppractice.repositories.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    //injecting in an instance of the book repository
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public String getBooks(Model model) {//Spring is going to provide in a model and using the repository to get a list of books
        //this provides the method a model, a model object
        //add attribute called books to the model, execute book repository.
        //this model get return back to our view layer and have an attribute books
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }

    @SpringBootApplication
    public static class Spring5webapppracticeApplication {

        public static void main(String[] args) {
            SpringApplication.run(Spring5webapppracticeApplication.class, args);
        }

    }
}
