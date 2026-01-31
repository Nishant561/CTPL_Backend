package com.nishant.ctplbackend.repo;

import com.nishant.ctplbackend.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer> {
    Optional<Category> findByProductCategoryTitle(String category);



}
