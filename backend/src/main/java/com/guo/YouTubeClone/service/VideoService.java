package com.guo.YouTubeClone.service;

import com.guo.YouTubeClone.model.Video;
import com.guo.YouTubeClone.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    public void uploadVideo(MultipartFile multipartFile) {
        // upload-file-to-AWS-S3 logic has been separated into S3Service
        String videoUrl = s3Service.uploadFile(multipartFile);
        var video = new Video();
        video.setVideoUrl(videoUrl);

        // Save Video Metadata to Database (repository)
        videoRepository.save(video);
    }
}
