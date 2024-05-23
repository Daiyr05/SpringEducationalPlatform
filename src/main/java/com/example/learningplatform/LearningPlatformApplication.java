package com.example.learningplatform;

import com.example.learningplatform.models.Author;
import com.example.learningplatform.models.Video;
import com.example.learningplatform.repositories.VideoRepository;
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
    public CommandLineRunner commandLineRunner (VideoRepository videoRepository){
        return args -> {
            Video video = (Video) Video.builder().length(10).name("test video").build();
            videoRepository.save(video);
        };
    }

}
