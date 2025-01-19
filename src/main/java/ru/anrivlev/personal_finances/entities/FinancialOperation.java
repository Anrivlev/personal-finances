package ru.anrivlev.personal_finances.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "financial_operations")
public class FinancialOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "financial_value")
    private Double financialValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_wallet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private UserWallet userWallet;

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

    public UserWallet getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(UserWallet userWallet) {
        this.userWallet = userWallet;
    }
}
