package cn.xuezhijian2.core.threadPool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.bidekeji.util
 * Company      : 彼得科技
 * User         : zj
 * Date         : 16/12/3
 * Time         : 下午1:15
 * Description  :
 */
@Component(value = "ThreadPool")
public class ThreadPool {

    // 线程池实体
    private ThreadPoolTaskExecutor poolTaskExecutor;

    /**
     * 1、 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
     * 2、如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 QueueCapacity未满，那么任务被放入缓冲队列。
     * 3、如果此时线程池中的数量大于corePoolSize，缓冲队列QueueCapacity满，
     * 并且线程池中的数量小于maximumPoolSize， 建新的线程来处理被添加的任务。
     * 4、如果此时线程池中的数量大于corePoolSize，缓冲队列QueueCapacity满，
     * 并且线程池中的数量等于maximumPoolSize， 那么通过
     * handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列QueueCapacity、最大线程
     * maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
     * 5、当线程池中的线程数量大于corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，
     * 线程池可以动态的调整池中的线程数。
     */

    /**
     * 初始化方法
     */
    @PostConstruct
    private void Initialization() {
        poolTaskExecutor = new ThreadPoolTaskExecutor();
        // 线程池所使用的缓冲队列
        poolTaskExecutor.setQueueCapacity(200);
        // 线程池核心线程
        poolTaskExecutor.setCorePoolSize(10);
        // 线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(1000);
        // 线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(30000);
        poolTaskExecutor.initialize();
    }

    /**
     * 销毁方法
     *
     * @throws InterruptedException
     */
    @PreDestroy
    private void DestroyAtLast() throws InterruptedException {
        // 线程池不为空则判断里面是否有活动的线程,必须等待里面的线程跑完才可关闭线程池
        if (poolTaskExecutor != null) {
            for (;;) {
                if (poolTaskExecutor.getActiveCount() == 0) {
                    break;
                }
                //System.out.println("线程池中还有任务。。。请稍等");
                TimeUnit.SECONDS.sleep(5L);
            }
            // 销毁线程池
            poolTaskExecutor.destroy();
        }

    }

    /**
     * 执行线程
     * @param thread
     *            可回调的线程
     * @return
     */
    public ListenableFuture<Long> RunInPool(Callable<Long> thread) {
        if (poolTaskExecutor == null) {
            Initialization();
        }
        return (ListenableFuture<Long>) poolTaskExecutor.submitListenable(thread);
    }
}
