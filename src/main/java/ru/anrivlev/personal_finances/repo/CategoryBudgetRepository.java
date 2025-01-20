package ru.anrivlev.personal_finances.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anrivlev.personal_finances.entities.CategoryBudget;

@Repository
public interface CategoryBudgetRepository extends JpaRepository<CategoryBudget, Integer> {
}
