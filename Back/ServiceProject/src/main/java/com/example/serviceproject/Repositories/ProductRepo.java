package com.example.serviceproject.Repositories;

import com.example.serviceproject.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
}
