package ru.anrivlev.personal_finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.anrivlev.personal_finances.entities.CategoryBudget;
import ru.anrivlev.personal_finances.entities.FinancialOperation;
import ru.anrivlev.personal_finances.entities.UserWallet;
import ru.anrivlev.personal_finances.service.CategoryBudgetService;
import ru.anrivlev.personal_finances.service.UserWalletService;

import java.util.Objects;

@RestController
public class CategoryBudgetRestController {
    @Autowired
    UserWalletService userWalletService;

    @Autowired
    CategoryBudgetService categoryBudgetService;

    @GetMapping(value = "/wallet/{userLogin}/categories/add")
    public ResponseEntity<Integer> saveOperation(
            @PathVariable(name = "userLogin") String userLogin,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "category") String category,
            @RequestParam(name = "budget") Double budget
    ) {
        UserWallet userWallet = userWalletService.get(userLogin);

        if (userWallet == null) return ResponseEntity.badRequest().build();
        if (!Objects.equals(userWallet.getUserPassword(), password)) return ResponseEntity.badRequest().build();

        CategoryBudget categoryBudget = new CategoryBudget();
        categoryBudget.setCategory(category);
        categoryBudget.setBudget(budget);

        CategoryBudget savedCategoryBudget = categoryBudgetService.save(
                categoryBudget
        );

        return ResponseEntity.ok(savedCategoryBudget.getId());
    }
}
