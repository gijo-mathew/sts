package com.gijo.sts.twitter.to.kafka.service.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

@Slf4j
@Component
public class TwitterToKafkaStatusListener extends StatusAdapter {

    public void onStatus(Status status){
        log.info("status {} ", status.getText());
    }
}
