package com.example.finance.service;

import com.example.finance.dto.ReportItemDto;
import com.example.finance.entity.Expense;
import com.example.finance.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    @Autowired
    private final ExpenseRepository expenseRepository;


    @Override
    public List<ReportItemDto> getExpensesPerCategory(Instant start, Instant end) {
        List<Expense> expenses = expenseRepository.findByTimestampBetween(start, end);
        Map<Integer, ReportItemDto> result = new HashMap<>();
        for (Expense expense : expenses) {
            if(result.containsKey(expense.getCategory().getId())) {
                ReportItemDto itemDto = result.get(expense.getCategory().getId());
                itemDto.setTotal(itemDto.getTotal() + expense.getAmount());
            } else {
                result.put(expense.getCategory().getId(), ReportItemDto.builder()
                        .category(expense.getCategory())
                        .total(expense.getAmount())
                        .build());
            }
        }
        return new ArrayList<>(result.values());
    }
}
