package cn.xuezhijian2.demo.email.service.impl;

import cn.xuezhijian2.core.dto.Pair;
import cn.xuezhijian2.core.email.EmailConfig;
import cn.xuezhijian2.core.exception.RuntimeServiceException;
import cn.xuezhijian2.demo.email.service.EmailService;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.email.service.impl
 * User         : zj
 * Date         : 17/4/19
 * Time         : 下午10:15
 * Description  :
 */

@Service
@Profile("dev") //开发环境的时候.
public class DevEmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    public void sendSimpleMail(String sendTo, String titel, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getEmailFrom());
        message.setTo(sendTo);
        message.setSubject(titel);
        message.setText(content);
        mailSender.send(message);
    }

    public void sendAttachmentsMail(String sendTo, String titel, String content, List<Pair<String, File>> attachments) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(titel);
            helper.setText(content);

            for (Pair<String, File> pair : attachments) {
                helper.addAttachment(pair.getLeft(), new FileSystemResource(pair.getRight()));
            }
        } catch (Exception e) {
            throw new RuntimeServiceException(e);
        }

        mailSender.send(mimeMessage);
    }

    public void sendInlineMail() {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo("286352250@163.com");
            helper.setSubject("主题：嵌入静态资源");
            helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

            FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
            helper.addInline("weixin", file);
        } catch (Exception e) {
            throw new RuntimeServiceException(e);
        }

        mailSender.send(mimeMessage);
    }

    public void sendTemplateMail(String sendTo, String titel, Map<String, Object> content, List<Pair<String, File>> attachments) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(titel);

            String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template.vm", "UTF-8", content);
            helper.setText(text, true);

            for (Pair<String, File> pair : attachments) {
                helper.addAttachment(pair.getLeft(), new FileSystemResource(pair.getRight()));
            }
        } catch (Exception e) {
            throw new RuntimeServiceException(e);
        }

        mailSender.send(mimeMessage);
    }

}
