package com.pro.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> getByName(String name);

}
