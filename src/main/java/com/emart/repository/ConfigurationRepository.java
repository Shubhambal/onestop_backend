package com.emart.repository;

import com.emart.entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for managing Configuration entities.
 */
@Repository
@Transactional
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {

	// No additional methods to be added in this interface
}

