package servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class ServletTest extends HttpServlet{
    public ServletTest() {
        System.out.println("WelcomeTest构造方法");
    }

    //获取request对象和response对象：
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("WelcomeTest.doGet()方法");
        //获取out对象
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("嘿！你好呀");
        //获取session对象
        HttpSession session = request.getSession();
        //获取application对象
        ServletContext application = getServletContext();

        //用这种方法跳转，如果写绝对路径，要写虚拟目录的根目录
//        response.sendRedirect("/WebDemo_war_exploded/index.jsp");

        //用这种方法跳转，如果写绝对路径，不需要写虚拟目录的根目录
//        RequestDispatcher requestDispatcher = application.getRequestDispatcher("/index.jsp");
//        requestDispatcher.forward(request, response);
    }
}
