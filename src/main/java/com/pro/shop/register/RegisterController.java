package com.pro.shop.register;

import com.pro.shop.register.RegisterRequest;
import com.pro.shop.register.RegisterService;
import com.pro.shop.users.AccountType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RegisterController {

    @Autowired
    private final RegisterService registerService;

    @PostMapping("/admin-reg")
    public ResponseEntity<Object> registerAdmin(
            @Valid @RequestBody RegisterRequest request
    ) throws Exception {
        return registerService.register(request, AccountType.ADMIN);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return registerService.register(request, AccountType.CUSTOMER);
    }

}
