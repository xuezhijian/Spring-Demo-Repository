package cn.xuezhijian2.core.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.mybatis
 * User         : zj
 * Date         : 17/4/15
 * Time         : 下午2:43
 * Description  : 类构造器(反射机制)
 */

public class GenericeClassUtils {

	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return null;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return null;
		}

		if (!(params[index] instanceof Class)) {
			return null;
		}
		return (Class) params[index];
	}
}
