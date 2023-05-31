package com.emart.services;

import java.util.List;
import java.util.Optional;

import com.emart.entities.Configuration;

public interface ConfigurationManager {
	
	/**
	 * Add a new configuration.
	 * 
	 * @param configuration The configuration to be added.
	 */
	void addConfiguration(Configuration configuration);
	
	/**
	 * Get all configurations.
	 * 
	 * @return The list of configurations.
	 */
	List<Configuration> getConfigurations();
	
	/**
	 * Delete a configuration by ID.
	 * 
	 * @param id The ID of the configuration to be deleted.
	 */
	void delete(int id);
	
	/**
	 * Get a configuration by ID.
	 * 
	 * @param id The ID of the configuration.
	 * @return An optional containing the configuration, or an empty optional if not found.
	 */
	Optional<Configuration> getConfiguration(int id);
}
