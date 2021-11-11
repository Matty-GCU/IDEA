package chapter09.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author Matty
 **/
@WebFilter(filterName = "FilterTest", urlPatterns = "/index.jsp")
public class FilterTest implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterTest过滤器执行init()方法");
    }

    @Override
    public void destroy() {
        System.out.println("FilterTest过滤器执行destroy()方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterTest过滤器执行doFilter()方法");
        chain.doFilter(request, response);
    }
}
