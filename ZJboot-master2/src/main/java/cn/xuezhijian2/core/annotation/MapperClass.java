package cn.xuezhijian2.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zj on 17/4/15.
 */

@SuppressWarnings("unchecked")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperClass {

    /**
     *指定 MapperClass
     */
    Class value();
}
