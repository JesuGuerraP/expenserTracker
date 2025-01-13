package com.bootMytool.expenserTracker;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name= "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    @NotNull(message = "Date is required")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Description is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Category is required") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category is required") String category) {
        this.category = category;
    }

    public @NotNull(message = "Amount is required") @Positive(message = "Amount must be greater than 0") Double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "Amount is required") @Positive(message = "Amount must be greater than 0") Double amount) {
        this.amount = amount;
    }

    public @NotNull(message = "Date is required") Date getDate() {
        return date;
    }

    public void setDate(@NotNull(message = "Date is required") Date date) {
        this.date = date;
    }
}
