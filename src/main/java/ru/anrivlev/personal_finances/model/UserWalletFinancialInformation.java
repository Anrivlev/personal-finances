package ru.anrivlev.personal_finances.model;

import java.util.HashMap;
import java.util.Map;

public class UserWalletFinancialInformation {
    private double total;

    private double expenses;

    private double incomes;

    private Map<String, CategoryFinancialInformation> byCategory;

    public UserWalletFinancialInformation() {
        this.total = 0;
        this.expenses = 0;
        this.incomes = 0;
        this.byCategory = new HashMap<>();
    }

    public void add(String category, double value) {
        if (value > 0)
            this.incomes += value;
        else
            this.expenses -= value;
        this.total += value;

        CategoryFinancialInformation categoryFinancialInformation = this.byCategory
                .computeIfAbsent(category, k -> new CategoryFinancialInformation());

        categoryFinancialInformation.add(value);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getIncomes() {
        return incomes;
    }

    public void setIncomes(double incomes) {
        this.incomes = incomes;
    }

    public Map<String, CategoryFinancialInformation> getByCategory() {
        return byCategory;
    }

    public void setByCategory(Map<String, CategoryFinancialInformation> byCategory) {
        this.byCategory = byCategory;
    }
}
