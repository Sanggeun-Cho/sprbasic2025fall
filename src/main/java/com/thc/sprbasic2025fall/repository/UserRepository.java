package com.thc.sprbasic2025fall.repository;

import com.thc.sprbasic2025fall.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByNick(String nick);
    User findByUsernameAndPassword(String username, String password);
}
