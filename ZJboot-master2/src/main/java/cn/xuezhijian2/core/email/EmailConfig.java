package cn.xuezhijian2.core.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.email
 * User         : zj
 * Date         : 17/4/19
 * Time         : 上午3:51
 * Description  :
 */

@Component
public class EmailConfig {

    /**
     * 发件邮箱
     */
    @Value("${spring.mail.username}")
    private String emailFrom;

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

}
