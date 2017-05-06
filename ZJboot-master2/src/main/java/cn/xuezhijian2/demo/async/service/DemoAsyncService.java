package cn.xuezhijian2.demo.async.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.async.service
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午1:36
 * Description  :
 */

public interface DemoAsyncService {

    @Async
    public Future<String> doTaskOne() throws Exception;

    @Async
    public Future<String> doTaskTwo() throws Exception;

    @Async
    public Future<String> doTaskThree() throws Exception;

}
