package org.ebuy.userservice.repository;

import org.ebuy.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@Repository
public interface UserRepository extends JpaRepository<Long, User> {

}
