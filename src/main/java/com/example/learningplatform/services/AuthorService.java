package com.example.learningplatform.services;

import com.example.learningplatform.models.Author;
import com.example.learningplatform.repositories.AuthorRepository;
import com.example.learningplatform.specification.AuthorSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Author> getAllAuthorsStartingWith(String str){
        return authorRepository.findAllByFirstNameStartingWithIgnoreCase(str);
    }

    public List<Author> getAuthorsAges(int age) {
        return authorRepository.selectByNamedQuery(age);
    }

    public List<Author> getFilteredAuthors(int age) {
        Specification<Author> spec = Specification.where(AuthorSpecification.ageBetween(24,25)).and(AuthorSpecification.firstNameLike("ry"));
        return authorRepository.findAll(spec);
    }
}
