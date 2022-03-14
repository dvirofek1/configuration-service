package com.ebay.configurationservice.repository;

import com.ebay.configurationservice.model.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, String> {

    String findByKey(String key);
}

