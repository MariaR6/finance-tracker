package com.example.finance.service;

import com.example.finance.dto.CategoryDto;
import com.example.finance.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategory();

    Category saveCategory(String name);

    void deleteCategoryById(Integer id);
}
