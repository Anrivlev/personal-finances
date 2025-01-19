package ru.anrivlev.personal_finances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anrivlev.personal_finances.entities.FinancialOperation;
import ru.anrivlev.personal_finances.repo.FinancialOperationRepository;

@Service
public class FinancialOperationService {
    @Autowired
    FinancialOperationRepository financialOperationRepository;

    public FinancialOperation save(FinancialOperation financialOperation) {
        return financialOperationRepository.save(financialOperation);
    }
}
