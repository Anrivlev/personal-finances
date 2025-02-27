package ru.anrivlev.personal_finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anrivlev.personal_finances.entities.FinancialOperation;
import ru.anrivlev.personal_finances.entities.UserWallet;
import ru.anrivlev.personal_finances.model.UserWalletFinancialInformation;
import ru.anrivlev.personal_finances.service.FinancialOperationService;
import ru.anrivlev.personal_finances.service.UserWalletService;

import java.util.List;
import java.util.Objects;

@RestController
public class FinancialOperationRestController {
    @Autowired
    UserWalletService userWalletService;

    @Autowired
    FinancialOperationService financialOperationService;

    @GetMapping(value = "/wallet/{userLogin}/add")
    public ResponseEntity<Integer> saveOperation(
            @PathVariable(name = "userLogin") String userLogin,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "category") String category,
            @RequestParam(name = "value") Double financialValue
    ) {
        UserWallet userWallet = userWalletService.get(userLogin);

        if (userWallet == null) return ResponseEntity.badRequest().build();
        if (!Objects.equals(userWallet.getUserPassword(), password)) return ResponseEntity.badRequest().build();

        FinancialOperation financialOperation = new FinancialOperation();
        financialOperation.setFinancialValue(financialValue);
        financialOperation.setCategory(category);
        financialOperation.setUserWallet(userWallet);
        FinancialOperation savedFinancialOperation = financialOperationService.save(financialOperation);

        return ResponseEntity.ok(savedFinancialOperation.getId());
    }

    @GetMapping(value = "/wallet/{userLogin}/info")
    public ResponseEntity<UserWalletFinancialInformation> getUserWalletFinancialInformation(
            @PathVariable(name = "userLogin") String userLogin,
            @RequestParam(name = "password") String password
    ) {
        UserWallet userWallet = userWalletService.get(userLogin);

        if (userWallet == null) return ResponseEntity.badRequest().build();
        if (!Objects.equals(userWallet.getUserPassword(), password)) return ResponseEntity.badRequest().build();

        UserWalletFinancialInformation userWalletFinancialInformation = financialOperationService.getFinancialInformationFilteredByCategory(userWallet);

        return ResponseEntity.ok(userWalletFinancialInformation);
    }

    @PostMapping(value = "/wallet/{userLogin}/info")
    public ResponseEntity<UserWalletFinancialInformation> getUserWalletFinancialInformationFilteredByCategory(
            @PathVariable(name = "userLogin") String userLogin,
            @RequestParam(name = "password") String password,
            @RequestBody() List<String> categories
    ) {
        UserWallet userWallet = userWalletService.get(userLogin);

        if (userWallet == null) return ResponseEntity.badRequest().build();
        if (!Objects.equals(userWallet.getUserPassword(), password)) return ResponseEntity.badRequest().build();

        UserWalletFinancialInformation userWalletFinancialInformation =
                financialOperationService
                        .getFinancialInformationFilteredByCategory(userWallet, categories);

        return ResponseEntity.ok(userWalletFinancialInformation);
    }
}
