package com.gijo.sts.twitter.to.kafka.service;


import com.gijo.sts.config.AppConfig;
import com.gijo.sts.twitter.to.kafka.service.runner.StreamRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.gijo.sts")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private final AppConfig appConfig;
    private final StreamRunner streamRunner;

    public TwitterToKafkaServiceApplication(AppConfig appConfig,
                                            StreamRunner streamRunner) {
        this.appConfig = appConfig;
        this.streamRunner = streamRunner;
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
        streamRunner.start();
    }

}
