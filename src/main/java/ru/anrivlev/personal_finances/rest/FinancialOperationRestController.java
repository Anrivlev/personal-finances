package ru.anrivlev.personal_finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.anrivlev.personal_finances.service.FinancialOperationService;

@RestController
public class FinancialOperationRestController {
    @Autowired
    FinancialOperationService financialOperationService;
}
