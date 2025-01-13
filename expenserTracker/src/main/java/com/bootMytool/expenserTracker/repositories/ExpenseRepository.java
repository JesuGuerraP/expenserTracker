package com.bootMytool.expenserTracker.repositories;

import com.bootMytool.expenserTracker.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository  extends JpaRepository<Expense, Integer> {

}
