package com.duong.ss04_homeworks.repository.hw03;

import com.duong.ss04_homeworks.entity.FoodItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    @Query(""" 
            select f from FoodItem f where 
                        (:keyword is null or lower(f.name) like lower(concat('%', :keyword, '%') )) and
                        (:categoryId is null or f.category.id = :categoryId)
            """)
    Page<FoodItem> search(@Param("keyword") String keyword,
                          @Param("categoryId") Integer categoryId,
                          Pageable pageable);


}