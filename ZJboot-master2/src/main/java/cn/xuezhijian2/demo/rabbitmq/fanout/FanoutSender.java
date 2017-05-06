package cn.xuezhijian2.demo.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.fanout
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:05
 * Description  :
 */

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout 群发消息!";
        System.out.println("Fanout Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

}