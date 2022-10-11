package com.example.finance.service;

import com.example.finance.entity.Category;
import com.example.finance.entity.Expense;

import java.time.Instant;

public interface ExpenseService {

    Expense saveExpense(Integer id, double amount, String comment, Instant timestamp);

}
