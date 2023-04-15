package com.pro.shop.admin.category;

import com.pro.shop.category.Category;
import com.pro.shop.category.CategoryRepository;
import com.pro.shop.exception.LogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(String name) throws LogicException {
        if (name.length() > 255) {
            throw new LogicException("Too long name!");
        }
        return categoryRepository.save(
                new Category(name)
        );
    }

}
