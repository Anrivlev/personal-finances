package ru.anrivlev.personal_finances.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anrivlev.personal_finances.entities.FinancialOperation;

import java.util.List;

@Repository
public interface FinancialOperationRepository extends JpaRepository<FinancialOperation, Integer> {
    public List<FinancialOperation> findAllByUserWalletId(Integer userWalletId);

    public List<FinancialOperation> findAllByUserWalletIdAndCategoryIn(
            Integer userWalletId,
            List<String> categories
    );
}
