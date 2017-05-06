package cn.xuezhijian2.demo.email.service.impl;

import cn.xuezhijian2.core.dto.Pair;
import cn.xuezhijian2.core.email.EmailConfig;
import cn.xuezhijian2.core.exception.RuntimeServiceException;
import cn.xuezhijian2.demo.email.service.EmailService;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;


import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.email.service.impl
 * User         : zj
 * Date         : 17/4/19
 * Time         : 上午3:53
 * Description  :
 */

@Service
@Profile("test")
public class TestEmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;


    @Override
    public void sendSimpleMail(String sendTo, String titel, String content) {

    }

    @Override
    public void sendAttachmentsMail(String sendTo, String titel, String content, List<Pair<String, File>> attachments) {

    }

    @Override
    public void sendTemplateMail(String sendTo, String titel, Map<String, Object> content, List<Pair<String, File>> attachments) {

    }
}
