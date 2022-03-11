package com.gijo.sts.twitter.to.kafka.service;

import com.gijo.sts.twitter.to.kafka.service.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private final AppConfig appConfig;

    public TwitterToKafkaServiceApplication(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public static void main(String[] args){
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Twitter to kafka service started");
        for(String key:appConfig.getTwitterKeywords()){
            log.info("keyword {}", key);
        }

    }
}
