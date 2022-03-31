package textbook.chapter06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import textbook.chapter06.service.DriverService;

@Controller
public class DriverController {
    @Autowired
    DriverService driverService;
    
    public void test() {
        driverService.test();
    }
}
