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
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();
        String name = session.getAttribute("name").toString();
        System.out.println("到这里还是正常的1");
//        if(name == null || name.equals("")) {
//            System.out.println("到这里还是正常的2");
//            request.getRequestDispatcher("/chapter09_servlet/Hw10_WelcomePage.jsp").forward(request, response);
//            return;
//        }
//        else {
            chain.doFilter(request, response);
//        }
    }
}
