package com.example.spring5webapppractice.controller;

import com.example.spring5webapppractice.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    //injecting in an instance of the book repository
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/list")
    public String getBooks(Model model) {//Spring is going to provide in a model and using the repository to get a list of books
        //this provides the method a model, a model object
        //add attribute called books to the model, execute book repository.
        //this model get return back to our view layer and have an attribute books
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }

}
