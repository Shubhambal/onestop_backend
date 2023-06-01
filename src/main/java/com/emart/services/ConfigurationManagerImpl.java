package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Configuration;
import com.emart.repository.ConfigurationRepository;

@Service
public class ConfigurationManagerImpl implements ConfigurationManager {

	@Autowired
	ConfigurationRepository repository;
	
	/**
	 * Add a new configuration.
	 * 
	 * @param c The configuration to be added.
	 */
	@Override
	public void addConfiguration(Configuration c) {
		repository.save(c);
	}
	
	/**
	 * Get all configurations.
	 * 
	 * @return The list of configurations.
	 */
	@Override
	public List<Configuration> getConfigurations() {
		return repository.findAll();
	}
	
	/**
	 * Delete a configuration by ID.
	 * 
	 * @param id The ID of the configuration to be deleted.
	 */
	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	/**
	 * Get a configuration by ID.
	 * 
	 * @param id The ID of the configuration.
	 * @return An optional containing the configuration, or an empty optional if not found.
	 */
	@Override
	public Optional<Configuration> getConfiguration(int id) {
		return repository.findById(id);
	}
}
