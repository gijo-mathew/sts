package com.gijo.sts.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix="twitter-to-kafka-service")
public class AppConfig {

    private List<String> twitterKeywords;
}
