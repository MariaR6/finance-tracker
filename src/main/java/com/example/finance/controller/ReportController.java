package com.example.finance.controller;

import com.example.finance.dto.ReportItemDto;
import com.example.finance.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {

    @Autowired
    private final ReportService reportService;

    @GetMapping("/report/expense-per-category")
    public List<ReportItemDto> getExpensesPerCategory(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam Instant start,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam Instant end) {
        return reportService.getExpensesPerCategory(start, end);
    }
}
