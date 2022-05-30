package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("before HandlerAdapter invokes the handler");
        HttpSession session = request.getSession();
        System.out.println("===cookies===");
        for (Cookie cookie : request.getCookies()) {
            System.out.println("name=" + cookie.getName());
            System.out.println("value=" + cookie.getValue());
        }
        System.out.println("===cookies===");
        System.out.println("通过客户端传来的request对象中的携带JSESSIONID值的特殊cookie，查找服务端对应该用户的session对象");
        System.out.println(session);
//        session.getAttribute("useName");
        return true;
    }
    
}