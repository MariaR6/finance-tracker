package com.example.finance.service;

import com.example.finance.dto.CategoryDto;
import com.example.finance.dto.ExpenseDto;
import com.example.finance.entity.Category;
import com.example.finance.entity.Expense;

public class Utils {

    public static CategoryDto categoryEntityToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static ExpenseDto expenseEntityToDto(Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .category(categoryEntityToDto(expense.getCategory()))
                .comment(expense.getComment())
                .timestamp(expense.getTimestamp())
                .build();
    }
}
