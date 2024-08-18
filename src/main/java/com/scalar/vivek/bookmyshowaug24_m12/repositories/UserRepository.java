package com.scalar.vivek.bookmyshowaug24_m12.repositories;

import com.scalar.vivek.bookmyshowaug24_m12.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

}
