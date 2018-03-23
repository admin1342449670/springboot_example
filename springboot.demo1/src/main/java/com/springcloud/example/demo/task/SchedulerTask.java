package com.springcloud.example.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

    private final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    private  static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 6 * 1000)
    public void task1() {
        System.out.println("this is time："+simpleDateFormat.format(new Date()));
        logger.info("日志："+123);
    }

}
