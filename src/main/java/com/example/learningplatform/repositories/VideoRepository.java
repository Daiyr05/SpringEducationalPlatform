package com.example.learningplatform.repositories;

import com.example.learningplatform.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VideoRepository extends JpaRepository<Video,Integer> {
}
