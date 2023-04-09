package com.pro.shop.integration.admin.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.shop.product.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class AdminProductControllerTest {

    @Autowired
    private ProductsRepository repository;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(authorities = "ADMIN")
    void addProductTest() throws Exception {

        final String name = "Testowy produkt";
        final String description = "Testowy opis";
        final Integer quantity = 999999;

        String jsonBody = """
                {
                    "name": "%s",
                    "description": "%s",
                    "quantity": %s
                }
                """
                .formatted(name, description, quantity);

        this.mockMvc
                .perform(
                        post("/admin/products/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonBody)
                )
                .andExpect(jsonPath("success").value(true))
                .andExpect(jsonPath("id").isNumber());
    }
}