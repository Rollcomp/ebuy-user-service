package org.ebuy.userservice.repository;

import org.ebuy.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

}
