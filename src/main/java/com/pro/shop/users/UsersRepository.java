package com.pro.shop.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    @Query(value = """
            SELECT
                CASE WHEN EXISTS(
                    SELECT * FROM users WHERE login = ?1
                )
                THEN true
                ELSE false
            END""",
            nativeQuery = true
    )
    boolean existsByLogin(String login);

}
