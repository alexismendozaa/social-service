package com.socialservice.recipesearch.controller;

import com.socialservice.recipesearch.service.RecipeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;  // ✅ Corrige las importaciones

import java.util.List;

@RestController // ✅ Agrega esta anotación en lugar de @RequestMapping
@RequestMapping("/api/recipes")
public class RecipeSearchController {

    @Autowired
    private RecipeSearchService recipeSearchService;

    @GetMapping("/search")
    public List<String> searchRecipes(@RequestParam String keyword) {
        return recipeSearchService.searchRecipes(keyword);
    }
}
