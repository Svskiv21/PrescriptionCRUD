package com.example.PrescriptionCRUD.repositories;

import com.example.PrescriptionCRUD.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
