
package com.socialservice.recipescount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RecipesCountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesCountServiceApplication.class, args);
    }
}

@RestController
class RecipesCountController {
    @GetMapping("/recipes/count")
    public int getRecipesCount(@RequestParam String userId) {
        return 45; // Simulando cantidad de recetas
    }
}