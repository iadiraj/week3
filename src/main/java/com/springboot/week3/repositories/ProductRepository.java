package com.springboot.week3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.week3.entities.ProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title, Pageable pageable);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
