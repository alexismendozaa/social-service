
package com.socialservice.uploadrecipeimage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
public class UploadRecipeImageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UploadRecipeImageServiceApplication.class, args);
    }
}

@RestController
class UploadRecipeImageController {
    @PostMapping("/upload-image")
    public String uploadRecipeImage(@RequestParam("file") MultipartFile file) {
        return "Image " + file.getOriginalFilename() + " uploaded successfully";
    }
}