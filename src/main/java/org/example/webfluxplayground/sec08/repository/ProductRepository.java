package org.example.webfluxplayground.sec08.repository;

import org.example.webfluxplayground.sec08.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

}
