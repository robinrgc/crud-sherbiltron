package com.tyss.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
