package com.example.ogani.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ogani.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    
    @Query("Select c from Category c where c.enable = true")
    List<Category> findALLByEnabled();

    @Query(value = "SELECT Category.*, COUNT(Product.category_id) AS 'numberPro' FROM Product INNER JOIN Category ON Product.category_id = category.id GROUP BY Product.category_id", nativeQuery = true)
    List<Object[]> getProductCountByCategory();
}
