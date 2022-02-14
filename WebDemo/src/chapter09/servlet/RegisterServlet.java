package chapter09.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<title>RegisterServlet</title>");
        String stuName = request.getParameter("stuName");
        System.out.println("学生姓名：" + stuName);
        while(true) {
            for(long i = 0; i < 10000000000000000L; i++) {

            }
            printWriter.println("test11111111111");
        }
    }
}
