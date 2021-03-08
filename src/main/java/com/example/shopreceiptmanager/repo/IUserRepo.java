package com.example.shopreceiptmanager.repo;

import com.example.shopreceiptmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
}
