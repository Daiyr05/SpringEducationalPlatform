package com.example.learningplatform.specification;

import com.example.learningplatform.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;



public class AuthorSpecification {
    public static Specification<Author> hasAge(int age){
        return (Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder)->{
            if(age<0){
                return null;
            }
            return criteriaBuilder.equal(root.get("age"),age);
        };
    }

    public static Specification<Author> firstNameLike(String name){
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)->{
            if(name==null){
                return null;
            }

            return criteriaBuilder.like(root.get("firstName"),"%"+name+"%");
        };
    }

    public static Specification<Author> ageBetween(int start, int end){
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)->{
            if(start<=18 || end<=18){
                return null;
            }
            return criteriaBuilder.between(root.get("age"),start,end);
        };
    }
}
