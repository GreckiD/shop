package com.pro.shop.integration.users;

import com.pro.shop.users.AccountType;
import com.pro.shop.users.User;
import com.pro.shop.users.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void findUserByLoginTest() {
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