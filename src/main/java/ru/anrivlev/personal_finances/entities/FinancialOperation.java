package ru.anrivlev.personal_finances.entities;

import jakarta.persistence.*;

@Entity(name = "financial_operations")
public class FinancialOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "financial_value")
    private Double financialValue;

    public FinancialOperation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getFinancialValue() {
        return financialValue;
    }

    public void setFinancialValue(Double financialValue) {
        this.financialValue = financialValue;
    }
}
