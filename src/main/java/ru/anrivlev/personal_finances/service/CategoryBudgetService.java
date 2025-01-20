package ru.anrivlev.personal_finances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anrivlev.personal_finances.entities.CategoryBudget;
import ru.anrivlev.personal_finances.repo.CategoryBudgetRepository;

@Service
public class CategoryBudgetService {
    @Autowired
    CategoryBudgetRepository categoryBudgetRepository;

    public CategoryBudget save(CategoryBudget categoryBudget) {
        return categoryBudgetRepository.save(categoryBudget);
    }
}
