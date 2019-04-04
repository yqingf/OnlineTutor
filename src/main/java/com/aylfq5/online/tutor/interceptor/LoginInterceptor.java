package com.aylfq5.online.tutor.interceptor;

import com.aylfq5.online.tutor.constant.UserStatusMsg;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.aylfq5.online.tutor.util.RequestUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 登录拦截器
 * @Author: aylfq5
 * @CreateDate: 2019/4/2 15:03
 * @Version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory
            .getLogger(LoginInterceptor.class);
    @Autowired
    private UserService userService;

    /**
     * 退出后重定向的地址
     */
    private final String kickoutUrl = "/user/toLogin.html";

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception e)
            throws Exception {
        logger.debug("整个请求完成之后调用。DispatcherServlet视图渲染完成之后。（主要是用于进行资源清理工作）");

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object obj, ModelAndView mv)
            throws Exception {
        logger.debug("请求处理之后调用；在视图渲染之前，controller处理之后。");

    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object obj) throws Exception {
        logger.debug("请求到达后台方法之前调用（controller之前）");
        // 1. SecurityUtils获取session中的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null && user.getNumber() != null && null != user.getVersion()) {
            // 2. 获取数据库中的用户数据
            User dataUser = userService.selectByNumber(user.getNumber());
            // 3. 对比session中用户的version和数据库中的是否一致
            if (dataUser != null
                    && null != dataUser.getVersion()
                    && String.valueOf(user.getVersion()).equals(
                    String.valueOf(dataUser.getVersion()))) {
                // 3.1 一样，放行
                return true;
            } else {
                // 3.2 不一样，这里统一做退出登录处理；//TODO 使用redis缓存用户权限数据，根据用户更新、用户权限更新；做对应的处理。
                SecurityUtils.getSubject().logout();
//                isAjaxResponse(request, response);
                if (RequestUtil.getRequestType(request) == 2) {
                    response.sendRedirect(request.getContextPath() + kickoutUrl);
                    RequestUtil.out(response, OnlineTutorResult.build(UserStatusMsg.SystemStatus.UPDATE.getCode(), "您的信息或权限已变更，重新登录后生效！"));
                } else {

                }
            }
        }
        return false;
    }

    private boolean isAjaxResponse(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException {
        // ajax请求
        /**
         * 判断是否已经踢出
         * 1.如果是Ajax 访问，那么给予json返回值提示。
         * 2.如果是普通请求，直接跳转到登录页
         */
        //判断是不是Ajax请求
        if (RequestUtil.getRequestType(request) == 2) {
            logger.debug(getClass().getName() + "，当前用户的信息或权限已变更，重新登录后生效！");
            RequestUtil.out(response, OnlineTutorResult.build(UserStatusMsg.SystemStatus.UPDATE.getCode(), "您的信息或权限已变更，重新登录后生效！"));
        } else {
            // 重定向
            WebUtils.issueRedirect(request, response, kickoutUrl);
        }
        return false;
    }

}
