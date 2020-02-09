package com.example.demo.redisTest.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTask {
    private static Logger logger = LoggerFactory.getLogger(PrintTask.class);
    private int i;

//    @Scheduled(cron = "*/5 * * * * ?")
//    public void execute() {
//        logger.info("PrintTask execute times:{}", ++i);
//    }
}
