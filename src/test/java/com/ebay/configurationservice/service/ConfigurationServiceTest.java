package com.ebay.configurationservice.service;

import com.ebay.configurationservice.model.Configuration;
import com.ebay.configurationservice.repository.ConfigurationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigurationServiceTest {
    private static final Logger LOGGER = LogManager.getLogger(ConfigurationServiceTest.class);
    @MockBean
    ConfigurationRepository configurationRepository;
    @Autowired
    ConfigurationService configurationService;

    @Test
    void add() {
        LOGGER.info("assert equals");
        Assertions.assertTrue(configurationService.add("hey", "you"));

    }

    @Test
    void get() {
        Mockito.when(configurationRepository.findById("hey")).thenReturn(Optional.of(new Configuration("hey", "you")));

        LOGGER.info("checks when key exist");
        Assertions.assertEquals("you", configurationService.get("hey"));

        LOGGER.info("checks when key not exist");
        Assertions.assertEquals("null", configurationService.get("what"));


    }
}