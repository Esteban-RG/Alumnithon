package com.sith.alumnithon.repositories;

import java.util.Optional;

import com.sith.alumnithon.models.User.Role;
import com.sith.alumnithon.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository <User, Long>{
    Optional<User> findByUsername(String username);
    User findByIdAndRole(Long id, Role role);
}
