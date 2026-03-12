package com.Crud.Crud.repository;

import com.Crud.Crud.model.User; // Correct import path
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Basic CRUD operations are provided by JpaRepository
}
