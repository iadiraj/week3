package com.springboot.week3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.week3.entities.ProductEntity;
import com.springboot.week3.repositories.ProductRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final Integer PAGE_SIZE = 5;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber) {

        return productRepository.findByTitleContainingIgnoreCase(title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy)));
        // return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy,
        // "price"));
        // return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy),
        // Sort.Order.asc("title")));
        // Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
        // return productRepository.findAll(pageable).getContent();

    }

}
