
package com.socialservice.deleterecipeimage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DeleteRecipeImageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeleteRecipeImageServiceApplication.class, args);
    }
}

@RestController
class DeleteRecipeImageController {
    @DeleteMapping("/delete-image")
    public String deleteRecipeImage(@RequestParam String imageId) {
        return "Image " + imageId + " deleted successfully";
    }
}