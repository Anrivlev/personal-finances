package ru.anrivlev.personal_finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.anrivlev.personal_finances.service.UserWalletService;

@RestController
public class UserWalletRestController {
    @Autowired
    UserWalletService userWalletService;
}
