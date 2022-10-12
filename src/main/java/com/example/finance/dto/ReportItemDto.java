package com.example.finance.dto;

import com.example.finance.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportItemDto {

    private Category category;

    private double total;
}
