package ru.anrivlev.personal_finances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anrivlev.personal_finances.repo.UserWalletRepository;

@Service
public class UserWalletService {
    @Autowired
    UserWalletRepository userWalletRepository;
}
