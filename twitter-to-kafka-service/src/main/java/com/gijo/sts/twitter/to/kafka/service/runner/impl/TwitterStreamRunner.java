package com.gijo.sts.twitter.to.kafka.service.runner.impl;

import com.gijo.sts.twitter.to.kafka.service.config.AppConfig;
import com.gijo.sts.twitter.to.kafka.service.listeners.TwitterToKafkaStatusListener;
import com.gijo.sts.twitter.to.kafka.service.runner.StreamRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import java.util.logging.Filter;

@Slf4j
@Component
public class TwitterStreamRunner implements StreamRunner {

    private final TwitterToKafkaStatusListener twitterToKafkaStatusListener;
    private final AppConfig appConfig;

    private TwitterStream twitterStream;

    public TwitterStreamRunner(TwitterToKafkaStatusListener twitterToKafkaStatusListener,
                               AppConfig appConfig) {
        this.twitterToKafkaStatusListener = twitterToKafkaStatusListener;
        this.appConfig = appConfig;
    }

    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterToKafkaStatusListener);
        addFilter();
    }

    private void addFilter() {
        String[] keywords = appConfig.getTwitterKeywords().toArray(new String[0]);

        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
        log.info(" starting filtering twitter status");
    }

    @PreDestroy
    public void shutdown(){
        if(twitterStream!=null){
            log.info("closing twitter stream");
            twitterStream.shutdown();
        }
    }



}
