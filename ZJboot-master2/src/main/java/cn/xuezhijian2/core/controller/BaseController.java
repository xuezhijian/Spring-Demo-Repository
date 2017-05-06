//package cn.xuezhijian2.core.controller;
//
//import cn.xuezhijian2.core.dto.ResultDataDto;
//import cn.xuezhijian2.core.entity.BaseEntity;
//import com.google.gson.Gson;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * packageName  : cn.xuezhijian2.core.controller
// * User         : zj
// * Date         : 17/4/15
// * Time         : 下午3:25
// * Description  :
// */
//
//public class BaseController<T extends BaseEntity> {
//
//    // 异常信息拦截，统一处理返回，为了兼容IE8，用流方式输出
//    @ExceptionHandler(Exception.class)   //在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
//    public void exceptionHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) throws IOException {
//        ResultDataDto resultDataDto = new ResultDataDto(ex);
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write(new Gson().toJson(resultDataDto));
//    }
//
//}
