package com.pro.shop.controller;

import com.pro.shop.product.Product;
import com.pro.shop.product.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsRepository repository;

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(repository.getByName(name));
    }

}
