package cn.xuezhijian2.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.bidekeji.util
 * Company      : 彼得科技
 * User         : zj
 * Date         : 16/12/3
 * Time         : 下午1:14
 * Description  : spring获得bean的工具
 */

@Component(value = "SpringContextBeanUtil")
public class SpringContextBeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 实现了ApplicationContextAware接口，spring在启动的时候会自动注入ApplicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextBeanUtil.context = applicationContext;
    }

    /**
     * 获取bean
     * @param beanName
     *            bean的名字
     * @return
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

}
