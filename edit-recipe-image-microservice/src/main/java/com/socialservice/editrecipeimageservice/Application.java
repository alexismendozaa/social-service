
package com.socialservice.editrecipeimage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
public class EditRecipeImageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EditRecipeImageServiceApplication.class, args);
    }
}

@RestController
class EditRecipeImageController {
    @PutMapping("/edit-image")
    public String editRecipeImage(@RequestParam String imageId, @RequestParam("file") MultipartFile file) {
        return "Image " + imageId + " updated successfully with new file " + file.getOriginalFilename();
    }
}