package ru.anrivlev.personal_finances.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name="user_wallets")
public class UserWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userLogin;

    private String userPassword;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "financial_operation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private FinancialOperation financialOperation;

    public UserWallet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public FinancialOperation getFinancialOperation() {
        return financialOperation;
    }

    public void setFinancialOperation(FinancialOperation financialOperation) {
        this.financialOperation = financialOperation;
    }
}
