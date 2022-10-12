package com.example.finance.repository;

import com.example.finance.entity.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

    List<Expense> findByTimestampBetween(Instant start, Instant end);
}
