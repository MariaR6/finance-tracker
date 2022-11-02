package com.example.finance.dto;

import com.example.finance.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ExpenseDto {

    private Integer id;
    private CategoryDto category;
    private double amount;
    private String comment;
    private Instant timestamp;
}
