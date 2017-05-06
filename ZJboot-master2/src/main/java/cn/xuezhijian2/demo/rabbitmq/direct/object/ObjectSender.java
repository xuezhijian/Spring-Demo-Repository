package cn.xuezhijian2.demo.rabbitmq.direct.object;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.direct.object
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:00
 * Description  :
 */

@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Date date) {
        System.out.println("Sender object: " + date.toString());
        this.rabbitTemplate.convertAndSend("object", date);
    }

}
