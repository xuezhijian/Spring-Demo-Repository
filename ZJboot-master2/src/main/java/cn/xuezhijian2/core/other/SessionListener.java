package cn.xuezhijian2.core.other;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.other
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午3:25
 * Description  : session监听器
 */

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        //System.out.println(arg0.getSession().getId() + "创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        //System.out.println(arg0.getSession().getId() + "销毁");
    }
}

