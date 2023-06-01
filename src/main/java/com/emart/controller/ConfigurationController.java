package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Configuration;
import com.emart.exception.ConfigurationNotFoundException;
import com.emart.services.ConfigurationManager;

/**
 * The ConfigurationController class handles the API endpoints related to Configuration operations.
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class ConfigurationController {

    @Autowired
    ConfigurationManager manager;

    /**
     * Retrieves all configurations.
     *
     * @return ResponseEntity with the list of Configuration objects if they exist,
     *         or a no content response if no configurations are found.
     */
    @GetMapping(value = "api/configurations")
    public ResponseEntity<List<Configuration>> getConfigurations() {
        List<Configuration> configurations = manager.getConfigurations();
        if (configurations.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(configurations);
        }
    }

    /**
     * Retrieves a specific configuration by its ID.
     *
     * @param cid The ID of the configuration to retrieve.
     * @return ResponseEntity with the Configuration if found,
     *         or throws ConfigurationNotFoundException if the configuration is not found.
     */
    @GetMapping(value = "api/configurationById/{cid}")
    public ResponseEntity<Configuration> getConfiguration(@PathVariable int cid) {
        Optional<Configuration> configuration = manager.getConfiguration(cid);
        return configuration.map(ResponseEntity::ok).orElseThrow(() ->
                new ConfigurationNotFoundException("Configuration not found with cid: " + cid));
    }

    /**
     * Removes a configuration by its ID.
     *
     * @param cid The ID of the configuration to remove.
     * @return ResponseEntity with a success message if the configuration is deleted successfully,
     *         or an error message if the configuration deletion fails.
     */
    @DeleteMapping(value = "api/configurations/{cid}")
    public ResponseEntity<String> removeConfiguration(@PathVariable int cid) {
        try {
            manager.delete(cid);
            return ResponseEntity.ok("Configuration deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete configuration: " + e.getMessage());
        }
    }

    /**
     * Adds a new configuration.
     *
     * @param config The Configuration object to add.
     * @return ResponseEntity with a success message if the configuration is added successfully,
     *         or an error message if the configuration addition fails.
     */
    @PostMapping(value = "api/configurations")
    public ResponseEntity<String> addConfiguration(@RequestBody Configuration config) {
        try {
            manager.addConfiguration(config);
            return ResponseEntity.ok("Configuration added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add configuration: " + e.getMessage());
        }
    }
}
