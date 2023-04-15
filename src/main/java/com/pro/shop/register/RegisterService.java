package com.pro.shop.register;

import com.pro.shop.admin.repsonse.MessageResponse;
import com.pro.shop.response.Response;
import com.pro.shop.auth.AuthenticationResponse;
import com.pro.shop.service.JwtService;
import com.pro.shop.users.AccountType;
import com.pro.shop.users.User;
import com.pro.shop.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public ResponseEntity<Object> register(RegisterRequest request, AccountType accountType) {
        if (!usersRepository.existsByLogin(request.getLogin())) {
            User user = User.builder()
                    .login(request.getLogin())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .accountType(accountType)
                    .build();
            usersRepository.save(user);
            String jwtToken = jwtService.generateToken(user);
            return ResponseEntity.ok(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build()
            );
        }
        return new ResponseEntity<>(
                new MessageResponse(
                        false,
                        "Login " + request.getLogin() + " is already taken",
                        HttpStatus.NOT_FOUND.value()
                ),
                HttpStatus.NOT_FOUND
        );
    }

}
