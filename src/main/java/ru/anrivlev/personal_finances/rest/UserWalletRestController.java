package ru.anrivlev.personal_finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.anrivlev.personal_finances.entities.UserWallet;
import ru.anrivlev.personal_finances.service.UserWalletService;

import java.util.Objects;

@RestController
public class UserWalletRestController {
    @Autowired
    UserWalletService userWalletService;

    @GetMapping(value = "/user/{userLogin}")
    public ResponseEntity<Integer> saveUserWallet(
            @PathVariable(name = "userLogin") String userLogin,
            @RequestParam(name = "password") String userPassword,
            @RequestParam(name = "old_password") String previousPassword
    ) {
        if (userPassword == null) return ResponseEntity.badRequest().build();

        UserWallet existingUserWallet = userWalletService.get(userLogin);

        if (existingUserWallet == null) {
            UserWallet userWallet = new UserWallet();
            userWallet.setUserLogin(userLogin);
            userWallet.setUserPassword(userPassword);
            UserWallet savedUserWallet = userWalletService.save(userWallet);
            return ResponseEntity.ok(savedUserWallet.getId());
        }

        if (!Objects.equals(existingUserWallet.getUserPassword(), previousPassword)) {
            return ResponseEntity.badRequest().build();
        }

        existingUserWallet.setUserPassword(userPassword);
        UserWallet savedUserWallet = userWalletService.save(existingUserWallet);
        return ResponseEntity.ok(savedUserWallet.getId());
    }
}
