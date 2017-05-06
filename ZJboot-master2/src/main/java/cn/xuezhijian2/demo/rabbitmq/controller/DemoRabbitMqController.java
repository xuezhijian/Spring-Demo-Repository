package cn.xuezhijian2.demo.rabbitmq.controller;

import cn.xuezhijian2.demo.rabbitmq.direct.hello.HelloSender;
import cn.xuezhijian2.demo.rabbitmq.direct.neo.NeoSender1;
import cn.xuezhijian2.demo.rabbitmq.direct.neo.NeoSender2;
import cn.xuezhijian2.demo.rabbitmq.fanout.FanoutSender;
import cn.xuezhijian2.demo.rabbitmq.direct.object.ObjectSender;
import cn.xuezhijian2.demo.rabbitmq.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.controller
 * User         : zj
 * Date         : 17/4/19
 * Time         : 上午1:55
 * Description  :
 */


@RestController
@RequestMapping(value="/rabbitmq")
public class DemoRabbitMqController {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private ObjectSender objectSender;

    @Autowired
    private NeoSender1 neoSender;

    @Autowired
    private NeoSender2 neoSender2;


    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private TopicSender topicSender;


    @RequestMapping(value = "/helloSender", method = RequestMethod.GET)
    public void helloSender() {
        helloSender.send();
    }


    @RequestMapping(value = "/objectSender", method = RequestMethod.GET)
    public void objectSender() {
        objectSender.send(new Date());
    }

    @RequestMapping(value = "/neoSender", method = RequestMethod.GET)
    public void neoSender() {
        //neoSender.send(1);
        neoSender2.send(2);
    }



    @RequestMapping(value = "/fanoutSender", method = RequestMethod.GET)
    public void fanoutSender() {
        fanoutSender.send();
    }

    @RequestMapping(value = "/topicSender", method = RequestMethod.GET)
    public void topicSender() {
        topicSender.send();
        topicSender.send2();
    }

}
