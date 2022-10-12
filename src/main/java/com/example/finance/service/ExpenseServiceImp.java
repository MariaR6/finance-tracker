package com.example.finance.service;

import com.example.finance.entity.Category;
import com.example.finance.entity.Expense;
import com.example.finance.repository.CategoryRepository;
import com.example.finance.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImp implements ExpenseService{

    @Autowired
    private final ExpenseRepository expenseRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public Expense saveExpense(Integer categoryId,  double amount, String comment, Instant timestamp) {
        if (amount < 0) {
            throw new IllegalArgumentException("Затрата не должна быть меньше 0");
        }
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Категории не существует");
        }
        return expenseRepository.save(Expense.builder()
                        .category(category.get())
                        .amount(amount)
                        .comment(comment)
                        .timestamp(timestamp)
                .build());
    }
}
