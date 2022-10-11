package com.example.finance.service;

import com.example.finance.entity.Category;
import com.example.finance.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<Category>();
        for (Category str : categoryRepository.findAll()) {
            categories.add(str);
        }
        return categories;
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}