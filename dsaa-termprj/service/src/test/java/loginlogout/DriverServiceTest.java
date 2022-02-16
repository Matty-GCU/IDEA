package loginlogout;

import org.junit.jupiter.api.Test;

class DriverServiceTest {

    @Test
    void prepareInfo() {
        DriverService service = new DriverService();
        service.registerDriver("13692029409", "小王", "111111", 8);
        service.registerDriver("13415178252", "小明", "222222", 16);
        service.registerDriver("13417143272", "小吴", "333333", 3);
        service.registerDriver("15876597212", "小黄", "444444", 2);
        service.registerCar("粤A-123111", "13692029409");
        service.registerCar("粤B-123222", "13415178252");
        service.registerCar("粤C-123333", "13417143272");
        service.registerCar("粤D-123444", "15876597212");
        service.login("13692029409", "111111");
        service.login("13415178252", "222222");
        service.login("13417143272", "333333");
        service.login("15876597212", "444444");
    }

}