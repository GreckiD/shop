package com.pro.shop.register;

import com.pro.shop.auth.AuthenticationResponse;
import com.pro.shop.config.JwtService;
import com.pro.shop.users.AccountType;
import com.pro.shop.users.User;
import com.pro.shop.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public AuthenticationResponse register(RegisterRequest request, AccountType accountType) {
        User user = User.builder()
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountType(accountType)
                .build();
        usersRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
