package com.example.finance.service;

import com.example.finance.dto.CategoryDto;
import com.example.finance.entity.Category;
import com.example.finance.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> categories = new ArrayList<CategoryDto>();
        for (Category str : categoryRepository.findAll()) {
            if (!str.isDeleted()) {
                categories.add(Utils.categoryEntityToDto(str));
            }
        }
        return categories;
    }

    @Override
    public Category saveCategory(String name) {
        return categoryRepository.save(new Category(null, name, false));
    }

    @Override
    public void deleteCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new IllegalStateException("Такой категории не существует");
        }
        category.get().setDeleted(true);
        categoryRepository.save(category.get());
    }
}
