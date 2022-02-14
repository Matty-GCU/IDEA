package customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassagerServiceTest {

    @Test
    void register() {
        PassagerService service = new PassagerService();
        System.out.println(service.register("13417143272", "小吴", "123456"));
    }

    @Test
    void login() {
        PassagerService service = new PassagerService();
        System.out.println(service.login("13417143272", "123456"));
    }
}