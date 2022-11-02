package com.example.finance.controller;

import com.example.finance.dto.ExpenseDto;
import com.example.finance.entity.Expense;
import com.example.finance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

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

    @DeleteMapping("/expense/delete")
    public void deleteExpenseById(@RequestParam Integer id) {
        expenseService.deleteExpenseById(id);
    }

    @GetMapping("/expense/list")
    public List<ExpenseDto> getExpenseForPeriod(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam Instant start,
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam Instant end) {
        return expenseService.getExpenseForPeriod(start, end);
    }
}
