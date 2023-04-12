package com.pro.shop.admin.product;

import com.pro.shop.admin.repsonse.IdentifierResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<IdentifierResponse> addProduct(
            @Valid @RequestBody AddProductRequest request
    ) {
        Long id = productService.addProduct(
                request.getName(),
                request.getDescription(),
                request.getQuantity(),
                request.getCategories()
        ).getId();

        return ResponseEntity.ok(
                IdentifierResponse
                        .builder()
                        .success(true)
                        .id(id)
                        .httpStatusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
