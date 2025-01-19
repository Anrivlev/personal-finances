package ru.anrivlev.personal_finances.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anrivlev.personal_finances.entities.FinancialOperation;

@Repository
public interface FinancialOperationRepository extends JpaRepository<FinancialOperation, Integer> {
}
