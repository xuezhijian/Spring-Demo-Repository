package com.xuezhijian.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * packageName  : com.xuezhijian.shiro
 * Company      : 彼得科技
 * User         : zj
 * Date         : 17/2/13
 * Time         : 下午11:35
 * Description  : 角色过滤器,为了实现or的效果就使用这个过滤器,shiro默认是and的效果
 */
public class RoleFilter extends RolesAuthorizationFilter {

    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws IOException {

        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }
        for(int i=0;i < rolesArray.length;i++) {
            if(subject.hasRole(rolesArray[i])) {
                return true;
            }
        }
        return false;
    }

}
