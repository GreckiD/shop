package com.pro.shop.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}
