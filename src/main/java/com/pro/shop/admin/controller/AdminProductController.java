package com.pro.shop.admin.controller;

import com.pro.shop.admin.request.AddProductRequest;
import com.pro.shop.admin.repsonse.AddProductResponse;
import com.pro.shop.product.Product;
import com.pro.shop.product.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/add")
    public ResponseEntity<AddProductResponse> addProduct(
            @Valid @RequestBody AddProductRequest request
    ) {
        Product product = productsRepository.save(
                Product
                        .builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .quantity(request.getQuantity())
                        .build()
        );
        return ResponseEntity.ok(AddProductResponse
                .builder()
                .success(true)
                .id(product.getId())
                .build()
        );
    }

}
