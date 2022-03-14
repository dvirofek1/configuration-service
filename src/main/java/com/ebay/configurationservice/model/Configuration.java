package com.ebay.configurationservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Configuration")
public class Configuration {

    String id;
    String value;
}
