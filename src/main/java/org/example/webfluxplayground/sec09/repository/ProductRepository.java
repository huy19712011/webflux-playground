package org.example.webfluxplayground.sec09.repository;

import org.example.webfluxplayground.sec09.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

}
