package cn.xuezhijian2.demo.rabbitmq.direct.hello;

import cn.xuezhijian2.core.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.hello
 * User         : zj
 * Date         : 17/4/22
 * Time         : 上午11:55
 * Description  :
 */

@Component
public class HelloSender implements RabbitTemplate.ConfirmCallback{

    private RabbitTemplate rabbitTemplate;

    /**
     * 配置发送消息的rabbitTemplate，因为是构造方法，所以不用注解Spring也会自动注入（应该是新版本的特性）
     * @param rabbitTemplate
     */
    @Autowired
    public HelloSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        //设置消费回调
        this.rabbitTemplate.setConfirmCallback(this);
    }


    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);

        this.rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE,
                "hello_queue_key", context,correlationId);
    }

    /**
     * 消息的回调，主要是实现RabbitTemplate.ConfirmCallback接口
     * 注意，消息回调只能代表成功消息发送到RabbitMQ服务器，不能代表消息被成功处理和接受
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause+"\n重新发送");
        }
    }

}
