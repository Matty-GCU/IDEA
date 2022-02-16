package loginlogout;

import org.junit.jupiter.api.Test;

class PassagerServiceTest {

    @Test
    void prepareInfo() {
        PassagerService service = new PassagerService();
        service.register("13417141111", "Matty", "123456");
        service.register("15876591111", "Swan", "whss");
        service.login("13417141111", "123456");
        service.login("15876591111", "whss");
    }

}