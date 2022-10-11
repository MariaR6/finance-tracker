package com.example.finance.service;

import com.example.finance.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category saveCategory(String name);
}
