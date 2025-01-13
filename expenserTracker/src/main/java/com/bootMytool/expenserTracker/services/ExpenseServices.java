package com.bootMytool.expenserTracker.services;

import com.bootMytool.expenserTracker.Expense;
import com.bootMytool.expenserTracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServices {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServices(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Calcular el total de todos los gastos
    public double calculateTotalAmount() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    //


    //Create expense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }


    //Update expense
    public Expense updateExpense(int id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));


        existingExpense.setDescription(expense.getDescription());
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setDate(expense.getDate());

        return expenseRepository
                .save(existingExpense);
    }
    public void deleteExpense(int id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));
        expenseRepository.delete(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public Expense getExpenseById(int id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new RuntimeException("Expense not found with ID: " + id);
        }
    }

}

