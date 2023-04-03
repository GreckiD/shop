package com.pro.shop.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void findByLogin() {
        String login = "Admin";
        User user = User
                .builder()
                .login(login)
                .password("admin")
                .email("admin@example.com")
                .accountType(AccountType.ADMIN)
                .build();
        usersRepository.save(user);
        assertEquals(usersRepository.findByLogin(login), user, "Bad user");

    }
}