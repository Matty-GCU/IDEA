package chapter09.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Matty
 **/
@WebServlet("/Hw10/ControllerServlet")
public class Hw10_ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        if(name.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            response.sendRedirect("/WebDemo/chapter09_servlet/Hw10_WelcomePage.jsp");
        }
        else {
            request.setAttribute("message", "用户名" + name + "与密码" + password + "不符");
            request.getRequestDispatcher("/chapter09_servlet/Hw10_LoginForm.jsp").forward(request, response);
        }
    }
}
