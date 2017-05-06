package com.xuezhijian;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.xuezhijian.shiro.MyExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/13
 * Time         : 下午10:48
 * Description  : 作者：qq746753491
 * 权限数据库我只是设计简单的，复杂的你们自己去思考，sql文件在static里面，测试帐号：qq746753491  密码：123456
 * 我实现了记住我，验证码，缓存功能，权限自定义（or）等，我自己的项目有更多的实现，比如一个用户一段时间内不能连续登录等等功能，后续需要再发出来
 * 这里已经够你们用了，作者最近也在使用spring cloud 欢迎大家加q讨论
 *
 * 还有，加密方式的生成，我写在项目的单元测试里面，可以看看,注册你们自己去实现。
 */

@SpringBootApplication
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }


    //配置kaptcha图片验证码框架提供的Servlet,,这是个坑,很多人忘记注册(注意)
    @Bean
    public ServletRegistrationBean kaptchaServlet(){
        ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(), "/kaptcha.jpg");
        servlet.addInitParameter(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_CONFIG_KEY,
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);//session key
        servlet.addInitParameter(com.google.code.kaptcha.Constants.KAPTCHA_IMAGE_HEIGHT,"60");//高度
        servlet.addInitParameter(com.google.code.kaptcha.Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE,"50");//字体大小
        //可以设置很多属性,具体看com.google.code.kaptcha.Constants
//		kaptcha.border  是否有边框  默认为true  我们可以自己设置yes，no
//		kaptcha.border.color   边框颜色   默认为Color.BLACK
//		kaptcha.border.thickness  边框粗细度  默认为1
//		kaptcha.producer.impl   验证码生成器  默认为DefaultKaptcha
//		kaptcha.textproducer.impl   验证码文本生成器  默认为DefaultTextCreator
//		kaptcha.textproducer.char.string   验证码文本字符内容范围  默认为abcde2345678gfynmnpwx
//		kaptcha.textproducer.char.length   验证码文本字符长度  默认为5
//		kaptcha.textproducer.font.names    验证码文本字体样式  默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
//		kaptcha.textproducer.font.size   验证码文本字符大小  默认为40
//		kaptcha.textproducer.font.color  验证码文本字符颜色  默认为Color.BLACK
//		kaptcha.textproducer.char.space  验证码文本字符间距  默认为2
//		kaptcha.noise.impl    验证码噪点生成对象  默认为DefaultNoise
//		kaptcha.noise.color   验证码噪点颜色   默认为Color.BLACK
//		kaptcha.obscurificator.impl   验证码样式引擎  默认为WaterRipple
//		kaptcha.word.impl   验证码文本字符渲染   默认为DefaultWordRenderer
//		kaptcha.background.impl   验证码背景生成器   默认为DefaultBackground
//		kaptcha.background.clear.from   验证码背景颜色渐进   默认为Color.LIGHT_GRAY
//		kaptcha.background.clear.to   验证码背景颜色渐进   默认为Color.WHITE
//		kaptcha.image.width   验证码图片宽度  默认为200
//		kaptcha.image.height  验证码图片高度  默认为50
        return servlet;
    }

    //注入异常处理类
    @Bean
    public MyExceptionResolver myExceptionResolver(){
        return new MyExceptionResolver();
    }
}
