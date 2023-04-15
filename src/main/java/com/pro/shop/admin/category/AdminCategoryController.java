package com.pro.shop.admin.category;

import com.pro.shop.admin.repsonse.IdentifierResponse;
import com.pro.shop.admin.repsonse.MessageResponse;
import com.pro.shop.exception.LogicException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addCategory(
            @Valid @RequestBody AddCategoryRequest request
    ) {
        try {
            long id = categoryService.addCategory(request.getName()).getId();
            return ResponseEntity.ok(
                    new IdentifierResponse(
                            true,
                            id,
                            HttpStatus.OK.value()
                    )
            );
        } catch (LogicException e) {
            return new ResponseEntity<>(
                    new MessageResponse(
                            false,
                            "Too long name!",
                            HttpStatus.BAD_REQUEST.value()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
