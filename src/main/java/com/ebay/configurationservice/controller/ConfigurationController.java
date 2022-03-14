package com.ebay.configurationservice.controller;

import com.ebay.configurationservice.model.Configuration;
import com.ebay.configurationservice.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {
    @Autowired
    ConfigurationService configurationService;

    /**
     * add new map object
     *
     * @param configuration new configuration object
     * @return true if succeed
     */
    @PostMapping("/add")
    public boolean add(@RequestBody Configuration configuration) {
        return configurationService.add(configuration.getId(), configuration.getValue());
    }

    /**
     * get value by key
     *
     * @param key key
     * @return value
     */
    @GetMapping("/get")
    public String get(@RequestParam("key") String key) {
        return configurationService.get(key);
    }

}
