package com.yan.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component //首先是组件
public class TimerTaskDemo {

    @Scheduled(cron = "0 0 3 * * ? ") //每天晚上3点执行同步任务
    public void AddUserTimerTask(){

    }
}
