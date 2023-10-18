package org.ncu.hirewheels.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ncu.hirewheels.entities.User;

import jakarta.persistence.*;
import java.util.Optional;

@Repository
@Transactional
public abstract class UserDaoimpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByFirstNameIgnoreCase(String firstName) {
        String jpql = "SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(:firstName)";
        return Optional.ofNullable(entityManager.createQuery(jpql, User.class)
                .setParameter("firstName", firstName)
                .getSingleResult());
    }

    @Override
    public Optional<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName) {
        String jpql = "SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(:firstName) OR LOWER(u.lastName) = LOWER(:lastName)";
        return Optional.ofNullable(entityManager.createQuery(jpql, User.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getSingleResult());
    }

    @Override
    public Optional<User> findByEmailIgnoreCase(String email) {
        String jpql = "SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)";
        return Optional.ofNullable(entityManager.createQuery(jpql, User.class)
                .setParameter("email", email)
                .getSingleResult());
    }

    @Override
    public Optional<User> findByMobileNumberIgnoreCase(String mobileNumber) {
        String jpql = "SELECT u FROM User u WHERE LOWER(u.mobileNumber) = LOWER(:mobileNumber)";
        return Optional.ofNullable(entityManager.createQuery(jpql, User.class)
                .setParameter("mobileNumber", mobileNumber)
                .getSingleResult());
    }
}
