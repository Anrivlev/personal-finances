package ru.anrivlev.personal_finances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anrivlev.personal_finances.entities.UserWallet;
import ru.anrivlev.personal_finances.model.UserWalletFinancialInformation;
import ru.anrivlev.personal_finances.repo.UserWalletRepository;

import java.util.Optional;

@Service
public class UserWalletService {
    @Autowired
    UserWalletRepository userWalletRepository;

    public UserWallet get(Integer id) {
        Optional<UserWallet> optionalUserWallet = userWalletRepository.findById(id);
        return optionalUserWallet.orElse(null);
    }

    public UserWallet get(String userLogin) {
        Optional<UserWallet> optionalUserWallet = userWalletRepository.findByUserLogin(userLogin);
        return optionalUserWallet.orElse(null);
    }

    public UserWallet save(UserWallet userWallet) {
        return userWalletRepository.save(userWallet);
    }
}
