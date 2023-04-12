package com.pro.shop.admin.product;

import com.pro.shop.category.Category;
import com.pro.shop.category.CategoryRepository;
import com.pro.shop.product.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product addProduct(String name, String desc, int quantity, List<Long> categoriesIds) {
        List<Category> categories = categoryRepository.getCategoriesByIds(categoriesIds);

        Product product = Product.builder()
                .name(name)
                .description(desc)
                .quantity(quantity)
                .categories(categories)
                .build();

        entityManager.persist(product);
        return product;
    }

}
