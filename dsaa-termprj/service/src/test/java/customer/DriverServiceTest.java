package customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceTest {

    @Test
    void register() {
        DriverService service = new DriverService();
        System.out.println(service.register("13692029409", "司机老吴", "888888", 10));
    }

    @Test
    void test() {
        DriverService service = new DriverService();
        System.out.println(service.login("13692029409", "888888"));
    }
}