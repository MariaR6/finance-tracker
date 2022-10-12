package com.example.finance.controller;

import com.example.finance.entity.Expense;
import com.example.finance.service.ExpenseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class ExpenseController {

    @Autowired
    private final ExpenseService expenseService;

    @PostMapping("/expense/create")
    public Expense add(@RequestParam Integer categoryId, @RequestParam double amount, @RequestParam String comment,
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam Instant timestamp) {
        return expenseService.saveExpense(categoryId, amount, comment, timestamp);
    }
}
