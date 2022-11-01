package com.example.finance.controller;

import com.example.finance.entity.Category;
import com.example.finance.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @GetMapping("/category/list")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @PostMapping("/category/create")
    public Category add(@RequestParam String name) {
        return categoryService.saveCategory(name);
    }

    @DeleteMapping("/category/delete")
    public void deleteCategoryById(@RequestParam Integer id){
        categoryService.deleteCategoryById(id);
    }
}
