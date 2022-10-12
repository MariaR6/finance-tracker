package com.example.finance.service;

import com.example.finance.dto.ReportItemDto;

import java.time.Instant;
import java.util.List;

public interface ReportService {

    List<ReportItemDto> getExpensesPerCategory(Instant start, Instant end);
}
