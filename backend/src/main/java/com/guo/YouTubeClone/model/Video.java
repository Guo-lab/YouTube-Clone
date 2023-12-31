package com.guo.YouTubeClone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value = "Video")
@Data /* the lombok annotations, getters and setters automatically generated, dynamically at the time of compilation */
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    private String id;  /* stored as ObjectId */
    private String title;
    private String description;
    private String userId;
    private Integer likes;
    private Integer dislikes;
    private Set<String> tags;
    private String videoUrl;
    private videoStatus videoStatus;
    private Integer viewCount;
    private String thumbnailUrl;
    private List<Comment> commentList;
}
