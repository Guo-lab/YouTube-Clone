package com.guo.YouTubeClone.repository;

import com.guo.YouTubeClone.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
