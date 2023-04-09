package com.pro.shop.controller;

import com.pro.shop.request.RegisterRequest;
import com.pro.shop.service.RegisterService;
import com.pro.shop.response.AuthenticationResponse;
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
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @Valid @RequestBody RegisterRequest request
    ) throws Exception {
        return ResponseEntity.ok(registerService.register(request, AccountType.ADMIN));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody RegisterRequest request
    ) throws Exception {
        return ResponseEntity.ok(registerService.register(request, AccountType.CUSTOMER));
    }

}
