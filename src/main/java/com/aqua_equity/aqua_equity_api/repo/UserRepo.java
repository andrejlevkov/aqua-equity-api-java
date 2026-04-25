package com.aqua_equity.aqua_equity_api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aqua_equity.aqua_equity_api.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
