package com.guo.YouTubeClone.service;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor // automatically generate the argument constructor like `public S3Service(AmazonS3Client amazonS3Client) {}`
public class S3Service implements FileService {
    public static final String BUCKET_NAME = "youtube-clone-video-uploaded";
    private final AmazonS3Client amazonS3Client;
    /* JDK 20, a Bean of type needed. Anyway, still 404. */
    //// @Bean public static AmazonS3Client amazonS3Client() { return (AmazonS3Client) AmazonS3ClientBuilder.standard().withRegion("us-east-1").withCredentials(new DefaultAWSCredentialsProviderChain()).build(); } */

    @Override
    public String uploadFile(MultipartFile file) {

    // ================== Upload the file to AWS S3 ===================
        // Prepare a key (an unique key for a file to be uploaded to AWS)
        // retrieve the extension by using the utility class
        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        // create the unique key
        var key = UUID.randomUUID().toString() + '.' + filenameExtension;

        // create the metadata for the file uploading to AWS S3
        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        // send the file directly to the Amazon S3
        try {
            // Reading the input stream from the file and passing it to the putObject of the AWS
            amazonS3Client.putObject(
                    BUCKET_NAME, key, file.getInputStream(), metadata);
        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An Exception occurred while uploading the file.");
        }

        // add some access control list to make the file publicly readable
        // Accessible from the Angular application
        amazonS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);
    // ================================================================

        // return the url of the uploaded file
        return amazonS3Client.getResourceUrl(BUCKET_NAME, key);
    }
}

// tips:
// Option + Command + C
// Replace all occurrences
// group the variables
// into static ones