package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===before HandlerAdapter invokes the handler(" + handler.getClass().getSimpleName() + ")===");
        // 根据客户端传来的request中的一个带有session id值的cookie，获取存储在服务端的（对应用户的专属）session
        HttpSession session = request.getSession(false);
        if (session == null || Boolean.FALSE.equals(session.getAttribute("isLogin"))) {
            // 用户未登录，本拦截器决定中断原来的执行链，并重定向至登录页面
            System.out.println("each interceptor can decide to abort the execution chain, typically sending an HTTP error or writing a custom response.");
            response.sendRedirect( request.getContextPath() + "/user/toLogin");
            return false;
        }
        // 客户已登录，本拦截器放行，执行链可继续执行
        return true;
    }
    
}