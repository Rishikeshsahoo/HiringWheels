package org.ncu.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ncu.hirewheels.entities.User;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByFirstNameIgnoreCase(String firstName);

    Optional<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);

    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByMobileNumberIgnoreCase(String mobileNumber);
}