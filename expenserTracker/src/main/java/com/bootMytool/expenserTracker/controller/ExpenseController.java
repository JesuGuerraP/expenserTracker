package com.bootMytool.expenserTracker.controller;
import java.time.format.DateTimeFormatter;

import com.bootMytool.expenserTracker.Expense;
import com.bootMytool.expenserTracker.services.CustomUtils;
import com.bootMytool.expenserTracker.services.ExpenseServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseServices expenseServices;
    private final CustomUtils customUtils;

    @Autowired
    public ExpenseController(ExpenseServices expenseServices, CustomUtils customUtils) {
        this.expenseServices = expenseServices;
        this.customUtils = customUtils;
    }

    @GetMapping({"", "/"})
    public String showExpenseList(Model model) {
        List<Expense> expenses = expenseServices.getAllExpenses();

        // Calcular el total de todos los gastos
        double totalAmount = expenseServices.calculateTotalAmount();
        model.addAttribute("totalAmount", totalAmount);




        model.addAttribute("expenses", expenses);
        model.addAttribute("dateFormatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
        model.addAttribute("customUtils", customUtils);
        return "expense/expense-list";
    }



    @GetMapping("/new")
    public String showExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("isEdit", false);
        return "expense/expense-form";
    }

    @PostMapping("/save")
    public String saveExpense(@Valid @ModelAttribute("expense") Expense expense,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEdit", expense.getId() != 0);
            return "expense/expense-form";
        }

        try {
            if (expense.getId() == 0) {
                expenseServices.createExpense(expense);
            } else {
                expenseServices.updateExpense(expense.getId(), expense);
            }
            return "redirect:/expense";
        } catch (Exception e) {
            result.rejectValue("date", "error.date", "Error processing date");
            model.addAttribute("isEdit", expense.getId() != 0);
            return "expense/expense-form";
        }
    }


    @GetMapping("/expense")
    public String listExpense(Model model) {
        model.addAttribute("expenses", expenseServices.getAllExpenses());
        return "/expense/expense-list";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Expense expense = expenseServices.getExpenseById(id);
        model.addAttribute("expense", expense);
        model.addAttribute("isEdit", true);
        return "expense/expense-form";
    }

    @PostMapping("/expense/{id}/update")
    public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "expense/expense-form";
        }
        expenseServices.updateExpense(expense.getId(), expense);
        return "redirect:/expense";
    }

    @GetMapping("/{id}/delete")
    public String deleteExpense(@PathVariable int id) {
        expenseServices.deleteExpense(id);
        return "redirect:/expense";


    }
    @PostMapping("/{id}/delete")
    public String deleteExpensePost(@PathVariable int id) {
        expenseServices.deleteExpense(id);
        return "redirect:/expense";
    }


}
