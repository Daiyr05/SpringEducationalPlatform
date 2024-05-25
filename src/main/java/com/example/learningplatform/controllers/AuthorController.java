package com.example.learningplatform.controllers;

import com.example.learningplatform.models.Author;
import com.example.learningplatform.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/post")
    public void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }

    @GetMapping("/get")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/get/{str}")
    public List<Author> getAllStudentStartingWith(@PathVariable("str") String str){
        return authorService.getAllAuthorsStartingWith(str);

    }

    @GetMapping("/{age}")
    public List<Author> getAuthrosAges(@PathVariable("age") int age){
        return authorService.getAuthorsAges(age);
    }
}
