package cn.xuezhijian2.demo.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.topic
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:03
 * Description  :
 */

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }

}
