package ru.anrivlev.personal_finances.model;

public class CategoryFinancialInformation {
    private double total;

    private double expenses;

    private double incomes;

    public CategoryFinancialInformation() {
        this.total = 0;
        this.expenses = 0;
        this.incomes = 0;
    }

    public void add(double value) {
        if (value > 0)
            this.incomes += value;
        else
            this.expenses -= value;
        this.total += value;
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
}
