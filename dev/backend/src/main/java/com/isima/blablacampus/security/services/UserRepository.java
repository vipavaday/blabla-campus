package com.isima.blablacampus.security.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.isima.blablacampus.security.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByEmail(String email);
}
