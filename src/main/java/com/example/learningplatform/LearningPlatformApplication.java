package com.example.learningplatform;

import com.example.learningplatform.models.Author;
import com.example.learningplatform.models.Video;
import com.example.learningplatform.repositories.AuthorRepository;
import com.example.learningplatform.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningPlatformApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (AuthorRepository authorRepository){
        return args -> {
//            Faker faker = new Faker();
//            for (int i = 0; i < 50; i++){
//                Author author = new Author();
//                author.setFirstName(faker.name().firstName());
//                author.setLastName(faker.name().lastName());
//                author.setEmail("contact"+i+"@gmail.com");
//                author.setAge(faker.number().numberBetween(19,40));
//                authorRepository.save(author);
//            }
            Author author = new Author();
            authorRepository.updateAuthor(100,1);
        };
    }

}
