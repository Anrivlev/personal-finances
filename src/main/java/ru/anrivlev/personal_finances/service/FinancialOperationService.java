package ru.anrivlev.personal_finances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anrivlev.personal_finances.entities.FinancialOperation;
import ru.anrivlev.personal_finances.entities.UserWallet;
import ru.anrivlev.personal_finances.model.UserWalletFinancialInformation;
import ru.anrivlev.personal_finances.repo.FinancialOperationRepository;

import java.util.List;

@Service
public class FinancialOperationService {
    @Autowired
    FinancialOperationRepository financialOperationRepository;

    public FinancialOperation save(FinancialOperation financialOperation) {
        return financialOperationRepository.save(financialOperation);
    }

    public List<FinancialOperation> getAllByUserWalletId(Integer userWalletId) {
        return financialOperationRepository.findAllByUserWalletId(userWalletId);
    }

    public UserWalletFinancialInformation getFinancialInformationFilteredByCategory(
            UserWallet userWallet
    ) {
        List<FinancialOperation> financialOperations = financialOperationRepository.findAllByUserWalletId(userWallet.getId());
        UserWalletFinancialInformation userWalletFinancialInformation = new UserWalletFinancialInformation();
        for (FinancialOperation financialOperation : financialOperations) {
            userWalletFinancialInformation.add(
                    financialOperation.getCategory(),
                    financialOperation.getFinancialValue()
            );
        }
        return userWalletFinancialInformation;
    }

    public UserWalletFinancialInformation getFinancialInformationFilteredByCategory(
            UserWallet userWallet,
            List<String> categories
    ) {
        List<FinancialOperation> financialOperations = financialOperationRepository.findAllByUserWalletIdAndCategoryIn(
                userWallet.getId(), categories
        );
        UserWalletFinancialInformation userWalletFinancialInformation = new UserWalletFinancialInformation();
        for (FinancialOperation financialOperation : financialOperations) {
            userWalletFinancialInformation.add(
                    financialOperation.getCategory(),
                    financialOperation.getFinancialValue()
            );
        }
        return userWalletFinancialInformation;
    }
}
