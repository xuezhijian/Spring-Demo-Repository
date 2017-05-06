package cn.xuezhijian2.demo.task.service.impl;

import cn.xuezhijian2.demo.task.service.DemoTaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.task.service.impl
 * User         : zj
 * Date         : 17/4/19
 * Time         : 上午1:41
 * Description  : 定时任务例子
 */

@Service
public class DemoTaskServiceImpl implements DemoTaskService {

    private Logger logger = Logger.getLogger(DemoTaskServiceImpl.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 5000)
    public void getTask1() {
        System.out.println("任务1，当前时间：" + dateFormat.format(new Date()));
    }

    //@Scheduled(cron="0/5 * *  * * ? ")
    public void getTask2() {
        System.out.println("任务2，当前时间：" + dateFormat.format(new Date()));
    }

    //@Scheduled(cron="0/5 * *  * * ? ")
    public void getTaskLog4j() {
        logger.info("Log4j，当前时间：" + dateFormat.format(new Date()));
    }

}
