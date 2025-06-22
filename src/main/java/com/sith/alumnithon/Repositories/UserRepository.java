package com.sith.alumnithon.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sith.alumnithon.Models.User.Role;
import com.sith.alumnithon.Models.User.User;

@Repository
public interface UserRepository  extends JpaRepository <User, Long>{
    Optional<User> findByUsername(String username);
    User findByIdAndRole(Long id, Role role);
}
