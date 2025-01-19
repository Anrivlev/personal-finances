package ru.anrivlev.personal_finances.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anrivlev.personal_finances.entities.UserWallet;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, Integer> {
}
