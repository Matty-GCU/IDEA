package chapter09.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Matty
 **/
@WebFilter("/chapter09_servlet/Hw10_WelcomePage.jsp")
public class Hw10_Filter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行了作业10过滤器的doFilter()方法");
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();
        String name = session.getAttribute("name").toString();
        if(name == null || name.equals("")) {
            request.getRequestDispatcher("/chapter09_servlet/Hw10_LoginForm.jsp").forward(request, response);
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
