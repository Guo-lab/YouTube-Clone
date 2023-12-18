package com.guo.YouTubeClone.controller;

import com.guo.YouTubeClone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController /* REST Controller */
@RequestMapping("/api/videos") /* where to find the REST api */
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PostMapping // listen to the post request
    @ResponseStatus(HttpStatus.CREATED) // http response of this request would be created at the server side
    public void uploadVideo(@RequestParam("file") MultipartFile file) {
        // the method take a request body (a file)
        // Then, the file would be delegated to the service layer
        videoService.uploadVideo(file);
    }

}


