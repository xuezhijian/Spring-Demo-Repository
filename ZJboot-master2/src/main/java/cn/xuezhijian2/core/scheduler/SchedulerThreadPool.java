package cn.xuezhijian2.core.scheduler;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ScheduledFuture;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.httpClient
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午3:15
 * Description  : 定时任务线程池
 */

@Component(value="SchedulerThreadPool")
public class SchedulerThreadPool {

    // 定时任务线程池实体
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    /**
     * 初始化方法
     */
    @PostConstruct
    private void Initialization() {
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        // 设置池中的线程数
        threadPoolTaskScheduler.setPoolSize(50);
        // 初始化
        threadPoolTaskScheduler.initialize();
    }

    /**
     * 销毁方法
     */
    @PreDestroy
    private void DestroyAtLast() {
        if (threadPoolTaskScheduler != null) {
            threadPoolTaskScheduler.destroy();
        }
    }

    /**
     * 运行
     * @param task
     * @param trigger
     * @return
     */
    public ScheduledFuture<?> ScheduleInPool(Runnable task, Trigger trigger) {
        return threadPoolTaskScheduler.schedule(task, trigger);
    }
}

