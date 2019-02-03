package com.isima.blablacampus.security.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.isima.blablacampus.security.model.VerificationToken;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long>{

	Optional<VerificationToken> findByToken(String token);
}
