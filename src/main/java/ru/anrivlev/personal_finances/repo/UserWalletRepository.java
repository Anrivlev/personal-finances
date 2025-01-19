package ru.anrivlev.personal_finances.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anrivlev.personal_finances.entities.UserWallet;

import java.util.Optional;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, Integer> {
    Optional<UserWallet> findByUserLogin(String userLogin);
}
