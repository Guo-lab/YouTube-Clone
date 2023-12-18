package com.guo.YouTubeClone.service;


import org.springframework.web.multipart.MultipartFile;

public interface FileService { // the Interface could be extended later (polymorphic)
    String uploadFile(MultipartFile file);
}
