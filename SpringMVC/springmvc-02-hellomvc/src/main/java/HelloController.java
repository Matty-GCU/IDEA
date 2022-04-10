import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Base Controller interface,
 * representing a component that receives HttpServletRequest and HttpServletResponse instances
 * just like a HttpServlet but is able to participate in an MVC workflow.
 */
public class HelloController implements Controller {
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        
        // 业务代码
        String result = "Hello SpringMVC!";
        modelAndView.addObject("result", result);
        // 设置视图名称
        modelAndView.setViewName("hello");
        
        return modelAndView;
    }
    
}