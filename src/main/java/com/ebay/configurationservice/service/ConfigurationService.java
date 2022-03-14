package com.ebay.configurationservice.service;


import com.ebay.configurationservice.model.Configuration;
import com.ebay.configurationservice.repository.ConfigurationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigurationService {
    private static final Logger LOGGER = LogManager.getLogger(ConfigurationService.class);
    @Autowired
    ConfigurationRepository configurationRepository;

    /**
     * add new map object
     *
     * @param key   key
     * @param value value
     * @return true if succeed
     */
    public boolean add(String key, String value) {
        LOGGER.info("New configuration object");
        Configuration configuration = new Configuration(key, value);
        LOGGER.info("Add to database");
        configurationRepository.save(configuration);
        return true;
    }

    /**
     * get value by key
     *
     * @param key key
     * @return value
     */
    public String get(String key) {
        LOGGER.info("Search in config database by key");
        Optional<Configuration> configuration = configurationRepository.findById(key);
        LOGGER.info("Checks if exist");
        if (configuration.isPresent()) {
            return configuration.get().getValue();
        }
        LOGGER.error("Key not existed");
        return "null";
    }
}
