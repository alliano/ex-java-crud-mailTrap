package com.bootstrap.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootstrap.models.entities.Product;


public @Repository interface Productrepository extends JpaRepository<Product,Long> {
   
   public List<Product> findByNameContains(String name);
}
