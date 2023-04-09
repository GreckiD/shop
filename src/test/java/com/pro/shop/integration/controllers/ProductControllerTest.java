package com.pro.shop.integration.controllers;

import com.pro.shop.product.Product;
import com.pro.shop.product.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class ProductControllerTest {

    @Autowired
    private ProductsRepository repository;

    @Autowired
    private MockMvc mockMvc;

    private final String name = "Testowy produkt";
    private final String description = "Testowy opis";
    private final Integer quantity = 999999;

    @BeforeEach
    void setup() {
        Product product = Product
                .builder()
                .name(name)
                .description(description)
                .quantity(quantity)
                .build();
        repository.save(product);
    }


    @Test
    void getProductByNameTest() throws Exception {
        this.mockMvc
                .perform(
                        get("/products/get")
                                .param("name", name)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value(name))
                .andExpect(jsonPath("$.[0].description").value(description))
                .andExpect(jsonPath("$.[0].quantity").value(quantity));
    }
}